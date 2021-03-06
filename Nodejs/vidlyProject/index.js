
const joi = require('joi');
joi.objectId = require('joi-objectid')(joi);

const express = require('express');
const logger = require('./logger');
const morgan = require('morgan');
const app = express();
const mongoose = require('mongoose');

const config = require('config');
if (!config.get('jwtPrivateKey')) {
    console.error('Fatal Error jwt private key not defined !');
    process.exit(1);
}


var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

//connect to mongo db
console.log('connecting to mongo db');
mongoose.connect('mongodb://localhost/vidly')
    .then(() => console.log('connected to mongodb'))
    .catch(err => console.log('could not connect to mongodb'));

// //config
// const config = require('config');

//use genres after restructure the file
const gen = require('./routes/genres');
//me url ekata ena requests harola yawanawa uda require ekata
app.use('/vidly.com/api/genres', gen);

//use the customers route meka folder eke customer file eka
const customers = require('./routes/customers');
//meka url eka
app.use('/vidly.com/api/cus', customers);

//use the movie route meka folder eke movies file eka
const movie = require('./routes/movies');
//meka url eka
app.use('/vidly.com/api/movie', movie);

//use the movie route meka folder eke movies file eka
const rental = require('./routes/rental');
//meka url eka
app.use('/vidly.com/api/rental', rental);

//use the users route
const user = require('./routes/users');
app.use('/vidly.com/api/user', user);


//use the users route
const auth = require('./routes/auth');
app.use('/vidly.com/api/auth', auth);

//debuggers
const startupdebugger = require('debug')('app:startup');
const databasedebugger = require('debug')('app:db');

startupdebugger('Morgan enables debug enables startup');
databasedebugger('in memory database is present');

// console.log(`configuration name ${config.get('name')}`);
// console.log(`configuration name ${config.get('mail.host')}`);
// console.log(`mail password ${config.get('mail.password')}`);
//api gawata ena data json karanna
//Returns middleware that only parses json and 
//only looks at requests where the Content-Type header matches the type option.
app.use(express.json());
app.use(logger);
app.use(auth);

//set view engine as pug
app.set('view engine', 'pug');
//set clean way to handle template files
app.set('views', './views')

app.get('/', (req, res) => {
    res.render('index', {
        title: 'my express app',
        message: 'Hello this is done by cute pug'
    })
})

if (app.get('env') === 'development') {
    app.use(morgan('tiny'));
    console.log('morgan enabled...');
} else {
    console.log('not dev no morgan logging enabled');
}



app.listen(3000, _ => console.log('Listning on port....'));