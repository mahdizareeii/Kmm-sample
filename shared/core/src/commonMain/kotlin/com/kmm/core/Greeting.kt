package com.kmm.core

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}