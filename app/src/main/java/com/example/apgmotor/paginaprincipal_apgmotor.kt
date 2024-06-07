package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

/**
 * Esta clase permite ingresar gastos por vehículo, acceder al apartado ver gastos, ver testigos,
 * configuración y añadir nuevo vehículo.
 * Los gastos diferencian el ingreso por vehículo según desde la imagen en la que accedan
 */
class paginaprincipal_apgmotor : AppCompatActivity() {
    //PRECARGA DE LA VENTANA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno

        //INSTANCIA DE LA INTERFAZ XML QUE SE NECESITA PARA INTERACTUAR
        setContentView(R.layout.activity_paginaprincipal_apgmotor)

        /**
         * TODOS LOS BOTONES TIENEN EL MISMO TIPO DE DECLARACIÓN, PARA OPTIMIZAR LOS COMENTARIOS
         * SE VA HA COMENTAR SOLAMENTE EL PRIMER MÉTODO DE LOS BOTONES
         */

        //FUNCIONALIDAD DEL BOTÓN
        //Se declara la imagen como botón y se añade la imagen deseada
        val imagenGolf: ImageButton = findViewById(R.id.golfito)
        //Se añade el funcionammiento para las acciones de cambio de ventana e inicio de nueva ventana
        imagenGolf.setOnClickListener{
            //cambio de ventana
            val intent: Intent = Intent(this, ingresargastos_apgmotor:: class.java)
            //Iniciación de la ventana que se abre
            startActivity(intent)
        }

        //Añadir funcionalidad al botón de Iniciar Sesión
        val btnNuevoVehiculo: Button = findViewById(R.id.btn_av)
        btnNuevoVehiculo.setOnClickListener{
            val intent: Intent = Intent(this, nuevovehiculo_apgmotor:: class.java)
            startActivity(intent)
        }

        /**
         * LOS SIGUIENTES BOTONES, SIGUEN EL MISMO FORMATO QUE LOS BOTONES DECLARADOS
         * ANTERIORMENTE. SERÁ RECORDADO EL FORMATO EN EL BOTÓN INICIO
         */
        //INICIO O CASITA
        val btncasita: ImageButton = findViewById(R.id.btn_inicio)
        //SE EFECTÚAN LOS CAMBIOS TRAS EL USO DEL BOTÓN CON EL USO DEL MÉTODO
        btncasita.setOnClickListener{
            //SE REALIZA EL CAMBIO ENTRE LAS VENTANAS TRAS CLICAR EL BOTÓN
            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }

        //CONFIGURACIÓN O ENGRANAJE
        val btnconfig: ImageButton = findViewById(R.id.btn_config)
        btnconfig.setOnClickListener{
            val intent: Intent = Intent(this, Configuracion_apgmotor:: class.java)
            startActivity(intent)
        }

        //VER GASTOS O TICKET CON DOLAR
        val btnvergastos: ImageButton = findViewById(R.id.btn_vgastos)
        btnvergastos.setOnClickListener{
            val intent: Intent = Intent(this, vergastos_apgmotor:: class.java)
            startActivity(intent)
        }

        //VER TESTIGOS O ENGRANAJE CON EXCLAMACIÓN
        val btnvertestigos: ImageButton = findViewById(R.id.btn_vtestigos)
        btnvertestigos.setOnClickListener{
            val intent: Intent = Intent(this, Vertestigos_apgmotor:: class.java)
            startActivity(intent)
        }

    }
}