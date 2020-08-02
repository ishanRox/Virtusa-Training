var url = 'http://mylogger.io/log';


function log(message) {
    //send an http request
    console.log(message);
}


//add to export object in module object
console.log("in logger");
module.exports.log = log;
