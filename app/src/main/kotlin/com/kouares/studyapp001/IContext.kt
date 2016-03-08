package com.kouares.studyapp001

import com.kouares.studyapp001.model.Number
import com.kouares.studyapp001.model.Operation

/**
 * Created by koichi on 2016/03/05.
 */

interface IContext {

    var a: Double
    var b: Double
    var op: Operation

    fun changeState(IState: IState)

    fun doOperation(): Double

    fun showDisplay()

    fun showDisplay(d: Double)

    fun addDisplayNumber(num: Number)

    fun saveDisplayNumberToA()

    fun saveDisplayNumberToB()

    fun clearA()

    fun clearB()

    fun clearDisplay()

    fun copyAtoB()

    fun setError()

    fun clearError()

    fun changeSign()
}


