
const express = require('express');
const router = express.Router();

const genres = ['sci sfi', 'crimde', 'love', 'adult', 'nolan legend'];

function validateGenres(genre) {
    const schema = { name: joi.string().min(4).required() };
    return joi.validate(genre, schema);
}

router.get('/', (req, res) => res.send(genres));

router.post('/', (req, res) => {
    const { error } = validateGenres(req.body);
    if (error) return res.status(400).send(error.details[0].message);
    genres.push(req.body.name);
    res.send(genres[genres.length - 1]);
});

router.put('/:id', (req, res) => {
    let genre = genres[req.params.id];
    if (genre == undefined) return res.status(400).send('not found');
    const { error } = validateGenres(req.body);
    if (error) return res.status(400).send(error.details[0].message);
    genres.splice(req.params.id, 1, req.body.name);
    res.send(genres);
});

router.delete('/:id', (req, res) => {
    let genre = genres[req.params.id];
    if (genre == undefined) return res.status(400).send('not found');


    genres.splice(req.params.id, 1);
    res.send(genres);
});;

module.exports = router;