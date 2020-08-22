const express = require('express');
const joi = require('joi');
const app = express();

//api gawata ena data json karanna
app.use(express.json());

const genres = ['sci sfi', 'crimde', 'love', 'adult', 'nolan legend'];



function validateGenres(genre) {
    const schema = { name: joi.string().min(4).required() };
    return joi.validate(genre, schema);
}



app.get('/vidly.com/api/genres', (req, res) => res.send(genres));

app.post('/vidly.com/api/genres', (req, res) => {
    const { error } = validateGenres(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    genres.push(req.body.name);
    res.send(genres[genres.length - 1]);
});

app.put('/vidly.com/api/genres/:id', (req, res) => {
    let genre = genres[req.params.id];

    if (genre == undefined) return res.status(400).send('not found');

    const { error } = validateGenres(req.body);
    if (error) return res.status(400).send(error.details[0].message);

    genres.splice(req.params.id,1,req.body.name);
    res.send(genres);
});

app.delete('/vidly.com/api/genres/:id', (req, res) => {
    let genre = genres[req.params.id];
    if (genre == undefined) return res.status(400).send('not found');

    
    genres.splice(req.params.id,1);
    res.send(genres);
});;


app.listen(3000, _ => console.log('Listning on port....'));