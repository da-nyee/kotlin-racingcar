package com.example.kotlinracingcar.domain

class Game(private val cars: Cars, val times: Times) {

    fun race(moveStrategy: MoveStrategy): Pair<List<Cars>, List<Car>> {
        val movedCars = mutableListOf(cars)

        repeat(times.times) {
            val beforeMovedCars = movedCars.last()
            val afterMovedCars = beforeMovedCars.move(moveStrategy)
            movedCars.add(afterMovedCars)
        }
        movedCars.removeAt(0)

        return movedCars to findWinners(movedCars.last())
    }

    private fun findWinners(movedCars: Cars): List<Car> {
        val maxPosition = movedCars.findMaxPosition()
        val carsInTheSamePosition = movedCars.findCarsInTheSamePosition(maxPosition)

        return carsInTheSamePosition.cars
    }
}
