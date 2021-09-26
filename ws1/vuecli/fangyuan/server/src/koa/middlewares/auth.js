const jwt=require('jsonwebtoken')

const {secretKey} =require('../config/config')

class Auth{
    static verifyToken(token){
        try {
            jwt.verify(token,secretKey)
            return true;
        } catch (error) {
            return false;
        }
    }
}
module.exports=Auth