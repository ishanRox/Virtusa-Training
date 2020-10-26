const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/playground1')
    .then(() => console.log('connected to mongodb'))
    .catch(error => console.error('couldnt connect to mongodb..', err));


const Author = mongoose.model('Author', new mongoose.Schema({
    name: String,
    bio: String,
    website: String
}));

const Course = mongoose.model('Course', new mongoose.Schema({
    name: String,
    author: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Author'
    }
}));

async function createAuthor(name, bio, website) {
    const author = new Author({
        name, bio, website
    });
    const result = await author.save();
    console.log(result);
}

async function createCourse(name, author) {
    const course = new Course({
        name,
        author
    });

    const result = course.save();
    console.log(result);
}

async function listCourses() {
    const courses = await Course.find().populate('author');
    console.log(courses);
}

async function listAuthors() {
    const authors = await Author.find().select('name');
    console.log(authors);
}

//createAuthor('ishan', 'my bio', 'www.ishanrox.com');
//createCourse('Node course', '5f941b36a6a07917c0952292');

listAuthors();
listCourses();