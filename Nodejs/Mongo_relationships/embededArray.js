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
    authors: [authorSchema]
}));

async function createAuthor(name, bio, website) {
    const author = new Author({
        name, bio, website
    });
    const result = await author.save();
    console.log(result);
}

async function createCourse(name, authors) {
    const course = new Course({
        name,
        authors
    });

    const result = await course.save();
    console.log(result);
}

async function listCourses() {
    const courses = await Course.find().populate('author', 'name-_id');
    console.log(courses);
}

async function removeAuthors(courseId, authorId) {
    const course = await Course.findById(courseId);
    const author = course.authors.id(authorId);
    author.remove();
    course.save();
}
async function addAuthor(courseId, author) {
    const course = await Course.findById(courseId);
    course.authors.push(author);
    course.save();
}
// createCourse('Node course', [
//     new Author({ name: 'ishan', bio: 'heloooo ', website: 'www.eefs.com' }),

//     new Author({ name: 'nishan', bio: 'heloooo ', website: 'www.eefs.com' }),

//     new Author({ name: 'hishan', bio: 'heloooo ', website: 'www.eefs.com' })
// ]
// );

//addAuthor('5f9a6f06aff16eb18dba3cca', new Author({ name: 'krishaan', bio: 'buuuuuuuu', website: 'www.eefs.com' }));
removeAuthors('5f9a6f06aff16eb18dba3cca','5f9a6f294ed96db23b71046a');