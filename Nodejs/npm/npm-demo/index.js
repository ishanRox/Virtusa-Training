const _= require('underscore');
//first it assume this is a core module and check it
//Then it thinks this is a folder or a file
//After those this check node_modules

const result = _.contains([1, 33, 4, 1, 2], 33);

console.log(result);