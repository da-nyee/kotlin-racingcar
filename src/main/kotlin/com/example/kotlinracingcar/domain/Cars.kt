package com.example.kotlinracingcar.domain

class Cars(val cars: List<Car>) {

    init {
        require(cars.toSet().size == cars.size) {
            "이름은 중복될 수 없습니다."
        }
    }

    fun move(moveStrategy: MoveStrategy): Cars {
        val movedCars = cars.map { car -> car.move(moveStrategy) }

        return Cars(movedCars)
    }

    fun findMaxPosition(): Int {
        return cars.maxByOrNull { car -> car.position }?.position ?: 0
    }

    fun findCarsInTheSamePosition(position: Int): Cars {
        return Cars(cars.filter { car -> car.isSamePosition(position) })
    }
}
