package com.example.kotlinracingcar.domain

class Car(val name: String, val position: Int = 0) {

    init {
        require(name.isNotBlank() && name.length <= 5) {
            "이름은 1자 이상, 5자 이하여야 합니다."
        }
    }
}
