package com.example.kotlinracingcar.domain

class Times(val times: Int) {

    init {
        require(times > 0) {
            "횟수는 양의 정수여야 합니다."
        }
    }
}
