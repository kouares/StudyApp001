package com.kouares.studyapp001.model

import com.kouares.studyapp001.IContext
import com.kouares.studyapp001.IState

/**
 * Created by koichi on 2016/03/06.
 */

object ResultStateImpl : IState {

    override fun onInputNumber(context: IContext, num: Number) {
        context.clearDisplay()
        context.addDisplayNumber(num)
        context.changeState(NumberAStateImpl)
    }

    override fun onInputOperation(context: IContext, op: Operation) {
        context.saveDisplayNumberToA()
        context.op = op
        context.changeState(OperationStateImpl)
    }

    override fun onInputEqual(context: IContext) {
        // no impl
    }

    override fun onInputClear(context: IContext) {
        clear(context)
    }

    override fun onInputAllClear(context: IContext) {
        clear(context)
    }

    private fun clear(IContext: IContext) {
        IContext.clearA()
        IContext.clearB()
        IContext.clearDisplay()
        IContext.changeState(NumberAStateImpl)
    }
}
