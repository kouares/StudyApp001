package com.kouares.studyapp001.controller

import android.widget.TextView
import com.kouares.studyapp001.model.Number
import com.kouares.studyapp001.AbstractDisplay

/**
 * Created by koichi on 2016/03/05.
 */

class StringDisplay : AbstractDisplay {

    private val txt : TextView

    constructor(disp : TextView) {
        clear()
        txt = disp
    }

    override fun onInputBackSpace() {
    }

    override fun onInputNumber(num: Number) {
        when (num) {
            Number.DOUBLE_ZERO -> {
                addNumber(num)
                addNumber(num)
            }
            Number.COMMA -> {
                if (!commaMode) {
                    commaMode = true
                    decimalPlaces = 0
                }
            }
            else -> addNumber(num)
        }
    }

    fun addNumber(num: Number) {
        if (displayChar.size < DIGIT) {
            displayChar.push(num.str)

            if (commaMode)
                decimalPlaces++
        }
    }

    override fun showDisplay(format: Boolean) {
        var sb = StringBuffer()
        displayChar.forEach { str -> sb.append(str) }

        System.out.println(sb.toString() + " line 51")

        if (commaMode && decimalPlaces > 0)
            sb.insert(sb.length - decimalPlaces, ".")

        if (sb.length == 0)
            sb.append("0")

        if (minus)
            sb.insert(0, "-")

        if (format && commaMode && decimalPlaces > 0) {
            var sbOut = StringBuffer()
            var commaFlag = false

            val length = sb.length - 1
            for (temp in 0..length) {
                var index = length - temp

                if (commaFlag) {
                    sbOut.insert(0, sb[index])
                } else {
                    if (sb[index] == '0') {
                        continue
                    } else if (sb[index] == '.') {
                        commaFlag = true
                    } else {
                        commaFlag = true
                        sbOut.insert(0, sb[index])
                    }
                }
            }

            sb = sbOut
        }

        txt.text = sb.toString()
    }

    override fun clear() {
        commaMode = false
        decimalPlaces = 0
        minus = false
        displayChar.clear()
    }

    override fun setError() {
        // no impl
    }

    override fun clearError() {
        // no impl
    }

    override fun getNumber(): Double {
        var sb = StringBuffer()
        displayChar.forEach { str -> sb.append(str) }

        if (commaMode && decimalPlaces > 0)
            sb.insert(sb.length - decimalPlaces, ".")

        if (minus)
            sb.insert(0, "-")

        try {
          return sb.toString().toDouble()
        } catch (e : Exception) {
            return 0.0
        }
    }

    override fun setNumber(d: Double) {
        clear()
        var format = StringBuffer()
        format.append("%.").append(DIGIT.toString()).append("f").toString()
        var number = String.format(format.toString(), Math.abs(d))

        number.forEach { numberChar ->
            if (numberChar != '.') {
                displayChar.push(numberChar.toString())

                if (commaMode)
                    decimalPlaces++
            } else {
                commaMode = true
            }

            if (displayChar.size >= DIGIT)
                return
        }
        
        if (d < 0)
            minus = true
    }
}