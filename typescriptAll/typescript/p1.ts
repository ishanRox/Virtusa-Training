//different types in typescript

let count = 5;
count = 12;//Type '"ishan"' is not assignable to type 'number'
//count = 'ishan'; //Type '"ishan"' is not assignable to type 'number'


let a;//the type of this is let a: any
a = 1;
a = true;
a = 'ishan';
console.log(` variable a value is ${a} this is bad because no type safety`);

console.log("_____________________________");
//but in typescript we have a solution there are types like java
let typeSafe = 10;
//gives compile error typeSafe='ishan';
typeSafe = 100;
console.log(typeSafe);


console.log("_____________________________");

//in typescript we have types
let a1: number;
let a2: boolean;
let a3: string;
let a4: any;
let a5: number[] = [1, 2, 4, 121, 1212];
let a6: any[] = [1, true, 'ishan'];

console.log("_____________________________");
//concept of enums in typescript
//old vanilla way

const colorRed = 0;
const colorGreen = 1;
const colorBlue = 2;

//new way 
enum Color { Red, Green, Blue };

let backGroundColor = Color.Blue;
console.log(backGroundColor);
//see default value 2 given so if some one add color 
//to middle of enum the value changes.
//so its a good practise to initialize enum
enum Place { one = 1, two = 2, three = 3 };

console.log(`${Place.one}  ${Place.two} ${Place.three}`)

console.log("_____________________________");

console.log("_____________________________");
//type assertions its like generics in java
let message;
message = 'ishan';//here type is any
let endsWithN = (<string>message).endsWith('n');
console.log(`ends with n ${endsWithN} `);
//another way
let alternateWay = (message as string).endsWith('n');
console.log(`ends with n (alternate way) ${alternateWay} `);

console.log("_____________________________");


console.log("_____________________________");
//inline custom annotations
let draw1 = (x: number, y: number, z: number) => console.log(`draw1 method passing arguments \n x ${x} y ${y} z ${z}`);

draw1(12, 23, 34);
//but to reduce complexity we add a object and 
//pass variables through that object
//so then we add our expectation of structure of that object
//this is called inline anotations 
//if we dont add this any object can be added

let draw2 = (point: { x: number, y: number, z: number }) => console.log(`draw2 method passing a object \n x ${point.x} y ${point.y} z ${point.z}`);

draw2({ x: 23, y: 234, z: 234 });

//but for complex objects we must use interfaces
//for more cleaner approch and we can use it again and again
//Allways use uppercase in interface
interface Point {
    x: number,
    y: number,
    z: number
};


let draw3 = (point: Point) => console.log(`draw3 method passing a object type safe by a interface \n x ${point.x} y ${point.y} z ${point.z}`);

draw3({ x: 23, y: 234, z: 234 });


console.log("_____________________________");