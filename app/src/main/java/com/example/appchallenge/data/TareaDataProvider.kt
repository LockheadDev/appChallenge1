package com.example.appchallenge.data

object TareaDataProvider {
    val tareas: MutableList<Tarea> = mutableListOf()
    fun addDat(tarea: Tarea)
    {
        tareas.add(tarea)
    }
    fun getDat() : List<Tarea>{
        return tareas
    }
}