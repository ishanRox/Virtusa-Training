const mongoose = require('mongoose');
const joi = require('joi');


const Genre = new mongoose.model('Genre', new mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
            minlength: 5,
            maxlength: 50
        }
    }
));

//const genres = ['sci sfi', 'crimde', 'love', 'adult', 'nolan legend'];

function validateGenres(genre) {
    const schema = { name: joi.string().min(4).required() };
    return joi.validate(genre, schema);
}

exports.Genre=Genre;
exports.validateGenres=validateGenres;