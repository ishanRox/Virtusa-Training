


const obj = {

    name: "local ishan",
    m1() {

        console.log(`access from m1 method - ${this.name}`);

    },
    m2: () => {
        console.log(`access from m2 method - ${this.name}`);
    },
    m3: _ => console.log(`access from m3 arrow function ${this.name}`)
};


global.name = "global ishan";
exports.name = "export module ishan";


obj.m1();
obj.m2();
//this m3 arrow function going to give export because its define in exoprt this scope 
//it seems it define in object but really it look like this the m4 function
//obj.m3=_=>console.log(`access from m3 arrow function ${this.name}`) m3 aslo inner defined like this
obj.m4 = _ => console.log(`acces from m4 from this- ${this.name}`);
obj.m3();
obj.m4();


//this is a special thing node specially binds this for normal functions 
//but top level code in node have module.export as "this"
//so in arrow functions it get the this from where it defined 
(function () {
    console.log(`access from iife normal function - ${this.name}`)
})();

(_ => console.log(`access from iife arrow function - ${this.name}`))();