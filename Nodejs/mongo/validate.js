const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground')
    .then(() => console.log('Connected to MongoDb'))
    .catch(e => console.error('Couldnt connect to mongo', e));

//Create a schema (like a Table template or blueprint for make documents)
const courseSchema = new mongoose.Schema(
    {
        name: { type: String, required: true },
        author: { type: String, required: true },
        tags: [String],
        date: { type: Date, default: Date.now },
        isPublish: Boolean,
        price: Number
    }
);

//this  is like class object made from  above schema  template schema is the template for the 
//Table(Collection) and  this object is the real instance of it
//From this object we can create documents(rows) and we can query the all Course table(collection) documents(rows)
//this is like class 
const Course = mongoose.model('Course', courseSchema);

//use async await to get data from async function that send data
async function createCourse(courseName, author, price) {

    //real object (document - row ) that we made from the "Course" class  
    const course = new Course({

        author,
        tags: ['Angular', 'backend'],
        isPublish: true,
        price
    });
    try {
    await    Course.validate(course);
        //        const result = await course.save();
    } catch (error) {
        console.log(`promise rejected ${error.message}`);
    }

}

createCourse(`node123`, `ishan roxa`, 1000); 