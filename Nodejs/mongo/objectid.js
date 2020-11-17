const mongoose = require('mongoose');
const id = new mongoose.Types.ObjectId();

//object id
console.log(id);
//timestamp
console.log(id.getTimestamp());
//check valid or not
console.log(mongoose.Types.ObjectId.isValid(id));
console.log(mongoose.Types.ObjectId.isValid('dsf22ishan'));