package com.example.appchallenge.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Tarea(val Nombre : String, val Descripcion : String, val timeStamp: String, val Prioridad : Int):
    Parcelable {

}
