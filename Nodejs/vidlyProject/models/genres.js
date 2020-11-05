const mongoose = require('mongoose');
const joi = require('joi');

const genreSchema = new mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
            minlength: 5,
            maxlength: 50
        }
    }
)
const Genre = new mongoose.model('Genre', genreSchema);


//const genres = ['sci sfi', 'crimde', 'love', 'adult', 'nolan legend'];

function validateGenres(genre) {
    const schema = { name: joi.string().min(4).required() };
    return joi.validate(genre, schema);
}

exports.genreSchema = genreSchema;
exports.Genre = Genre;
exports.validateGenres = validateGenres;