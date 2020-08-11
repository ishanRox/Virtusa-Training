const os = require('os');
const { log } = require('console');
const totalMemory = os.totalmem() / 1024;
const freeMemory = os.freemem() / 1024;

console.log(`total memory ${totalMemory} free memory ${freeMemory}`);

const fileSystem = require('fs');

console.log(fileSystem.readdirSync('./'));

const readAsync = fileSystem.readdir('./sf', (error, files) => {
    if (error) console.log('error', error);
    else console.log('result', files);
});

