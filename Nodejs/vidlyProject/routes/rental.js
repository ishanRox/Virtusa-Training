const express = require('express');
const router = express.Router();
const { Rental, validateRentals } = require('../models/rental');
const { Movie } = require('../models/movie')
const { Customer } = require('../models/customer');

router.get('/', async (req, res) => {
    console.log('in get all ');
    const rental = await Rental.find().sort('-dateOut');
    res.send(rental);
});


router.post('/', async (req, res) => {
    const { error } = validateRentals(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    const customer = await Customer.findById(req.body.customerId);
    if (!customer) return res.status(400).send('Invalid customer');

    const movie = await Movie.findById(req.body.movieId);
    if (!movie) return res.status(400).send('Invalid movie');

    if (movie.numberInStock === 0) return res.status(400).send('Movie not in stock');

    let rental = new Rental({
        customer: {
            _id: customer._id,
            name: customer.name,
            phone: customer.phone
        },
        movie: {
            _id: movie.id,
            title: movie.title,
            dailyRentalRate: movie.dailyRentalRate
        }
    }

    );
    //we have 2 seperate operations if something goes wronge 
    // one can happen and miss the other
    rental = await rental.save();
    movie.numberInStock--;
    movie.save();

    res.send(rental);
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