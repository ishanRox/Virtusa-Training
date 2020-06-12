//object oriented with javascript the old way

const Car = function () {
    if (!(new.target)) {
        throw new Error('u stupid girl this is a class not a function !');
    }

    console.log('called...');
};

console.log('step 1');
new Car();
console.log('step 2');
Car();


