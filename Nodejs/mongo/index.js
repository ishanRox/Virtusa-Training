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
        price:Number
    }
);

//this  is like class object made from  above schema  template schema is the template for the 
//Table(Collection) and  this object is the real instance of it
//From this object we can create documents(rows) and we can query the all Course table(collection) documents(rows)
//this is like class 
const Course = mongoose.model('Course', courseSchema);

//use async await to get data from async function that send data
async function createCourse(courseName, author,price) {

    //real object (document - row ) that we made from the "Course" class  
    const course = new Course({
        name: 'Angular.js course',
        author,
        tags: ['Angular', 'backend'],
        isPublish: true,
        price
    });

    const result = await course.save();
    console.log(result);
}

async function getCourses() {
    //we can get earlier class object(our table) to querring
    const courses = await Course.find();
    console.log(courses);
    console.log('__________________________________________-');
    //advance query

    const courses1 = await Course.find({ author: 'ishan', isPublish: true })
        .limit(10)
        .sort({ name: 1 })
        .select({ name: 1, tags: 1 });
    console.log(courses1);
    console.log('complex query________________________________________________');
    //comparison operator
    //like bash
    //eq,ne,gt,gte,lt,lte,in,nin

    const courses2 = await Course.find({ author: 'ishan', isPublish: true })
    .limit(10)
    .sort({ name: 1 })
    .select({ name: 1, tags: 1 });

}
createCourse();
getCourses();


//crete fake data

[...Array(10).keys()].forEach(e => {
    console.log(e+1000);
    createCourse(`node${e}`, `ishan${e}`,e*1000);
});



function ds(keys, values, rereduce) {
	if (rereduce) {
		var result = {
			topScore: values[0].topScore,
			bottomScore: values[0].bottomScore,
			sum: values[0].sum,
			count: values[0].count
		};
		for (var i = 1, e = values.length; i < e; ++i) {
			result.sum = result.sum + values[i].sum;
			result.count = result.count + values[i].count;
			if (result.topScore < values[i].topScore) {
				result.topScore = values[i].topScore;
			};
			if (result.bottomScore > values[i].bottomScore) {
				result.bottomScore = values[i].bottomScore;
			};
		};
		result.mean = (result.sum / result.count);
		log('rereduce keys:' + toJSON(keys) + ' values:' + toJSON(values) + ' result:' + toJSON(result));
		return result;
	}}