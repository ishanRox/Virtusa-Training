//object oriented with javascript the old way

const CarOld = function () {
    if (!(new.target)) {
        throw new Error('u stupid girl this is a class not a function !');
    }

    console.log('called...');
};

console.log('step 1');
new CarOld();
console.log('step 2');
//Car();

//New way with class syntax in es 6
class Car {
    constructor(year) {
        this.year = year;
        this.km = 0;
    }
    drive(dist) {
        this.km += dist;
    }
}

const car = new Car(2020);
console.log(car);
car.drive(10);
console.log(car);

console.log("______________________________________")
//getters and setters and properties in javascript

class A {
    constructor() {
        console.log("new object has made");
        this.colorVal = 'green';
    }
    //setter (this setter getter names and variable name must differ)
    set color(colorVal) {
        this.colorVal = colorVal;
    }
    //getter remember no args if args added it will give errors
    get color() {
        return this.colorVal;
    }
}

const obj1 = new A();
console.log(obj1);
obj1.color = 'red';
console.log(obj1);
console.log(obj1.color);
console.log("____________________________________________")
//_____________________________________________________________
//static methods 
class Planet {

    static info() {
        console.log("info called");
    }


}
//call static method
Planet.info();
//new Planet().info(); you cant do this objects cant call static methods
//set static variable not in constructo 
Planet.lightspeed = "dont know exactly";
//get static var 
console.log(Planet.lightspeed);
//____________________________________________
console.log("____________________");
//like var args in java
const classFactory = function (...properties) {

    console.log(properties);

    return class {
        constructor(...values) {
            console.log((values));

            for (const [index, property] of properties.entries()) {
                //properties array eken data aran
                //entries widihata arrange karagannawa 
                //object eke property walata names,properties  array eken gannawa
                //ewata values tika values array eken gannawa
                this[property] = values[index]
            }
        }
    };
}

const Book = classFactory('title', 'pages');

const Book1 = new Book('song of ice and fire', 2000);
console.log("______________________________________");

//class inheritance or prototypal inheritance
//this is far away form java :-)
//java c# ruby and python use class based inheritance
//languages like javascript and lua use prototypical inheritance

const benchIshan = { name: 'sam' };

const checkWork = function (person) {
    try {
        person.work();
    } catch (error) {
        console.log("eeeeya bench eke thama");
    }
};

//check if the pearson is working or not 

checkWork(benchIshan);

const projectGiven = {
    work: function () {
        console.log("working in spring boot ....");
    }
};

//use prototyping 
console.log("after 1 year ....");
//in prototypal inheritance if member is not found in 
//original one it goes into the prototype
Object.setPrototypeOf(benchIshan, projectGiven)
checkWork(benchIshan);
console.log('after 4 years ');

//And the best thing is you can dynamically change it
//So class based inheritance is static inflexible
//prototypal inheritance is dynamic so its flexible
//it goes until it finds the requested resource
//obj->prototype->prototype->prototype->prototype->null
const projectAfter4Years = {
    work: function () {
        console.log("working as a techlead ");
    }
};

Object.setPrototypeOf(benchIshan, projectAfter4Years);
checkWork(benchIshan)
console.log("________________________________________");
//prototyping wala gets deep sets shallow
//minissu 3 dena saha rupiyal 100 example eka mathaka thiyaganna 
//prototypal  inheritance eka wennne ehama


//this is not java like class based ineritance 
//but seems like it

class pearson {
    constructor(first, last) {
        this.first = first;
        this.last = last;
    }

    toString() {
        return `${this.first} ${this.last}`
    }
}

class CoolPearson extends pearson {

    toString() {
        return `${super.toString()} called super and receive`
    }
}
//see in java if u make a custome constructor
//you must call it in extended class
//but no need for that in javascript 
//its implicitly done by javascript
const ishan = new CoolPearson('ishan', 'vimukthi');

console.log(ishan.toString());
//proof of prototyping
console.log(Object.getPrototypeOf(ishan));
console.log(Object.getPrototypeOf(Object.getPrototypeOf(ishan)));
