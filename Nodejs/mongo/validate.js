const mongoose = require('mongoose');
 let x=1;

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
        name: { type: String, required: true, minlength: 5, maxlength: 10, match: /^[a-zA-Z]+$/, uppercase: true, trim: true },
        author: { type: String, required: true },
        tags: {
            type: [String], required: true,
            validate: {
                validator: function (value) {
                   

                    return new Promise((resolve, reject) => {
                        // There are two ways for an promise-based async validator to fail:
                        // 1) If the promise rejects, Mongoose assumes the validator failed with the given error.
                        // 2) If the promise resolves to `false`, Mongoose assumes the validator failed and creates an error with the given `message`.
                        //so important - we can check it when test case fails and it reject it goes to the 'new Error(msg)'
                        //but if we give correct result and resolve(false) it gets the '  message: 'msg''
                        setTimeout(() => {
                            console.log('Getting HTTP validation...'+x);
                            const result = value && value.length > 0;
                            if (result) {
                                resolve();
                            } else {
                                reject(new Error('A course should have at least one tag.'));
                            }
                            x++;
                        }, 1000);
                    });
                },
                message: 'Message - A course should have at least one tag !'
            }
        },
        isPublish: { type: Boolean, required: true, default: false },
        price: { type: Number, required: function (val) { return this.isPublish; },set:v=>Math.round(v),get:v=>Math.round(v) }
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
        tags: ['react'],
        isPublish: true,
        price
    });

    try {
        await course.validate();
        console.log("ok valid ");
        await course.save();
    } catch (error) {
        console.log(`promise rejected ${error.message}`);
    }

}

createCourse(`    ishanv `, `ishan roxa`, 111.232); 