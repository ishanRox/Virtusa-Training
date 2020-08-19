const express = require('express');
const app = express();

const courses = [...Array(10).keys()].map(e => { return { name: `course${e}`, id: e }; });

console.log(courses);

//these are end points get post delete update
app.get('/', (req, res) => {

    res.send('<h1>hello world</h1>')
});

app.get('/api/courses', (req, res) => {

    res.send([1, 2, 333, 4, 235]);
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

//Read enviroment variable using port
const port = process.env.PORT || 3000;

app.listen(port, _ => console.log(`listning on port ${port}`));