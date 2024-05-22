package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Cambiarcontrasenna_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cambiarcontrasenna_apgmotor)

        //Ajuste de lo que debe hacer el botón de confirmación
        val btncambiarcontradenna: Button = findViewById(R.id.btn_cambiacontra)
        btncambiarcontradenna.setOnClickListener{
            //Generamos la aparición de un mensaje informativo por la interfaz
            Toast.makeText(this, "La contraseña ha sido cambiada con éxito. Has sido redirigido a página principal.", Toast.LENGTH_SHORT).show()

            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}