package com.kouares.studyapp001.model

import com.kouares.studyapp001.IContext
import com.kouares.studyapp001.IState

/**
 * Created by koichi on 2016/03/06.
 */

object ErrorStateImpl : IState {

    override fun onInputNumber(context: IContext, num: Number) {
        // no impl
    }

    override fun onInputOperation(context: IContext, op: Operation) {
        // no impl
    }

    override fun onInputEqual(context: IContext) {
        // no impl
    }

    override fun onInputClear(context: IContext) {
        // no impl
    }

    override fun onInputAllClear(context: IContext) {
        context.clearA()
        context.clearB()
        context.clearDisplay()
        context.clearError()
        context.changeState(NumberAStateImpl)
    }

}