package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
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
        // Obtener las preferencias del usuario
        val apg_preferencias = PreferenceManager.getDefaultSharedPreferences(this)
        val apg_temas = apg_preferencias.getString("apg_temas", "Tema por Defecto")

        // Establecer el tema según la preferencia del usuario
        when (apg_temas) {
            "Tema Claro" -> setTheme(R.style.AppTheme_Clarito)
            "Tema Oscuro" -> setTheme(R.style.AppTheme_Oscurito)
            else -> setTheme(R.style.AppTheme)
        }

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
        val apg_desplegableTemas: Spinner = findViewById(R.id.desplegabletemas)

        val apg_opciones = arrayOf("Tema por Defecto", "Tema Claro", "Tema Oscuro")

        // Adaptador para que el desplegable recoja los valores
        val apg_adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, apg_opciones)
        apg_adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        apg_desplegableTemas.adapter = apg_adaptador

        // Funcionalidad del desplegable según la selección obtenida
        apg_desplegableTemas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val opcionSeleccionada = apg_opciones[position]
                // Cambiar el tema según la opción seleccionada por el usuario
                //Para la versión del 27/05/2024 solo se cambia el color al usar el desplegable
                when (opcionSeleccionada) {
                    "Tema por Defecto" -> setTheme(R.style.AppTheme)
                    "Tema Claro" -> setTheme(R.style.AppTheme_Clarito)
                    "Tema Oscuro" -> setTheme(R.style.AppTheme_Oscurito)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Acción cuando no se ha seleccionado nada
                setTheme(R.style.AppTheme)
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