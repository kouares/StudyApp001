package com.kouares.studyapp001

import com.kouares.studyapp001.model.Number
import com.kouares.studyapp001.model.Operation

/**
 * Created by koichi on 2016/03/05.
 */

interface IState {

    fun onInputNumber(context: IContext, num: Number)

    fun onInputOperation(context: IContext, op: Operation)

    fun onInputEqual(context: IContext)

    fun onInputClear(context: IContext)

    fun onInputAllClear(context: IContext)
}
