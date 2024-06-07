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
 * La clase se encaraga de representar el aparatado de preguntas frecuentes,
 * este se ha diseñado de cara al usuario y dudas que el mismo pueda tener.
 * De cara a versiones futuras se añadirán más y se ordenarán según las mas vistas.
 */
class Preguntasfrecuentes_apgmotor : AppCompatActivity() {
    //PRECARGA DE LA APLICACIÓN
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //SE UTILIZA LA INTERFAZ XML PARA MOSTRAR LA VENTANA CORRESPONDIENTE
        setContentView(R.layout.activity_preguntasfrecuentes_apgmotor)

        //FUNCIONALIDAD DEL BOTÓN
        //Indicar con la funcionalidad que realiza el botón OK
        val btnOK: Button = findViewById(R.id.btn_ok)
        btnOK.setOnClickListener{
            //Generamos la aparición de un mensaje informativo por la interfaz
            Toast.makeText(this, "Redirigido a la página principal.", Toast.LENGTH_SHORT).show()
//CAMBIO DE VENTANAS TRAS EL USO DEL BOTÓN
            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}