const http = require('http');

const obj = {
    name: 'ishan',

    view: function (params) {
        console.log(this);
        params();
    },
    view1: () => console.log(this)
};

const func = function () {
    console.log(this);
};

obj.view(func);

obj.view1();
