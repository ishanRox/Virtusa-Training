const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground')
    .then(() => console.log('Connected to MongoDb'))
    .catch(e => console.error('Couldnt connect to mongo', e));

//Create a schema (like a Table template or blueprint for make documents)
const courseSchema = new mongoose.Schema(
    {
        name: String,
        author: String,
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

async function getAll() {
    const q1 = await Course.find({ author: /^i.*/ }, { author: 1, price: 1 });
    console.log(q1);
}
getAll();

async function updateCourse(id) {
    const course = await Course.findById(id);
    if (!course) return;

    course.author = "ishan9";

    const result = await course.save();
    console.log(result);

}

async function directUpdate(id) {
    //resutl of update
    const result = await Course.update({ _id: id }, { $inc:{ price: 100} });
    console.log(result);
    await getAll();

}

async function remove(id){
    const result =await Course.deleteOne({ _id: id });
    console.log(result);
}
updateCourse("5f867b4ddf8cf2d751d4a724");
directUpdate('5f867b4ddf8cf2d751d4a724');
//remove('5f867b4ddf8cf2d751d4a724');