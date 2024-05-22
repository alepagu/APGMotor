package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class planificarfecha_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_planificarfecha_apgmotor)

        //Funcionalidad del botón
        val btnguardarFecha: Button = findViewById(R.id.btn_guardarfecha)
        btnguardarFecha.setOnClickListener{
            //Generamos la aparición de un mensaje informativo por la interfaz
            Toast.makeText(this, "El día seleccionado recibirá un mensaje a las 00:00. Has sido redirigido a página principal.", Toast.LENGTH_SHORT).show()

            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }
        //MVC, ciclo de la vida de la app
    }
}