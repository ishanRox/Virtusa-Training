const express = require('express');
const app = express();
const Joi = require('joi');//this is a class


function validateCouses(course) {
    const schema = { name: Joi.string().min(3).required() };
    return Joi.validate(course, schema);

}

//add middleware
app.use(express.json());

const courses = [...Array(10).keys()].map(e => { return { name: `course${e}`, id: e }; });
console.log(courses);

//these are end points get post delete update
app.get('/', (req, res) => {
    console.log('get request called');
    res.send('<h1>hello world</h1>')
});

app.get('/api/courses', (req, res) => {
    res.send(courses);
});

//get query string parameters- for optional things
app.get(`/api/courses/op`, (req, res) => {
    res.send(req.query);
});

//Parameters-for essential things 
//Example for get
app.get(`/api/courses/:id`, (req, res) => {
    const course = courses.find(e => e.id === parseInt(req.params.id));
    if (!course) res.status(404).send('id not found');
    res.send(course);
});

//Post example
app.post(`/api/courses`, (req, res) => {

    const { error } = validateCouses(req.body);

    //Validate
    //If invalid ,return 400 - Bad request
    if (error) {
        //400 Bad request
        res.status(400).send(result.error.details[0].message);
        return;
    }

    const course = {
        id: courses.length + 1,
        name: req.body.name
    };
    courses.push(course);
    res.send(course);
});

//Update http put metho
app.put('/api/courses/:id', (req, res) => {
    //Look up the course
    const course = courses.find(e => e.id === parseInt(req.params.id));
    //elegent way to stop the code {code... return; } also ok
    if (!course) return res.status(404).send('id not found');


    //if not existing ,return 404
    //const result = validateCouses(req.body);
    //we can use destructuring to avoid result.error

    const { error } = validateCouses(req.body);

    //Validate
    //If invalid ,return 400 - Bad request

    //400 Bad request
    if (error) return res.status(400).send(error.details[0].message);


    //Update course
    course.name = req.body.name;
    //Return the updated course
    res.send(course);

});

//delete example
app.delete(`/api/courses/:id`, (req, res) => {
    //Look up the course
    const course = courses.find(e => e.id === parseInt(req.params.id));
    if (!course) res.status(404).send('id not found');
    //delete
    const index = courses.indexOf(course);
    courses.splice(index, 1);
    //return 
    res.send(course);

});

//Read enviroment variable using port
const port = process.env.PORT || 3000;

app.listen(port, _ => console.log(`listning on port ${port}`));