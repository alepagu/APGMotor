package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Configuracion_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuracion_apgmotor)

        //Añadir funcionalidad a los botones
        val btnCambiarContrasenna: Button = findViewById(R.id.btn_cambcont)
        btnCambiarContrasenna.setOnClickListener{
            val intent: Intent = Intent(this, Cambiarcontrasenna_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}