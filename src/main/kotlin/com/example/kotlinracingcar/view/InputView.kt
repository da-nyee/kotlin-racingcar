package com.example.kotlinracingcar.view

class InputView {

    companion object {
        fun scanCarNames(): List<String> {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

            val carNames = readLine()

            if (carNames!!.contains(",,")) {
                throw IllegalArgumentException("이름에 쉼표(,)는 연속으로 입력될 수 없습니다.")
            }
            return carNames.replace(" ", "").split(",")
        }

        fun scanTimes(): Int {
            println("시도할 횟수는 몇회인가요?")

            return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("횟수는 숫자만 입력해주세요.")
        }
    }
}
