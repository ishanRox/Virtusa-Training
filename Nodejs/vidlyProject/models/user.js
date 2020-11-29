const mongoose = require('mongoose');
const joi = require('joi');


const User = new mongoose.model('Users', new mongoose.Schema(
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
            maxlength:1000 
        }
    }
));


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