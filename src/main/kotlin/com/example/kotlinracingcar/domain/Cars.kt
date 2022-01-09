package com.example.kotlinracingcar.domain

class Cars(private val cars: List<Car>) {

    init {
        require(setOf(cars).size == cars.size) {
            "이름은 중복될 수 없습니다."
        }
    }

    fun move(moveStrategy: MoveStrategy): Cars {
        val movedCars = cars.map { car -> car.move(moveStrategy) }

        return Cars(movedCars)
    }
}
