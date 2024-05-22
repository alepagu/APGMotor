package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Registro_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno
        setContentView(R.layout.registro_apgmotor)

        //Añadir funcionalidad al botón Registrarme
        val btnRegistrado: Button = findViewById(R.id.btnregistrar)
        btnRegistrado.setOnClickListener{
            //Generamos la aparición de un mensaje por la interfaz que indique el motivo del desplazamiento
            Toast.makeText(this, "Los datos ingresados ya han sido validados, inicie sesión.", Toast.LENGTH_SHORT).show()

            val intent: Intent = Intent(this, Login_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}