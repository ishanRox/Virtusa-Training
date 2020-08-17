const http = require('http');

const server = http.createServer((request, response) => {

    //we handling routes
    if (request.url === '/') {
        response.write('<h1>hello ishan</h1>');
        response.end();
    }
    if (request.url === '/hi') {
        response.write(JSON.stringify([1, 2, 3, 4, 5]));
        response.end();
    }
});

server.listen(3000);

console.log('listning to port 3000');