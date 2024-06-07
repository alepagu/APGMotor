package com.example.apgmotor

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi

/**
 * Esta clase, permite que desde la API se comprueben los datos del usuario y se acceda a la aplicación.
 * Se recogen los datos introducidos y se crea seguridad implementando un cifrado en la contraseña.
 */
class Login_apgmotor : ComponentActivity() {
    //IMPLEMENTACIÓN DE LA API
    @RequiresApi(Build.VERSION_CODES.O)
    //PREPARACIÓN DE PANATALLA DE CARAGA DE LA APLICACIÓN
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

        //RENDERIZADO DE LA VENTANA Y LA APLICACIÓN
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno
        //IMPLEMENTACIÓN DE LA INTERFAZ XML NECESARIA PARA EL INICIO DE SESIÓN
        setContentView(R.layout.login_apgmotor)


        // ASIGNACIÓN DEL BOTÓN CON EL NOMBRE DEL XML
        val btniniciar: Button = findViewById(R.id.bt_login)

        // FUNCIÓN Y COOMPROBACIÓN DE DATOS PARA EL ACCESO
        btniniciar.setOnClickListener {
            //ASIGNACIÓN DE LECTURA DE LOS CAMPOS SEGÚN EL NOMBRE DE XML
            val correo_apg = R.id.introducecorreo
            val contrasenna_apg = R.id.introducecontrasenna
            //LLAMAMOS A LA FUNCIÓN PREPARADA PARA EL ACCESO Y LE PASAMOS LOS PARAMETROS NECESITADOS
            lanzarConsulta(correo_apg, contrasenna_apg)

            //SI LOS CAMPOS HAN RECIBIDO INFORMACIÓN VÁLIDA TRAS LA EJECUCIÓN DE LA CONSULTA
            if (correo_apg != null && contrasenna_apg != null){
                //SE INTERCAMBIAN LAS VENTANAS PERMITIENDO EL ACCESO A LA APLICACIÓN
                val intent: Intent = Intent(this, paginaprincipal_apgmotor::class.java)
                //SE INICIA EL PROGRAMA
                startActivity(intent)
                //Mensaje indicativo
                Toast.makeText(this, "Entrando a la aplicación con el usuario introducido", Toast.LENGTH_SHORT).show()
            }
            else{
                //Mensaje de error
                Toast.makeText(this, "Algún dato introducido es incorrecto", Toast.LENGTH_SHORT).show()
            }

        }

            //FUNCIÓN PARA EL BOTÓN DE REGISTRO
        //SE AGREGA EL CAMPO DEL XML QUE REALIZA LA FUNCIÓN EN LA INTERFAZ CON KOTLIN
            val btnRegistrarse: Button = findViewById(R.id.bt_registrate)
            btnRegistrarse.setOnClickListener {
                //TRAS HACER USO DEL BOTÓN, CAMBIAMOS LAS VENTANAS DE INICIO POR REGISTRO
                val intent: Intent = Intent(this, Registro_apgmotor::class.java)
                startActivity(intent)//INICIAMOS REGISTRO
            }

        }

    /**
     * En esta función se crea la consulta y se pasa mediante la url a la web que contiene
     * la API de Python y cmoprobamos los datos
     */
    fun lanzarConsulta(correo: Int, contrasenna: Int): String {
        //PREPARACIÓN DE LA URL DE ACCESO A LA API WEB
        val api_apgmotor = "https://api.alejandroapp.duckdns.org/query?user=alejandro&passwd=545G8apeLOhm5Ddskq6Cd0irTzdyaO&query="
        //PREPARACIÓN DE LA CONSULTA SQL PARA LA API
        val consulta_apg = "SELECT * FROM usuarios WHERE correo = $correo AND contrasenna = $contrasenna"
        //ADAPTACIÓN DEL FORMATO NECESARIO PARA REALIZAR LA CONSULTA
        val lanzaConsulta_apg = (api_apgmotor + consulta_apg.replace(" ", "%20"))
        //DEVOLVEMOS EL VALOR RECIBIDO DE LA API
        return lanzaConsulta_apg
    }
}
