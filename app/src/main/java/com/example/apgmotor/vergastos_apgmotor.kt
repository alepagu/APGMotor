package com.example.apgmotor

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Connection
import java.sql.Statement

/**
 * En esta clase se mostrará la ventana gastos, en la siguiente versión de actualización:
 * Se implementará el apartado de la base de datos de esta parte y se imprimirá la actualización completa de los datos.
 * Ya que por el tiempo actual es una parte que solo tiene dos campos por pantalla.
 */
class vergastos_apgmotor : AppCompatActivity() {
    //PRECARAGA DE LA VENTANA COMPLETA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //IMPORTACIÓN DE LA INTERFAZ XML QUE NECESITAMOS UTILIZAR
        setContentView(R.layout.activity_vergastos_apgmotor)

    }
}