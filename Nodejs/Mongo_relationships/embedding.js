const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/playground1')
    .then(() => console.log('connected to mongodb'))
    .catch(error => console.error('couldnt connect to mongodb..', err));

const authorSchema = new mongoose.Schema({
    name: String,
    bio: String,
    website: String
});

const Author = mongoose.model('Author', authorSchema);

const Course = mongoose.model('Course', new mongoose.Schema({
    name: String,
    author: authorSchema
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
    const courses = await Course.find().populate('author', 'name-_id');
    console.log(courses);
}

async function listAuthors() {
    const authors = await Author.find().select('name');
    console.log(authors);
}
async function updateAuthor(courseId) {

    const course = await Course.findById(courseId);
    //one downside is these sub documents cant be save on their own 
    //only they can be saved in the contex of their parents
    //but validations and all the other things can be done 
    course.author.name = 'roxxxxxxxxxxxx';
    course.save();
    //we dont have course.author.save() because this is sub doc
}
// createCourse('Node course', new Author({
//     name: 'ishan', bio: 'heloooo ', website: 'www.eefs.com'
// }));

updateAuthor('5f987347257f9b1898f328e6')