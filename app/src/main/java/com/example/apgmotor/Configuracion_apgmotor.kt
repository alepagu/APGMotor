package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

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

       //Añadir lista de compornentes al Desplegable de esta pantalla
        val desplegable: Spinner = findViewById(R.id.desplegabletemas)

        val opciones = arrayOf("Tema por Defecto", "Tema Claro", "Tema Oscuro")

        // Adaptador para que el desplegable recoja los valores
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        desplegable.adapter = adaptador

        // Funcionalidad del desplegable segúl la selección
        desplegable.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val opcionSeleccionada = opciones[position]
                // Hacer algo con la opción seleccionada
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Acción cuando no se ha seleccionado nada
            }
        }

        //Indicamos al botón de Preguntas frecuentes donde se debe dirigir.
        val btnPreguntasFrecuentes: Button = findViewById(R.id.btn_faq)
        btnPreguntasFrecuentes.setOnClickListener{
            val intent: Intent = Intent(this, Preguntasfrecuentes_apgmotor:: class.java)
            startActivity(intent)
        }

        //Función del botón planificar fecha
        val btnplanificarFecha: Button = findViewById(R.id.btn_pfecha)
        btnplanificarFecha.setOnClickListener{
            val intent: Intent = Intent(this, planificarfecha_apgmotor:: class.java)
            startActivity(intent)
        }

        //Función del botón cerrar sesión
        val btnapgcierrasesion: Button = findViewById(R.id.btn_cerrarsesion)
        btnapgcierrasesion.setOnClickListener{
            //Generamos la aparición de un mensaje por la interfaz que indique lo que has confirmado.
            Toast.makeText(this, "Has cerrado sesión.", Toast.LENGTH_SHORT).show()

            val intent: Intent = Intent(this, Login_apgmotor:: class.java)
            startActivity(intent)
        }

    }
}