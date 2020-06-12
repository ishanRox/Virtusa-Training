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
