package com.codelabs.basicstatecodelab

import android.app.Application
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.AndroidViewModel

class WellnessViewModel(application: Application) : AndroidViewModel(application) {
    private val _tasks = getWellnessTasks(application).toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        val taskIndex = _tasks.indexOf(item)
        _tasks[taskIndex] = WellnessTask(item.id, label = item.label, checked)
    }
}

private fun getWellnessTasks(application: Application) = List(30) { i -> WellnessTask(i, application.resources.getString(R.string.task_label, i), false) }
