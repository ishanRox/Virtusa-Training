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
    const course = await Course.update({ _id: courseId }, {
        $set: {
            'author.name': 'isisisisisisisisi'
        }
    });
    //in this aproach we dont need to edit it in memory and update it in database
    //Like below 
    // course.author.name = 'roxxxxxxxxxxxx';
    // course.save();
}
// createCourse('Node course', new Author({
//     name: 'ishan', bio: 'heloooo ', website: 'www.eefs.com'
// }));

updateAuthor('5f987347257f9b1898f328e6')