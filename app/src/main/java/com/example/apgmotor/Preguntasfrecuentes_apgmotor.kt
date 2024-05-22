package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Preguntasfrecuentes_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preguntasfrecuentes_apgmotor)

        //Indicar con la funcionalidad que realiza el botón OK
        val btnOK: Button = findViewById(R.id.btn_ok)
        btnOK.setOnClickListener{
            //Generamos la aparición de un mensaje informativo por la interfaz
            Toast.makeText(this, "Redirigido a la página principal.", Toast.LENGTH_SHORT).show()

            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}