const logger = require('./logger');


console.log("in app js");
logger.log("ishan hello");

((param) => console.log("iife-immediately invoken functional expression " + param))(" awsome now lambda");