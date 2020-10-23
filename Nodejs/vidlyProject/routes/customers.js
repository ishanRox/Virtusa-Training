const express = require('express');
const router = express.Router();
//practical destructoring if not we must call . notation
const { Customer, validateCustomer } = require('../models/customer');

//const genres = ['sci sfi', 'crimde', 'love', 'adult', 'nolan legend'];



router.get('/', async (req, res) => {
    console.log('in get all ');
    const customer = await Customer.find().sort('name');
    res.send(customer);
});


router.post('/', async (req, res) => {
    const { error } = validateCustomer(req.body);
    if (error) return res.status(400).send(error.details[0].message);
    console.log(req.body);
    let customer = new Customer({
        name: req.body.name
        ,
        phone: req.body.phone
        ,
        isGold: req.body.isGold
    });
    customer = await customer.save();
    res.send(customer);
});

router.put('/:id', async (req, res) => {
    console.log(req.body);
    console.log(req.params.id);
    const { error } = validateCustomer(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    const customer = await Customer.findByIdAndUpdate(req.params.id, { name: req.body.name }, {
        new: true
    });

    //    let genre = genres[req.params.id];
    if (!customer) return res.status(400).send('not found');
    // genres.splice(req.params.id, 1, req.body.name);
    res.send(customer);
});

router.delete('/:id', async (req, res) => {
    const customer = await Customer.findByIdAndRemove(req.params.id);
    //    let genre = genres[req.params.id];
    if (!customer) return res.status(400).send('not found');
    //    genres.splice(req.params.id, 1);
    res.send(customer);
});;

module.exports = router;