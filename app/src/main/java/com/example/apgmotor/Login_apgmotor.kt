package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.jakewharton.threetenabp.AndroidThreeTen
class Login_apgmotor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Instanciar la conexión
        var conectate_apg = BaseDatos_apgmotor()
        val conexion = conectate_apg.ConexionDB_apgmotor()

        if (conexion != null) {
            Log.i("Info", "Conexión establecida")
            // Aquí puedes realizar operaciones con la base de datos
        } else {
            Log.e("Error", "No se pudo establecer la conexión")
        }

        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

        //Preparación de la aplicación
        super.onCreate(savedInstanceState)
        //Actualizar permisos para la conexión de Base de Datos con plugins Java 8 (Android Oreo)
        AndroidThreeTen.init(this)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno
        setContentView(R.layout.login_apgmotor)

        //Añadir acceso a la aplicación con credenciales estáticas
        val accesoUsuario_apg = findViewById<EditText>(R.id.introducecorreo)
        val contrasennaUsuario_apg = findViewById<EditText>(R.id.introducecontrasenna)
        // Busca el botón de iniciar sesión por su id
        val btniniciar: Button = findViewById(R.id.bt_login)

        // Se crean las acciones para el acceso
        btniniciar.setOnClickListener {
            val usuario_apg = accesoUsuario_apg.text.toString()
            val contrasenna_apg = contrasennaUsuario_apg.text.toString()
            //Credenciales para la apk y uso de administrador
            if (usuario_apg == "padilla.guale22@cordoba.salesianos.edu" && contrasenna_apg == "padilla24") {
                // Accedemos con los datos y te dirige a la app
                val intent = Intent(this, paginaprincipal_apgmotor::class.java)
                // Inicia la actividad especificada por el Intent
                startActivity(intent)
                finish()
            } else {
                //Generamos la aparición de un mensaje por la interfaz que indique el error
                Toast.makeText(this, "El correo o la contraseña son incorrectos, inténtelo de nuevo", Toast.LENGTH_SHORT).show()
            }
        }

        //Añadir funcionalidad al botón de Regístrate
        val btnRegistrarse: Button = findViewById(R.id.bt_registrate)
        btnRegistrarse.setOnClickListener{
            val intent: Intent = Intent(this, Registro_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}