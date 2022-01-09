package com.example.kotlinracingcar.domain

class Game(private val cars: Cars, val times: Times) {

    fun race(moveStrategy: MoveStrategy): Pair<List<Cars>, List<Car>> {
        val allMovedCars = mutableListOf<Cars>()

        repeat(times.times) {
            val movedCars = cars.move(moveStrategy)
            allMovedCars.add(movedCars)
        }

        return allMovedCars to findWinners(allMovedCars.last())
    }

    private fun findWinners(movedCars: Cars): List<Car> {
        val maxPosition = movedCars.findMaxPosition()
        val carsInTheSamePosition = movedCars.findCarsInTheSamePosition(maxPosition)

        return carsInTheSamePosition.cars
    }
}
