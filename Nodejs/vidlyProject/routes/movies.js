const express = require('express');
const router = express.Router();
const { Movie, validateMovie } = require('../models/movie');
const { Genre } = require('../models/genres');

router.get('/', async (req, res) => {
    console.log('in get all ');
    const movie = await Movie.find().sort('name');
    res.send(movie);
});


router.post('/', async (req, res) => {
    const { error } = validateMovie(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    //embedded eke aththatama thiyenawada balanawa
    const genre = await Genre.findById(req.body.genreId);
    if (!genre) return res.status(400).send(error.details[0].message);


    //we dont put genre=genre  here because in real life 
    //genre object may have 50 properties
    //and we cant track versioning changes

    console.log(req.body);
    let movie = new Movie({
        title: req.body.title,
        genre: {
            _id: genre._id,
            name: genre.name
        },
        numberInStock: req.body.numberInStock,
        dailyRentalRate: req.body.dailyRentalRate
    });
    movie = await movie.save();
    res.send(movie);
});

router.put('/:id', async (req, res) => {
    console.log(req.body);
    console.log(req.params.id);
    const { error } = validateMovie(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    const genre = await Genre.findByIdAndUpdate(req.params.id, { name: req.body.name }, {
        new: true
    });

    //    let genre = genres[req.params.id];
    if (!genre) return res.status(400).send('not found');
    // genres.splice(req.params.id, 1, req.body.name);
    res.send(genre);
});

router.delete('/:id', async (req, res) => {
    const genre = await Genre.findByIdAndRemove(req.params.id);
    //    let genre = genres[req.params.id];
    if (!genre) return res.status(400).send('not found');
    //    genres.splice(req.params.id, 1);
    res.send(genre);
});;

module.exports = router;