const mongoose = require('mongoose');
const joi = require('joi');
const { genreSchema } = require('./genres');

const Genre = new mongoose.model('Movies', new mongoose.Schema(
    {
        title: {
            type: String,
            required: true,
            trim: true,
            minlength: 5,
            maxlength: 50
        },
        genre: {
            type: genreSchema,
            required: true
        },
        numberInStock: {
            type: Number,
            required: true,
            min: 0,
            max: 255
        },
        dailyRentalRate: {
            type: Number,
            required: true,
            min: 0,
            max: 255
        }
    }
));

//const genres = ['sci sfi', 'crimde', 'love', 'adult', 'nolan legend'];

function validateMovie(movie) {
    //joi schema is what the client send us
    const schema = {
        title: joi.string().min(5).max(50).required(),
        genreId: joi.string().required(),
        numberInStock: joi.number().min(0).required(),
        dailyRentalRate: joi.number().min(0).required()

    };
    return joi.validate(movie, schema);
}

exports.Movie = Genre;
exports.validateMovie = validateMovie;