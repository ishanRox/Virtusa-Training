const http = require('http');

const obj = {
    name: 'ishan',

    view: function (callback) {
        console.log("____________________");
        console.log(this.name + " in view");
        callback.call(this);
        console.log("____________________");
    },
    view0: function () {
        console.log(this.name + " in view0");
    },
    view1: () => console.log(this.name + " in view1"),
    view2: function () {
        console.log(this.name + " in view2");

        //arrpw function lexically get the this from its defined scope
        (_ => console.log(this.name + " in arrow of view2"))();
    }
};

const func = function () {
    console.log(this.name + " in func");
};
module.exports.name = "module .export ishan";

global.name = "global.ishan";

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
