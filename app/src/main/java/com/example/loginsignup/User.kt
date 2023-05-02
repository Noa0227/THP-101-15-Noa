package com.example.loginsignup

class User(var email: String?, var password: String?): java.io.Serializable {
    override fun toString(): String {
        return "Login info: $email / $password"
    }
}