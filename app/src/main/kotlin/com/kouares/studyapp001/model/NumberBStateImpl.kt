package com.kouares.studyapp001.model

import com.kouares.studyapp001.IContext
import com.kouares.studyapp001.IState
import com.kouares.studyapp001.exception.CalcException
import com.kouares.studyapp001.model.Number
import com.kouares.studyapp001.model.Operation

/**
 * Created by koichi on 2016/03/06.
 */

object NumberBStateImpl : IState {

    override fun onInputNumber(context: IContext, num: Number) {
        context.addDisplayNumber(num)
    }

    override fun onInputOperation(context: IContext, op: Operation) {
        try {
            context.saveDisplayNumberToB()
            context.doOperation()
            context.op = op
            context.saveDisplayNumberToA()
            context.changeState(OperationStateImpl)
        } catch (e: CalcException) {
            context.setError()
            context.changeState(ErrorStateImpl)
        }
    }

    override fun onInputEqual(context: IContext) {
        try {
            context.saveDisplayNumberToB()
            context.doOperation()
            context.changeState(ResultStateImpl)
        } catch (e: CalcException) {
            context.setError()
            context.changeState(ErrorStateImpl)
        }
    }

    override fun onInputClear(context: IContext) {
        context.clearB()
        context.clearDisplay()
    }

    override fun onInputAllClear(context: IContext) {
        context.clearA()
        context.clearB()
        context.clearDisplay()

        context.changeState(NumberAStateImpl)
    }
}