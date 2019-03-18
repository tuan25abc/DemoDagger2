package com.example.tuannguyen.demodagger2.model

import javax.inject.Inject

interface InfoInterface {
    fun getMessage(): String
}

class Info @Inject constructor(): InfoInterface {
    val text = "Hello Dagger 2"

    override fun getMessage(): String {
        return text
    }
}