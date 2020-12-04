const mongoose = require('mongoose');
const joi = require('joi');
const jwt = require('jsonwebtoken');
const config = require('config');

const userSchema =new  mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
            minlength: 5,
            maxlength: 50
        },
        email: {
            type: String,
            required: true,
            minlength: 5,
            maxlength: 255,
            unique: true
        },
        password: {
            type: String,
            required: true,
            minlength: 5,
            maxlength: 1000
        }
    }
);

userSchema.methods.generateAuth = function () {
    const token = jwt.sign({
        _id: this._id
    }, config.get('jwtPrivateKey'));

    return token;
};

const User =  mongoose.model('Users', userSchema);

//const genres = ['sci sfi', 'crimde', 'love', 'adult', 'nolan legend'];

function validateUser(user) {
    const schema = {
        name: joi.string().min(5).max(50).required(),
        email: joi.string().min(5).max(255).required().email(),
        password: joi.string().min(5).max(255).required(),

    };
    return joi.validate(user, schema);
}


exports.User = User;
exports.validateUser = validateUser;