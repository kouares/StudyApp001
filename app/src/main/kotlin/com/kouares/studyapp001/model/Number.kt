package com.kouares.studyapp001.model

/**
 * Created by koichi on 2016/03/05.
 */

enum class Number(val value : String) {
    COMMA(","),
    ZERO("0"),
    DOUBLE_ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9");

    val str : String = value
}