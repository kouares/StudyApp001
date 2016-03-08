package com.kouares.studyapp001

import java.util.Stack
import com.kouares.studyapp001.model.Number

/**
 * Created by koichi on 2016/03/05.
 */

abstract class AbstractDisplay {

    internal val displayChar : Stack<String> = Stack()
    internal var commaMode : Boolean = false
    internal var minus : Boolean = false
    protected val DIGIT : Int = 12
    protected var decimalPlaces : Int = 0

    abstract fun showDisplay(format: Boolean)

    abstract fun onInputNumber(num: Number)

    abstract fun onInputBackSpace()

    abstract fun clear()

    abstract fun getNumber() : Double

    abstract fun setNumber(d: Double)

    abstract fun setError()

    abstract fun clearError()

    fun isDispOverflow(d: Double) : Boolean {

        val sb = StringBuffer()
        for (i in 1..DIGIT) {
            sb.append("9")
        }
        var max = sb.toString().toDouble()

        if (d > max) {
            return true
        }
        return false
    }

    override fun toString() : String {
        return displayChar.toString()
    }
}