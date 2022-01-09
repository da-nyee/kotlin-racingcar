package com.example.kotlinracingcar.controller

import com.example.kotlinracingcar.domain.*
import com.example.kotlinracingcar.view.InputView
import com.example.kotlinracingcar.view.OutputView

class RacingCarController {

    fun run() {
        val cars = toCars(InputView.scanCarNames())
        val times = toTimes(InputView.scanTimes())

        val game = Game(cars, times)
        val result = game.race(RandomMoveStrategy())

        OutputView.printResults(result)
    }

    private fun toCars(carNames: List<String>): Cars {
        return Cars(carNames.map { car -> Car(car) })
    }

    private fun toTimes(times: Int): Times {
        return Times(times)
    }
}
