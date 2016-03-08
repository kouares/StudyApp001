package com.kouares.studyapp001.model

/**
 * Created by koichi on 2016/03/05.
 */

enum class Operation() {
    PLUS {
        override fun eval(x: Double, y: Double) : Double { return x + y }
    },
    MINUS {
        override fun eval(x: Double, y: Double): Double { return x - y }
    },
    TIMES {
        override fun eval(x: Double, y: Double): Double { return x * y }
    },
    DIVIDE {
        override fun eval(x: Double, y: Double): Double { return x / y }
    },
    NONE {
        override fun eval(x: Double, y: Double): Double { throw UnsupportedOperationException() }
    };


    abstract fun eval(x: Double, y: Double): Double
}