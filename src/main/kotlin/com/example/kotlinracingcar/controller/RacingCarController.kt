package com.example.kotlinracingcar.controller

import com.example.kotlinracingcar.domain.Car
import com.example.kotlinracingcar.domain.Cars
import com.example.kotlinracingcar.domain.RacingCar
import com.example.kotlinracingcar.domain.Times
import com.example.kotlinracingcar.view.InputView

class RacingCarController {

    fun run() {
        val cars = toCars(InputView.scanCarNames())
        val times = toTimes(InputView.scanTimes())

        val racingCar = RacingCar(cars, times)
    }

    private fun toCars(carNames: List<String>): Cars {
        return Cars(carNames.map { car -> Car(car) })
    }

    private fun toTimes(times: Int): Times {
        return Times(times)
    }
}
