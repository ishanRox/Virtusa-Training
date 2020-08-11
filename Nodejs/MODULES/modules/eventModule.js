const EventEmitter = require('events');

const emitter = new EventEmitter();

//Register a listenr
emitter.on('messageLogged', _ => console.log('listner1 called'));

emitter.on('messageLogged', _ => console.log('listner2 called'));


//raised event but nothing happens because no listners listning to this
//Raise an event
emitter.emit('messageLogged');
//English class for me - making a noise,or produce something

//this listener not registerd because its declared after the emitter
emitter.on('messageLogged', _ => console.log('listner3 called'));
