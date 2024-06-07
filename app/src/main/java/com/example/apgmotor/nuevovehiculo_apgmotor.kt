package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * En esta clase se realiza una insercción para un nuevo vehículo.
 * Se ha utilizado la API y para mejorar el entendimiento el codigo se ha modulado junto
 * a los comentarios añadidos.
 */
class nuevovehiculo_apgmotor : AppCompatActivity() {
    //PRECARGA DE LA VENTANA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno
        //IMPLEMENTACIÓN DE LA INTERFAZ XML PARA ESTA VENTANA
        setContentView(R.layout.activity_nuevovehiculo_apgmotor)

//SE AÑADE FUNCIONALIDAD AL BOTON PARA AÑADIR VEHÍCULO
        //SE AÑADE EL BOTÓN QUE NECESITRAMOS POR SU NOMBRE DEL XML
        val btnannadir: Button = findViewById(R.id.btn_add)
        btnannadir.setOnClickListener {
            //ASIGNACIÓN DE CAMPOS XML A VARIABLES PARA COMPROBAR LA INFORMACIÓN
            val marca_apg = R.id.marcas
            val modelo_apg = R.id.modelos
            val kilometraje_apg = R.id.kilometraje
            val matricula_apg = R.id.matricula

            //Asignamos los valores para comprobar que los campos no sean nulos
            val campos = marca_apg + modelo_apg + kilometraje_apg + matricula_apg

            //Si los campos no son nulos se envían los datos a la BASE DE DATOS (API)
            /*Como la API es llamada en la primera clase que efectúa el programa,
            no es necesario realizarlo en las demás clases de kotlin.
            Para lograr esta especificación se han utilizado las herramientas internas que importa
            de forma automática android studio. El IDE utilizado para el desarrollo.
             */
            if (campos != null) {
                //PREPARACIÓN PARA EL PASADO DE DATOS A NUESTRA API
                val consulta_apg = "INSERT INTO vehiculo_usuario (matricula, id_usuario) \n" +
                        "SELECT 'matricula_a_insertar', id_usuario FROM usuarios WHERE id_usuario = 'id_del_usuario'"
//PREPARACIÓN DE LA URL
                val apiPersonal_url =
                    "https://api.alejandroapp.duckdns.org/query?user=alejandro&passwd=545G8apeLOhm5Ddskq6Cd0irTzdyaO&query="

                //Remplazamos espacios por el valor que pide la api
                consulta_apg.replace(" ", "%20", false)
//EJECUTAMOS LA CONSULTA PARA EL INSERTADO DE DATOS
                var lanzaConsulta_apg = (apiPersonal_url + consulta_apg)
                lanzaConsulta_apg

                //Generamos la aparición de un mensaje informativo por la interfaz
                Toast.makeText(
                    this,
                    "El vehículo ha sido registrado, puede introducir ya sus gastos.",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                //Generamos la aparición de un mensaje informativo por la interfaz
                Toast.makeText(
                    this,
                    "El vehículo no ha sido registrado, espere unos minutos y vuelve a probar.",
                    Toast.LENGTH_SHORT
                ).show()

            }
//SE REALIZA EL CAMBIO DE VENTANAS A LA VENTANA DESEADA
            val intent: Intent = Intent(this, paginaprincipal_apgmotor::class.java)
            startActivity(intent)
        }

        /**
         * LOS BOTONES DE PIE DE PÁGINA REALIZAN LA MISMA FUNCIÓN DIRIGIDA A DISTINTOS
         * CAMBIOS DE VENTANA. PARA PODER OPTIMIZAR LOS COMENTARIOS SE COMENTARÁ SOLAMENTE EL
         * PRIMER BOTÓN.
         */
        //INICIO O CASITA
        val btncasita: ImageButton = findViewById(R.id.btn_inicio)
        //SE EFECTÚAN LOS CAMBIOS TRAS EL USO DEL BOTÓN CON EL USO DEL MÉTODO
        btncasita.setOnClickListener {
            //SE REALIZA EL CAMBIO ENTRE LAS VENTANAS TRAS CLICAR EL BOTÓN
            val intent: Intent = Intent(this, paginaprincipal_apgmotor::class.java)
            startActivity(intent)
        }

        //CONFIGURACIÓN O ENGRANAJE
        val btnconfig: ImageButton = findViewById(R.id.btn_config)
        btnconfig.setOnClickListener {
            val intent: Intent = Intent(this, Configuracion_apgmotor::class.java)
            startActivity(intent)
        }

        //VER GASTOS O TICKET CON DOLAR
        val btnvergastos: ImageButton = findViewById(R.id.btn_vgastos)
        btnvergastos.setOnClickListener {
            val intent: Intent = Intent(this, vergastos_apgmotor::class.java)
            startActivity(intent)
        }

        //VER TESTIGOS O ENGRANAJE CON EXCLAMACIÓN
        val btnvertestigos: ImageButton = findViewById(R.id.btn_vtestigos)
        btnvertestigos.setOnClickListener {
            val intent: Intent = Intent(this, Vertestigos_apgmotor::class.java)
            startActivity(intent)
        }
    }
}