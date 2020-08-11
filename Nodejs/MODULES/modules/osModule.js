const os= require('os');
const { log } = require('console');
const totalMemory=os.totalmem();
const freeMemory=os.freemem();

console.log(`total memory ${totalMemory} free memory ${freeMemory}`);