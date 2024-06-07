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

/**
 * PEMITE REALIZAR MODIFICACIONES EN EL PERFIL DEL USUARIO, MIRAR AYUDAS Y
 * CERRAR SESIÓN. SI ALGÚN USUARIO LO DESEA PUEDE PLANIFICAR UNA FECHA CON RECORDATORIO.
 */
class Configuracion_apgmotor : AppCompatActivity() {
    //PREPARACIÓN DE PANTALLA
    override fun onCreate(savedInstanceState: Bundle?) {
        // SE RECOGE EL VALOR POR DEFECTO DEL TEMA
        val apg_preferencias = PreferenceManager.getDefaultSharedPreferences(this)
        val apg_temas = apg_preferencias.getString("apg_temas", "Tema por Defecto")

//PRECARAGA FINALIZADA PARA EL CAMBIO DE LA CONTRASEÑA
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //IMPLEMENTACIÓN DE LA INTERFAZ XML NECESARIA
        setContentView(R.layout.activity_configuracion_apgmotor)

        /**
         * LOS BOTONES DE ESTA CLASE NO SE HAN COMENTADO, DEBIDO A QUE HAN SIDO COMENTADOS EN EL
         * RESTO DE LAS CLASES DE LA APLICACIÓN.
         */
        val btnCambiarContrasenna: Button = findViewById(R.id.btn_cambcont)
        btnCambiarContrasenna.setOnClickListener{
            //CAMBIO DE PANTALLA
            val intent: Intent = Intent(this, Cambiarcontrasenna_apgmotor:: class.java)
            startActivity(intent)
        }

       //SE ASIGNA EL VALOR DEL DESPLEGABLE DEL XML
        val apg_desplegableTemas: Spinner = findViewById(R.id.desplegabletemas)
//SE LE AÑADE LOS VALORES AL DESPLEGABLE
        val apg_opciones = arrayOf("Seleccione un Tema", "Tema por Defecto", "Tema Claro", "Tema Oscuro")

        // SE UTILIZA EL ADAPATADOR QUE INTEGRA ANDROID STUDIO PARA EL USO DE ESTE COMPONENTE SPINNER (DESPEGABLE)
        val apg_adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, apg_opciones)
        apg_adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        apg_desplegableTemas.adapter = apg_adaptador

        // SE AÑADE LA FUNCIONALIDAD AL DESPLEGABLE CREADO
        apg_desplegableTemas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                //SE ASIGNA EL ARRAY CON LAS POSICIONES SEGÚN LAS OPCIONES
                val opcionSeleccionada = apg_opciones[position]
                //PARA UNA VERSIÓN FUTURA SE AÑADIRÁN LOS DISTINTOS CAMBIOS EN TODAS LAS VENTANAS
                when (opcionSeleccionada) {
                    /**
                     * DE MOMENTO EN LA VERSIÓN DE PRUEBA PARA OBSERVAR FALLOS DE GAMAS DE COLORES,
                     * SOLAMENTE SE HA CAMBIADO EL COLOR DENTRO DEL DEPLEGABLE
                     */
                    "Tema por Defecto" -> setTheme(R.style.AppTheme)
                    "Tema Claro" -> setTheme(R.style.AppTheme_Clarito)
                    "Tema Oscuro" -> setTheme(R.style.AppTheme_Oscurito)
                }
            }
//SE HA DEJADO LA SIGUIENTE FUNCIÓN PARA ACTUALIZAR EL TEMA DE LA APLICACIÓN
            override fun onNothingSelected(parent: AdapterView<*>) {
             //SI NO SE SELECCIONA NADA EL TEMA ES POR DEFECTO LOS COLORES DE LA APP
                setTheme(R.style.AppTheme)
            }
        }

        /**
         * LOS BOTONES SIGUEN EL FORMATO UTILIZADO EN EL RESTO DE LA APLICACIÓN.
         * PARA RESUMIR: ASIGNACIÓN DEL XML, Y FUNCIONAMIENTO MÁS CAMBIO DE VENTANAS
         * AL SER PRESIONADO.
         */
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