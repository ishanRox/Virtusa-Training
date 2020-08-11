
const { EventEmitter } = require("events");

class Logger extends EventEmitter {

    log(message) {
        //Raise an event 
        this.emit('messagelog', message + " recived by all listners")
    }
}

module.exports = Logger;