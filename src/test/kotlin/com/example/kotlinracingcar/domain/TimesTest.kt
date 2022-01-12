package com.example.kotlinracingcar.domain

import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class TimesTest {

    @ParameterizedTest
    @MethodSource("validTimes")
    fun `create a Times - Success`(times: Int) {
        assertThatCode { Times(times) }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @MethodSource("invalidTimes")
    fun `create a Times - Fail`(times: Int) {
        assertThrows<IllegalArgumentException> { Times(times) }
    }

    companion object {

        @JvmStatic
        fun validTimes() = Stream.of(
            Arguments.of(1),
            Arguments.of(4),
            Arguments.of(18),
            Arguments.of(26)
        )

        @JvmStatic
        fun invalidTimes() = Stream.of(
            Arguments.of(0),
            Arguments.of(-1),
            Arguments.of(-32)
        )
    }
}
