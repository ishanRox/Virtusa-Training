
const mongoose = require('mongoose');
const express = require('express');
const router = express.Router();
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

router.get('/', async (req, res) => {
    console.log('in get all ');
    const genres = await Genre.find().sort('name');
    res.send(genres);
});


router.post('/', async (req, res) => {
    const { error } = validateGenres(req.body);
    if (error) return res.status(400).send(error.details[0].message);
    console.log(req.body);
    let genre = new Genre({ name: req.body.name });
    genre = await genre.save();
    res.send(genre);
});

router.put('/:id', async (req, res) => {

    const { error } = validateGenres(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    const genre = Genre.findByIdAndUpdate(req.params.id, { name: req.body.name }, {
        new: true
    });

    //    let genre = genres[req.params.id];
    if (!genre) return res.status(400).send('not found');
    // genres.splice(req.params.id, 1, req.body.name);
    res.send(genre);
});

router.delete('/:id', (req, res) => {
    const genre = Genre.findByIdAndRemove(req.params.id);
    //    let genre = genres[req.params.id];
    if (!genre) return res.status(400).send('not found');
    //    genres.splice(req.params.id, 1);
    res.send(genres);
});;

module.exports = router;