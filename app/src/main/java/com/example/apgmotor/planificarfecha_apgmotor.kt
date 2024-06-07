package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Esta clase se encuentra conectada al google calendar de forma indirecta y en formato widget.
 * Se ha preparado para de cara a versiones futuras perfeccionar la aplicación.
 */
class planificarfecha_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //PRECARGA DE LA VENTANA
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //INSTANCIA DE LA INTERFAZ XML QUE REPRESENTA LA VENTANA SIN FUNCIONES
        setContentView(R.layout.activity_planificarfecha_apgmotor)

        //FUNCIONALIDAD DEL BOTÓN
        val btnguardarFecha: Button = findViewById(R.id.btn_guardarfecha)
        //AÑADIMOS EL MENSAJE POR DEFECTO PARA EL RECORDATORIO
        btnguardarFecha.setOnClickListener {
            //MENSAJE POR LA INTERFAZ, APARECE TRAS PULSAR EL BOTÓN Y REALIZAR LAS FUNCIONES NECESARIAS
            Toast.makeText(
                this,
                "El día seleccionado recibirá un mensaje a las 00:00. Has sido redirigido a página principal.",
                Toast.LENGTH_SHORT
            ).show()

//INTERCAMBIO DE VENTANAS CUANDO SE REALIZA LA FUNCIÓN COMPLETA
            val intent: Intent = Intent(this, paginaprincipal_apgmotor::class.java)
            startActivity(intent)
        }
        //MVC, ciclo de la vida de la app
    }
}