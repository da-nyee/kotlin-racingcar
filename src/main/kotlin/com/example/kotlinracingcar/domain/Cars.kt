package com.example.kotlinracingcar.domain

class Cars(val cars: List<Car>) {

    init {
        require(setOf(cars).size == cars.size) {
            "이름은 중복될 수 없습니다."
        }
    }
}
