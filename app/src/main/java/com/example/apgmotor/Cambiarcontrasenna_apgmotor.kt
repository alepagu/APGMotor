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
            val contrasenna = R.id.contraActual
            val cambioContrasenna = R.id.newContra
            val cambioContrasenna1 = R.id.newContra1

            if (contrasenna != null && (cambioContrasenna == cambioContrasenna1)!= null){
                //Realizamos el update de la tabla
                val consulta_apg = "UPDATE usuarios SET contrasenna = $cambioContrasenna"
                val apiPersonal_url = "https://api.alejandroapp.duckdns.org/query?user=alejandro&passwd=545G8apeLOhm5Ddskq6Cd0irTzdyaO&query="
                //Converisón de valores para ser adaptados a la api
                var cambio = consulta_apg.replace(" ", "%20", false)

                //lanzamos la consulta con la api
                val lanzaConsulta_apg = (apiPersonal_url + cambio)
                lanzaConsulta_apg

                //Generamos la aparición de un mensaje informativo por la interfaz
                Toast.makeText(this, "La contraseña ha sido cambiada con éxito. Has sido redirigido a página principal.", Toast.LENGTH_SHORT).show()
                //Nos dirigimos a la pantalla principal
                val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
                startActivity(intent)
            }
        }
    }
}