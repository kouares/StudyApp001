package com.kouares.studyapp001.model

import com.kouares.studyapp001.IContext
import com.kouares.studyapp001.IState

/**
 * Created by koichi on 2016/03/05.
 */

object NumberAStateImpl : IState {

    override fun onInputNumber(context: IContext, num: Number) {
        context.addDisplayNumber(num)
    }

    override fun onInputOperation(context: IContext, op: Operation) {
        context.saveDisplayNumberToA()
        context.op = op
        context.changeState(OperationStateImpl)
    }

    override fun onInputEqual(context: IContext) {
        context.saveDisplayNumberToA()
        context.showDisplay(context.a)
        context.changeState(ResultStateImpl)
    }

    override fun onInputClear(context: IContext) {
        context.clearA()
        context.clearDisplay()
    }

    override fun onInputAllClear(context: IContext) {
        context.clearA()
        context.clearB()
        context.clearDisplay()
    }

}