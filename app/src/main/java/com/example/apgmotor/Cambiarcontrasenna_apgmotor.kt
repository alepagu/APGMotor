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

        //FUNCINAMIENTO DEL BOTÓN CONFIRMAR CONTRASEÑA
        //SE ASIGNA EL BOTÓN A SU IDENTIFICADOR DEL XML
        val btncambiarcontradenna: Button = findViewById(R.id.btn_cambiacontra)
        btncambiarcontradenna.setOnClickListener{
            //TRAS SER ACCIONADO SE IGUALAN LAS VARIABLES CREADAS A LOS CAMPOS RECIBIDOS DEL XML
            val contrasenna = R.id.contraActual
            val cambioContrasenna = R.id.newContra
            val cambioContrasenna1 = R.id.newContra1

            //SI LOS DATOS CUMPLEN LOS REQUISITOS DE SER DISTINTOS SE REALIZA EL CAMBIO
            if (contrasenna != null && (cambioContrasenna == cambioContrasenna1)!= null){
                //ACTUALIZAMOS MEDIANTE LA API LA CONTRASEÑA DEL USUARIO QUE EFECTÚA EL CAMBIO
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