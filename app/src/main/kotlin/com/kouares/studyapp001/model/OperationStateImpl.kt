package com.kouares.studyapp001.model

import com.kouares.studyapp001.exception.CalcException
import com.kouares.studyapp001.IContext
import com.kouares.studyapp001.IState

/**
 * Created by koichi on 2016/03/05.
 */

object OperationStateImpl : IState {

    override fun onInputNumber(context: IContext, num: Number) {
        context.clearDisplay()
        context.addDisplayNumber(num)

        context.changeState(NumberBStateImpl)
    }

    override fun onInputOperation(context: IContext, op: Operation) {
        context.op = op
    }

    override fun onInputEqual(context: IContext) {
        when(context.op) {
            Operation.DIVIDE, Operation.TIMES -> {
                try {
                    context.copyAtoB()
                    context.doOperation()
                    context.changeState(ResultStateImpl)
                } catch (e: CalcException) {
                    context.setError()
                    context.changeState(ErrorStateImpl)
                }
            }
            Operation.MINUS, Operation.PLUS -> {
                context.showDisplay(context.a)
                context.changeState(ResultStateImpl)
            }
            else -> throw IllegalStateException()
        }
    }

    override fun onInputClear(context: IContext) {
        context.clearA()
        context.clearDisplay()
        context.changeState(NumberAStateImpl)
    }

    override fun onInputAllClear(context: IContext) {
        context.clearA()
        context.clearB()
        context.clearDisplay()
        context.changeState(NumberAStateImpl)
    }
}