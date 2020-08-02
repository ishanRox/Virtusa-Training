const path = require("path");
//first node chek inbult if not it then checks modules in relative paths


//Path module
var pathObject = path.parse(__filename);


console.log(pathObject);
//we can get important infomation about given file  using this path module
console.log("_____________________________________");

//Os module
const os = require('os');
const totalMemory = os.totalmem();
const freeMemory = os.freemem();

console.log(`Total memory : ${totalMemory} freeMemory :${freeMemory}`);

console.log("_____________________________________");

const fs = require('fs');
//use async method because its non blocking  for the sake of simplicity 
//we using sync or blocking methods

//read current dir sync
const files = fs.readdirSync('./');

console.log(files); 

//read in async way
const asyncFiles= fs.readdir('./',function name(params) {
    
}) 