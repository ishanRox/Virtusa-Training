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

        o.traditionalFun;
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

