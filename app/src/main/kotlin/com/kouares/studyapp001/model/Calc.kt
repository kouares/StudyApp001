package com.kouares.studyapp001.model

import android.content.Context
import android.widget.Toast
import com.kouares.studyapp001.exception.CalcException
import com.kouares.studyapp001.IContext
import com.kouares.studyapp001.IState
import com.kouares.studyapp001.AbstractDisplay

/**
 * Created by koichi on 2016/03/05.
 */

class Calc : IContext {

    constructor() {
        a = 0.0
        b = 0.0
        op = Operation.NONE
        state = NumberAStateImpl
    }

    override var a: Double

    override var b: Double

    override var op: Operation

    var disp: AbstractDisplay? = null

    var parent: Context? = null

    protected var state: IState

    fun onButtonNumber(num: Number) = state.onInputNumber(this, num)

    fun onButtonOp(op: Operation) = state.onInputOperation(this, op)

    fun onButtonClear() = state.onInputClear(this)

    fun onButtonAllClear() = state.onInputAllClear(this)

    fun onButtonEqual() = state.onInputEqual(this)

    override fun addDisplayNumber(num: Number) {

        if (num == Number.ZERO || num == Number.DOUBLE_ZERO) {
            if (disp!!.displayChar.size == 0 && !disp!!.commaMode) {
                disp!!.showDisplay(false)

                return
            }
        }

        if (num == Number.COMMA && !disp!!.commaMode && disp!!.displayChar.size == 0) {
            disp!!.onInputNumber(Number.ZERO)
        }

        disp!!.onInputNumber(num)
        disp!!.showDisplay(false)
    }

    override fun clearDisplay() {
        disp!!.clear()
        disp!!.showDisplay(false)
    }

    override fun clearA() {
        a = 0.0
    }

    override fun clearB() {
        b = 0.0
    }

    override fun doOperation(): Double {
        var result = op.eval(a, b)

        if (Double.POSITIVE_INFINITY == result || Double.NEGATIVE_INFINITY == result)
            throw CalcException()

        showDisplay(result)

        if (disp!!.isDispOverflow(result))
            throw CalcException()

        return result
    }

    override fun saveDisplayNumberToA() {
        a = disp!!.getNumber()
    }

    override fun saveDisplayNumberToB() {
        b = disp!!.getNumber()
    }

    override fun showDisplay() {
        disp!!.showDisplay(false)
    }

    override fun showDisplay(d: Double) {
        disp!!.setNumber(d)
        disp!!.showDisplay(true)
    }

    override fun changeState(IState: IState) {
        state = IState
    }

    override fun copyAtoB() {
        b = a
    }

    override fun clearError() {
        disp!!.clearError()
    }

    override fun setError() {
        Toast.makeText(parent, "ERROR", Toast.LENGTH_LONG).show()
        disp!!.setError()
    }

    override fun changeSign() {
        if (disp!!.getNumber() != 0.0) {
            disp!!.minus = !disp!!.minus
            disp!!.showDisplay(false)
        }
    }
}
