const joi = require('joi');
const mongoose = require('mongoose');

//practicle of single responsibility in practice model folder only contain
//definition of customers route folder contain only routes
const Customer = mongoose.model('Customer', new mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
            minlength: 5,
            maxlength: 50
        },
        isGold: {
            type: Boolean,
            default: false
        },
        phone: {
            type: String,
            required: true,
            minlength: 5,
            maxlength: 50
        }
    }
));

function validateCustomer(customer) {
    const schema = {
        name: joi.string().min(5).max(50).required()
        ,
        phone: joi.string().min(5).max(50).required()
        ,
        isGold: joi.boolean()
    };
    return joi.validate(customer, schema);
}


//module.exports.Customer=Customer;
// or below is a easy way export object also refer to same module.export

exports.Customer = Customer;
exports.validateCustomer = validateCustomer;