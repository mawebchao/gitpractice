const jwt = require('jsonwebtoken')
const { secretKey, expiresIn } = require('../config/config')
function generateToken(id, scope) {
    return  jwt.sign(
        {
            uid, scope
        },
        secretKey,
        {
            expiresIn
        }
    )
    
}

module.exports = { generateToken }