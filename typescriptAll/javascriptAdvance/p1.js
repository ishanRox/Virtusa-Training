
//javascript pitfalls and errors
//dont use var use let and const
var foo = function () {
    var local1 = 2;


    {
        var local2 = 3;
        console.log(local2 + "local 2 inside block");
    }

    //local2 can be accesed in js because of hoisting  
    console.log(local1 + "local 1 inside foo");
    console.log(local2);

    //and another problem with var is js 
    //allow redeclare it so earlier declarion make no sense

    var local1 = 4;
    console.log(local1 + " redeclared local1");
    console.log("\n");

    //__________________________________________________________________________________________
    //use const if not use let
    //let behave like variables in java const behave like  final
    //both protect scope
    //use const more

    const n = 4;
    console.log(n);

    // this gives us a error because const are not mutable
    // const are immutables    n = 9;

    console.log("\n");
    //__________________________________________________________________________________________
    //importance in immutability

    let factor = 2;
    const printIt = (e) => console.log(e * factor);
    factor = 0;
    printIt(4);
    console.log("the output given is zero bad code ");


    const finalFactor = 100;
    const printItFinal = (e) => console.log(e * finalFactor);
    console.log("good code because factor is immutable");

    printItFinal(12);

    console.log("\n");
    //__________________________________________________________________________________________
    //constant is like final in java it affect on the reference
    //not the object which reference to .

    const sam = { name: 'Sam', age: 2 };
    console.log(sam);

    // TypeError: Assignment to constant variable.   sam = { different: 12313 };
    //but the inside of object can be changed
    sam.age = 3;
    console.log(sam);
    //if we want to really protect object
    const ishan = Object.freeze({ name: "isan Rox" });

    console.log(ishan);
    ishan.name = "you cant change me";
    console.log(ishan);
    console.log(" see object is not changed if you want warning use strict mode");


}

foo();

console.log("\n");
//__________________________________________________________________________________________
//hidden thing arguments not the best quit using this
const max = function () {
    console.log(arguments);
    //dont use arguments its array wannabe
    //not a array
    console.log(`arguments is array = ${arguments instanceof Array}`);
    //you cant use awsome functional style programming 
};

const maxRest = function (...numbers) {

    console.log(`...numbers is array = ${numbers instanceof Array}`);
    console.log(numbers);
}

max(1);

max(1, 2);

max(1, 2, 3);


maxRest(1);

maxRest(1, 2);


maxRest(1, 2, 3);

console.log("\n");


//__________________________________________________________________
//...uses for 2 operators spread  and rest
//.... are in  both sending and reciving sides of method awsome

const values = [1, 2, 4];
//wornge way bad code
maxRest(values[0], values[1], values[2]);
//correct way using spread operator usecase 1
maxRest(...values);

//___________________________________________________________
console.log("\n");
//can use spread like this too spread usecase2
const greet = (name1, name2) => console.log(`${name1} ${name2}`);
greet(...['ishan', 'rox']);

//_______________________________________________________
//Array addition using spread usecse3
console.log([...[1, 2, 4, 5, 6, 7], 19, ...[122, 23323]]);

console.log("\n");
//_______________________________________________________
const sam = Object.freeze({ name: 'Sam', age: 2 });
//copy object using spread usecse4
const olderSam = { ...sam, age: sam.age + 10 };
console.table(sam);
console.table(olderSam);
console.log("\n");
//_______________________________________________________
//default parameters

const divition = (no, diviser) => no / diviser;
console.log(divition(1000, 10));

//default para use other parameter variable
const substraction = (no1, no2 = no1 * 10) => console.log(no2);

substraction(100, 200);
//default parameter exptession activate when there is no value
substraction(100);
console.log("\n");
//null and undifined behavior in defaule

const nullVsUndefined = (value = "default is applied") => console.log(value);
nullVsUndefined("ishan");
nullVsUndefined();
//undefined is treated different than null because 
//Undefined is a variable that has been declared but not assigned a value.
//so you can assign default value to it
//but null is an assignment value so it has a value if we give null.
nullVsUndefined(undefined);
nullVsUndefined(null);

console.log("\n");
//_______________________________________________________
//destructuring most beautifull concept
const names = ['ishan', 'vimukthi', 'vihanga'];

for (val of names.entries()) console.log(val);

//so we desructure above val to get inner values
for ([value, name] of names.entries()) console.log(`value ${value} name ${name}`);


//_______________________________________________________
console.log("\n");
//scopes of functions

const stuff = 4;
this.something = 12;

const fooM = function (n) {
    console.log(n);
    console.log(stuff);
    console.log(this.something);

}

fooM(122);
console.log("____________________________");
//bind a object for this
fooM.call({ something: 99 }, 123);
//In a refular function ,all variables are lexically scoped
//except this and arguments which are dynamically scoped

//in an arrow function all variables (including this and arguments)
//are lexically scoped
//this best explain http://howtonode.org/what-is-this

console.log("____________________________________lambda");

//_____________________________________________________lambda this 

// For fns inside Objects: 'this' refers to the object calling the function.
// For fns not called by objects - Eg call back functions -    'this' refers to the global object.
// For fns defined using arrow functions - 'this' simple refers to the object that is executing the arrow function - Irrespective of object's scope.
//  Meaning:  if the arrow function is called from a global scope? 'this' will refer to the global object.
//   If the arrow function is called with in a function which belongs to an object?
// 'this' will refer to the calling function's scope and in this case the object itself.

//This in arrow functions
console.log(this);
console.log("sdfsdfsdfsdf");

//
[1, 2, 3, 4, 233].forEach((e) => console.log(this));

let o = {
    name: "Ishan",
    traditionalFun: function () {
        console.log();
        console.log(this);
        console.log(`traditional func this==o`, this == o);
        console.log();
    },
    arrowFun: () => {

        console.log();
        console.log(`Arrow func this==o`, this == o);
        //  console.log(`Arrow func this==window`, this == globalThis);
        console.log(this);
        console.log("inside lambda");
        console.log();
    },
};

o.traditionalFun();

//arrow function was created in window scope
//but Run in Scope of o so it always binded
//to scope where its created
o.arrowFun();
let anotherObject = {
    name: "another object",
    traditionalFun: function () {
        console.log(this);
        console.log("inside another");

        o.traditionalFun();
    }
};

anotherObject.traditionalFun();
//read about this more
//https://www.w3schools.com/js/js_this.asp (most clear)
//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this

//With a regular function this represents the object that calls the function:
//With an arrow function this represents the owner of the function:
//https://stackoverflow.com/questions/36717376/arrow-function-in-object-literal
//https://stackoverflow.com/questions/48295265/lexical-scope-in-javascript

//******************************************************
//normal function wala this call karana kena (caller)
//arrow wala this wenne arrow eka hadapu thana this(owner)(parent gen inherit wenwa)

let a = {
    name: "ishan",
    foo: function () {
        //methana this a object eka
        [4, 3, 2, 1].forEach((element) => {
            console.log(this, this == a);
        });
    },
};

a.boo = function () {
    console.log(`${this} booo`);
};
a.noo = () => console.log(`${this} noo`);
//owner(haduwe kawru gawada) of noo is window so this==window
a.noo();

//caller is a regualar function
a.boo();

//caller is a but arrow inside another function so this==a
a.foo();

//methana this window object eka
[4, 3, 2, 1].forEach((element) => {
    console.log(this, this == a);
});


console.log("_________________________closure");
//_____________________________________________________
//closures born because of lexical scope.

// Lexical Scoping defines how
// variable names are resolved in
//     nested functions: inner functions contain
// the scope of parent functions. even if the parent
// function has returned.
// That is all there is to it!

// Make a function that returns a closure function.
function myModule(name, age) {
    // var name = "tim", age = 28;
    return function greet(greetStart) {
        return greetStart + " " + name + ".  Wow, you are " + age + " years old.";
    }
}
// call `myModule` to get a closure out of it.
var greeter = myModule("ishan", 24);
// Call the closure
console.log(greeter("hi"));
console.log(greeter("Hello "));
