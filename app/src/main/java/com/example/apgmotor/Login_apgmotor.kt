package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import java.sql.Connection
import java.sql.Statement

class Login_apgmotor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

        //Preparación de la aplicación
        super.onCreate(savedInstanceState)
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

//        //Crea conexión
//        val conexion: Connection? = BaseDatos_apgmotor().ConexionDB_apgmotor()
//
//        val consulta: Statement? = conexion?.createStatement()
//        val resultSet = consulta?.executeQuery("SELECT * FROM marcas")
//
//        if (resultSet != null) {
//            while (resultSet.next()){
//                println(resultSet.getString("marca"))
//            }
//        }
//
//        resultSet?.close()
//        consulta?.close()
//        conexion?.close()

    }
}
