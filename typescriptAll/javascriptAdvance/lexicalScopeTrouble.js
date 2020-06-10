
//lexically scoping amma kiyanwa eyage phone eka genna kiyala 
//mama isssella mage gawa balanawa
//naththam desk eke
//naththam ammage room eke... ohoma ohoma continue wenawa

//dynamic scope kiyanne
// amma kiyanawa desk eka uda thiyeana mage phone eka genna
// kiyala caller thama kiyanne 

//https://stackoverflow.com/questions/1047454/what-is-lexical-scope
// I understand them through examples. :)

// First, lexical scope(also called static scope), in C - like syntax:

// void fun()
// {
//     int x = 5;

//     void fun2()
//     {
//         printf("%d", x);
//     }
// }

// Every inner level can access its outer levels.

// There is another way, called dynamic scope used by the first implementation of Lisp, again in a C - like syntax:

// void fun()
// {
//     printf("%d", x);
// }

// void dummy1()
// {
//     int x = 5;

//     fun();
// }

// void dummy2()
// {
//     int x = 10;

//     fun();
// }

// Here fun can either access x in dummy1 or dummy2, or any x in any function that call fun with x declared in it.

//     dummy1();

// will print 5,

//     dummy2();

// will print 10.

// The first one is called static because it can be deduced at compile - time, and the second is called dynamic because the outer scope is dynamic and depends on the chain call of the functions.

// I find static scoping easier for the eye.Most languages went this way eventually, even Lisp(can do both, right ?).Dynamic scoping is like passing references of all variables to the called function.

// As an example of why the compiler can not deduce the outer dynamic scope of a function, consider our last example.If we write something like this:

// if (/* some condition */)
//     dummy1();
// else
//     dummy2();

// The call chain depends on a run time condition.If it is true, then the call chain looks like:

// dummy1-- > fun()

// If the condition is false:

// dummy2-- > fun()

// The outer scope of fun in both cases is the caller plus the caller of the caller and so on.

// Just to mention that the C language does not allow nested functions nor dynamic scoping.


//**************************************************** */
//In normal Methods it matters who call this
//(this and atguments are dynamically scoped other variables lexically scoped)
//wadagath wenne call karanne kawda kiyana eka
//normal outer call walata default this eka global object eka (window if html)
// except if the script is running in strict mode
global.name = "main";

let funfunction = function () {
    console.log(this.name);
};

let dog = {
    name: "teddy",
    funfunction: funfunction
};
let cat = {
    name: "noughty cat",
    funfunction: funfunction
};

dog.funfunction();
cat.funfunction();
funfunction()
//https://www.codementor.io/@dariogarciamoya/understanding--this--in-javascript-du1084lyn
//https://www.codementor.io/@dariogarciamoya/understanding-this-in-javascript-with-arrow-functions-gcpjwfyuc

//________________________________________________________________________________________________________________________________________________________________________
console.log("_________________________");
//Arrow functions do not bind their own this, instead, 
//they inherit the one from the parent scope, which is called "lexical scoping".


// define a function
//we used this in function and global in here because of this reason  :-)
//https://stackoverflow.com/questions/43627622/what-is-the-global-object-in-nodejs

// Same result but not the same reason.
//  With normal functions the scoped is bound to the global one by default,
//   arrows functions,as I said before,
//    do not have their own this but they inherit it from the parent scope
//******Specialy in arrow funcitons all variables are lexically scoped ****** 

//reason this gives window object in browser and module in node is its
// inherited to arrow function from where it declared  .
//in here this is module.exports object in node js
module.exports.name = "module.exports object, not the global object";


let arrowExample = {
    name: "ishan",
    arrowFun: () => {
        console.log(this);
    }
};

arrowExample.arrowFun();


console.log("____________________________________________________");
console.log(this);
console.log();

let arrowExample1 = {
    name: "ishan",
};

//this really happen like this more clarity can get by this
//so in here this is module in node and window in browser 
arrowExample1.arrowFun = () => { console.log(this); };
//__________________________________________________________________________________
//this here is module 
let arrowFun = () => { console.log(this); };

let anotherOne = {
    name: "another one",
    arrowFun: arrowFun
};

//not like in regular methods caller dosent change or affect this in arrow funciton
//only matters is how this inherited
console.log("call for anotherOne object");
anotherOne.arrowFun();

console.log("____________________");
//but this object can be cached like this
let arrowDog = {
    name: "arrow dog",
    m: () => {
        console.log(this);
    },
    m1() {
        console.log(this);
    },
    m3() {
        //in here this is arrowDog object so arrow function inherit this from 
        //the place it created so in here this== arrowDog
        let arrow = () => { console.log(this); };
        arrow();
    }
};
//caller dosent affect this  only the declaration in arrow function
arrowDog.m();
console.log("call for arrow func\n");
//caller affect in regular functions
arrowDog.m1();
console.log("call for regular func\n");
//arrow function inherit this from where it maked proof
arrowDog.m3();
console.log("call for arrow inside regular\n");
//normal function wala this call karana kena (caller)
//arrow wala this wenne arrow eka hadapu thana this(owner)(parent gen inherit wenwa)
