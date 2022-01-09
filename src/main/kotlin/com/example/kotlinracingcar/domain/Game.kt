package com.example.kotlinracingcar.domain

class Game(private val cars: Cars, val times: Times) {

    fun race(moveStrategy: MoveStrategy) {
        val allMovedCars = mutableListOf<Cars>()

        repeat(times.times) {
            val movedCars = cars.move(moveStrategy)
            allMovedCars.add(movedCars)
        }


    }
}
