
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
 // 

