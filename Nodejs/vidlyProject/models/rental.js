const mongoose = require('mongoose');
const joi = require('joi');


const Rental = new mongoose.model('Rental',
    new mongoose.Schema(
        {

            customer: {
                type: new mongoose.Schema({
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
                }),
                //rental eke type eka mongoose schma
                movie: {
                    type: new mongoose.Schema({
                        title: {
                            type: String,
                            required: true,
                            trim: true,
                            minlength: 5,
                            maxlength: 255
                        },
                        dailyRentalRate: {
                            type: Number,
                            required: true,
                            min: 0,
                            max: 255
                        },
                    }),
                    required: true
                },
                dateOut: {
                    type: Date,
                    required: true,
                    default: Date.now
                },
                dateReturned: {
                    type: Date
                },
                rentalFee: {
                    type: Number,
                    min: 0
                }

            }
        }
    )
);


function validateRentals(rental) {
    const schema = {
        customerId: joi.string().required(),
        movieId: joi.string().required()
    };
    return joi.validate(rental, schema);
}

exports.Rental = Rental;
exports.validateRentals = validateRentals;