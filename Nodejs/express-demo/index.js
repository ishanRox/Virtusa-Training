const express = require('express');
const app = express();


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

app.get(`/api/courses/:id`, (req, res) => {
    res.send(parseInt(req.params.id) * 100 + " hello ");
});

//Read enviroment variable using port

const port = process.env.PORT || 3000;

app.listen(port, _ => console.log(`listning on port ${port}`));