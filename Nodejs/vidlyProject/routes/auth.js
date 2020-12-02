const express = require('express');
const router = express.Router();
const joi = require('joi');
const bcrypt = require('bcrypt');
const { User } = require('../models/user');
const jwt = require('jsonwebtoken');
const config = require('config');

router.post('/', async (req, res) => {
    const { error } = validate(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    //check user is not already registered
    let user = await User.findOne({ email: req.body.email });
    if (!user) {
        return res.status(400).send('Password or email is incorrect 1111 !');
    }

    //rehash the pass so we give it the normal pass and salted hash we got through the db and 
    //bcrypt extract salt from the hashed one and hash the given normal pass 
    const validPassword = await bcrypt.compare(req.body.password, user.password);
    if (!validPassword) {
        return res.status(400).send('Password or email is incorrect 22!');
    }

    const token =  jwt.sign({
        _id: user._id
    }, config.get('jwtPrivateKey'));
    res.send(token);
});



function validate(request) {
    const schema = {
        email: joi.string().min(5).max(255).required().email(),
        password: joi.string().min(5).max(255).required(),

    };
    return joi.validate(request, schema);
}

module.exports = router;