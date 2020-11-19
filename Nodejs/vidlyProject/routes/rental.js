const express = require('express');
const router = express.Router();
const { Rental, validateRentals } = require('../models/rental');
const { Movie } = require('../models/movie')
const { Customer } = require('../models/customer');
const Fawn = require('fawn');
const mongoose = require('mongoose');
//2 phase commit library eka
Fawn.init(mongoose);

router.get('/', async (req, res) => {
    console.log('in get all ');
    const rental = await Rental.find().sort('-dateOut');
    res.send(rental);
});


router.post('/', async (req, res) => {
    const { error } = validateRentals(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    //we check if its valid id and then find it
    //but this is bad implementation we should do this in our validate 
    //method

    // if (!mongoose.Types.ObjectId.isValid(req.body.customerId)) {
    //     return res.status(400).send('Invalid customer id');
    // }
    //this is the exception throws and its not handled
    const customer = await Customer.findById(req.body.customerId);
    if (!customer) return res.status(400).send('Invalid customer');

    const movie = await Movie.findById(req.body.movieId);
    console.log(movie);
    if (!movie) return res.status(400).send('Invalid movie');

    if (movie.numberInStock === 0) return res.status(400).send('Movie not in stock');

    let rental = new Rental({
        customer: {
            _id: customer._id,
            name: customer.name,
            phone: customer.phone
        },
        movie: {
            _id: movie._id,
            title: movie.title,
            dailyRentalRate: movie.dailyRentalRate
        }
    }

    );
    //we have 2 seperate operations if something goes wronge 
    // one can happen and miss the other
    //thats where we need a transaction(they all complete or not)
    //no transactions in 

    //so when using fawn we make a task object
    //not save these things in normal way
    //but we do these thing s as Fawn tasks
    // rental = await rental.save();
    // movie.numberInStock--;
    // movie.save();

    try {
        new Fawn.Task()
            .save('rentals', rental)
            .update('movies', { _id: movie._id },
                { $inc: { numberInStock: -1 } })
            .run();
        console.log(rental);
        res.send(rental);
    } catch (error) {
        error.status(500).send('Something failed.');

    }

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