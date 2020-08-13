

const obj = {
    name: 'ishan',

    view: function (callback) {
        console.log("____________________");
        console.log(this.name + " in view");
        callback();
        console.log("____________________");
    },
    view0: function () {
        console.log(this.name + " in view0");
    },
    view1: () => console.log(this.name + " in view1"),
    view2: function () {
        console.log(this.name + " in view2");

        // In JavaScript the this object is really based on how you make your function calls.

        // In general there are three ways to setup the this object:

        // someThing.someFunction(arg1, arg2, argN)
        // someFunction.call(someThing, arg1, arg2, argN)
        // someFunction.apply(someThing, [arg1, arg2, argN])
        // In all of the above examples the this object will be someThing.
        // Calling a function without a leading parent object will generally get you the global object
        //  which in most browsers means the window object.

        (function () {
            console.log(this.name + " in function in view2");
        })();

        //arrow function lexically get the this from its defined scope
        (_ => console.log(this.name + " in arrow of view2"))();


    }
};

const func = function () {
    console.log(this.name + " in func");
};
module.exports.name = "module .export ishan";

global.name = "global.ishan";


console.log(this.name);
console.log('____________');
func();
obj.view0();
obj.view1();
obj.view2();
//__________________________
obj.view(func);
obj.view(obj.view0);
obj.view(obj.view1);
obj.view(() => console.log(this));
obj.view(function () {
    console.log(this);
});
