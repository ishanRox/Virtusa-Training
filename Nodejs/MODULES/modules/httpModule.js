const http = require('http');

//this is a event emitter
const server = http.createServer();
//name of the event emitt when some request hit the server is connection 
//dont memorize all in doc
server.on('connection',(socket)=>console.log('new connection....'));

server.listen(3000);

console.log('listening on port 3000');