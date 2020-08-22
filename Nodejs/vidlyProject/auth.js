function auth(req, res, nextMethod) {
    console.log('Authentication...');
    nextMethod();
}

module.exports = auth;