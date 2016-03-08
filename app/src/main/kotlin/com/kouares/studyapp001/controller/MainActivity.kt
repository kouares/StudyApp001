package com.kouares.studyapp001.controller

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.kouares.studyapp001.model.Calc
import com.kouares.studyapp001.model.Number
import com.kouares.studyapp001.model.Operation

/**
 * Created by koichi on 2016/03/06.
 */

class MainActivity : Activity() {

    var calc : Calc? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        var disp = findViewById(R.id.display) as TextView

        calc = Calc()
        calc!!.disp = StringDisplay(disp)
        calc!!.parent = this
    }

    fun onClickButton(view: View) = when(view.id) {
        R.id.zero -> calc!!.onButtonNumber(Number.ZERO)
        R.id.doublezero -> calc!!.onButtonNumber(Number.DOUBLE_ZERO)
        R.id.one -> calc!!.onButtonNumber(Number.ONE)
        R.id.two -> calc!!.onButtonNumber(Number.TWO)
        R.id.three -> calc!!.onButtonNumber(Number.THREE)
        R.id.four -> calc!!.onButtonNumber(Number.FOUR)
        R.id.five -> calc!!.onButtonNumber(Number.FIVE)
        R.id.six -> calc!!.onButtonNumber(Number.SIX)
        R.id.seven -> calc!!.onButtonNumber(Number.SEVEN)
        R.id.eight -> calc!!.onButtonNumber(Number.EIGHT)
        R.id.nine -> calc!!.onButtonNumber(Number.NINE)
        R.id.plus -> calc!!.onButtonOp(Operation.PLUS)
        R.id.minus -> calc!!.onButtonOp(Operation.MINUS)
        R.id.times -> calc!!.onButtonOp(Operation.TIMES)
        R.id.divide -> calc!!.onButtonOp(Operation.DIVIDE)
        R.id.comma -> calc!!.onButtonNumber(Number.COMMA)
        R.id.allclear -> calc!!.onButtonAllClear()
        R.id.clear -> calc!!.onButtonClear()
        R.id.equal -> calc!!.onButtonEqual()
        R.id.sign -> calc!!.changeSign()
        else -> throw IllegalStateException()
    }
}
