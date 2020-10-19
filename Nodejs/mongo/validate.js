'use strict'
const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false,
    useCreateIndex: true
})
    .then(() => console.log('Connected to MongoDb'))
    .catch(e => console.error('Couldnt connect to mongo', e));

//Create a schema (like a Table template or blueprint for make documents)
const courseSchema = new mongoose.Schema(
    {
        name: { type: String, required: true, minlength: 5, maxlength: 10, match: /^[a-zA-Z]+$/ },
        author: { type: String, required: true },
        tags: {
            type: [String], required: true,
            validate: {
                validator: function (v) {
                    return v.length > 0;
                },
                message: 'A course should have at least one tag !'
            }
        },
        isPublish: { type: Boolean, required: true, default: false },
        price: { type: Number, required: function (val) { return this.isPublish; } }
    }
);



//this  is like class object made from  above schema  template schema is the template for the 
//Table(Collection) and  this object is the real instance of it
//From this object we can create documents(rows) and we can query the all Course table(collection) documents(rows)
//this is like class 
const Course = mongoose.model('Course', courseSchema);

//use async await to get data from async function that send data
async function createCourse(name, author, price) {

    //real object (document - row ) that we made from the "Course" class  
    const course = new Course({
        name, author,
        tags: [],
        isPublish: true,
        price
    });
    try {
        const result = await course.validate();
        console.log("ok valid ");
        //const result = await course.save();
    } catch (error) {
        console.log(`promise rejected ${error.message}`);
    }

}

createCourse(`ishan`, `ishan roxa`, 1); 