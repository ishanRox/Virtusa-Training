
//writing custome middlewares
function log(req, res, next) {
    console.log('logging...');
    //the middleware functions execure sequently
    //if u dont put next() u will be struck in this function
    next();
}

module.exports = log;