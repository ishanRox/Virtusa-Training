const EventEmitter= require('events');

const emitter= new EventEmitter();

//Regeister a listner
emitter.on('msg',(args)=>{
console.log(`recived args from emmiter ${args}`);
});
//Raise an event
emitter.emit('msg',{id:123,name:ishan})