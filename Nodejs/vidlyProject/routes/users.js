const express = require('express');
const router = express.Router();
const { User, validateUser } = require('../models/user');
//lodash utility
const _ = require('lodash');

router.post('/', async (req, res) => {
    const { error } = validateUser(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    //check user is not already registered
    let user = await User.findOne({ email: req.body.email });
    if (user) {
        return res.status(400).send('user already registerd .');
    }
    // user = new User({
    //     name: req.body.name,
    //     email: req.body.email,
    //     password: req.body.password
    // });

    // user = new User(_.pick(req.body,['name','email','password']));
    //used destructuring insted of lodash
    const { name, email, password } = req.body;
    user = new User({ name, email, password });

    await user.save();

    //used destructuring insted of lodash
    //res.send(_.pick(user, ['_id', 'name', 'email']));
    const { _id } = user;
    res.send({ _id, name, email });

});



module.exports = router;