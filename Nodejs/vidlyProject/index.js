

const express = require('express');
const joi = require('joi');
const logger = require('./logger');
const auth = require('./auth');
const morgan = require('morgan');
const app = express();

//config
const config=require('config');

//debuggers
const startupdebugger=require('debug')('app:startup');
const databasedebugger=require('debug')('app:db');

startupdebugger('Morgan enables debug enables startup');
databasedebugger('in memory database is present');

console.log(`configuration name ${config.get('name')}`);
console.log(`configuration name ${config.get('mail.host')}`);
console.log(`mail password ${config.get('mail.password')}`);
//api gawata ena data json karanna
//Returns middleware that only parses json and 
//only looks at requests where the Content-Type header matches the type option.
app.use(express.json());
app.use(logger);
app.use(auth);

if (app.get('env') === 'development') {
    app.use(morgan('tiny'));
    console.log('morgan enabled...');
} else {
    console.log('not dev no morgan logging enabled');
}

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

    genres.splice(req.params.id, 1, req.body.name);
    res.send(genres);
});

app.delete('/vidly.com/api/genres/:id', (req, res) => {
    let genre = genres[req.params.id];
    if (genre == undefined) return res.status(400).send('not found');


    genres.splice(req.params.id, 1);
    res.send(genres);
});;


app.listen(3000, _ => console.log('Listning on port....'));