const Logger = require('./logger');

const logger = new Logger();

//register a logger

logger.on('messagelog', (args) => console.log(`called logger ${args}`));

logger.log('hello')