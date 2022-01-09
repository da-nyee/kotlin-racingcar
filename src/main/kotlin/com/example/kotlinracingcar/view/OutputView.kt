package com.example.kotlinracingcar.view

import com.example.kotlinracingcar.domain.Car
import com.example.kotlinracingcar.domain.Cars

class OutputView {

    companion object {
        fun printResults(pair: Pair<List<Cars>, List<Car>>) {
            println()
            println("실행 결과")

            for (cars in pair.first) {
                printResult(cars)
            }

            val names = pair.second.map { car -> car.name }
            printWinners(names)
        }

        private fun printResult(cars: Cars) {
            for (car in cars.cars) {
                println("${car.name} : ${"-".repeat(car.position)}")
            }
            println()
        }

        private fun printWinners(names: List<String>) {
            println("최종 우승자: ${names.joinToString(", ")}")
        }
    }
}
