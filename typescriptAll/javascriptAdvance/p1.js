
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
    //__________________________________________________________________________________________
    //use const if not use let
    //let behave like variables in java const behave like  final
    //both protect scope
    //use const more

    const n = 4;
    console.log(n);

    // this gives us a error because const are not mutable
    // const are immutables    n = 9;

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