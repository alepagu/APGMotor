package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Vertestigos_apgmotor : AppCompatActivity() {
//Constantes para el intercambio de ventanas
    companion object {
        const val EXTRA_IMAGEN = "extra_imagen"
        const val EXTRA_DESCRIPCION = "extra_descripcion"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        //Añadimos las imagenes en el orden que aparece la información
        val imagenes_apg: Array<Int>
        imagenes_apg = (
                arrayOf(R.drawable.aceiterojo_apgmotor,
                    R.drawable.aceiteamarillo_apgmotor,
                    R.drawable.refrigerante_apgmotor,
                    R.drawable.bateria_apgmotor,
                    R.drawable.frenomano_apgmotor,
                    R.drawable.puerta_apgmotor,
                    R.drawable.airbag_apgmotor,
                    R.drawable.cinturon_apgmotor,
                    R.drawable.abs_apgmotor,
                    R.drawable.gases_apgmotor,
                    R.drawable.pinchazo_apgmotor,
                    R.drawable.bombilla_apgmotor,
                    R.drawable.velcrucero_apgmotor))

        //Creo la lista con las descripciones que incorporan los testigos
        val descripcionesTestigos_apg = mutableListOf(
            "No hay el suficiente nivel de aceite para ser lubricado y no dañar componentes, esta avería impide el movimiento del vehículo. Su solución es añadir aceite y ver si se apaga el testigo y de lo contrario es una avería interna que depende de una reparación mecánica.",
            "Si este testigo se le ha encendido, puede estar tranquilo solamente debe comprobar si el aceite se comprende entre los niveles de la varilla de aceite y llenarlo hasta el nivel correcto. Lo recomendable es estar en el nivel máximo pero no pasarse de ese nivel para evitar fallos internos.",
            "Para este testigo, debe parar el motor y dejarlo en reposo para mirar el nivel del anticongelante. Si este esta por debajo del mínimo debe repostar hasta el nivel correcto, de lo contrario si el nivel esta bien debe llamar a grúa o dejar el coche mucho rato en reposo para ver si baja la temperatura del motor y continuar la marcha si es así.",
            "Este fallo no puede ser reparado sin ir al taller. Pero si es la batería, puede comprobarlo con un polímetro y ver si su voltaje está por encima de los 13.5 voltios se encuentra bien y es fallo mecánico. De lo contrario puede sustituir la batería y comprobar si el testigo desaparece.",
            "La aparición de este testigo con el vehículo en marcha, significa que no esta suelto del todo. Para que desaparezca deberá de anular correctamente el freno de mano.",
            "Si aparece este testigo debe comprobar tener bien cerradas todas las puertas del vehículo, si sigue apareciendo compruebe el capó y el maletero.",
            "Este testigo solo aparece cuando no se encuentra toda la corriente en alguno de los sensores de los dispositivos airbag. En caso de tener alguno desactivado por llevar a bebés en el vehículo, este desaparecerá cuando sea activado de nuevo.",
            "Aparece cuando algún pasajero del vehículo no tiene el cinturón puesto, al ser abrochado desaparecerá.",
            "Su encendido suele ir acompañado del sistema de estabilidad, y se debe a que el sistema que impide que los frenos se puedan bloquear no funciona.",
            "La causa de encendido es una anomalía en el sensor del motor o de los gases de escape. Lo primordial es acudir a un taller y que ellos te reparen o aconsejen sobre su fallo, ya que puede deberse a cosas que se reparan en circustancias normales conduciendo por trayectos del día a día.",
            "Su causa puede deberse a una presión baja en los neumáticos o a un pinchazo por el cuál se pierde presión. Cuando aparezca este testigo en el cuadro revisa las presiones lo antes posible y con el vehículo lo más frío posible.",
            "Si se le ha encendido este testigo ve revisando todas las luces de su vehículo y sustituye la que se encuntre fundida, en el caso de tener más de una ir a revisarlo por un experto ya que puede haber caídas de tensión que pueden empeorar.",
            "Si se está preocupando por este testigo, puede estar tranquilo. Su encendido se debe a que se ha activado una velocidad fija para ir sin necesidad de pisar el acelerador de su vehículo. Para apagarlo, debe de desactivar esa opción o pissar el freno levemente.")


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vertestigos_apgmotor)

        //Creamos la lista con un estado mutable para poder ser modificado en futuras versiones
        val testigos_apg = mutableListOf("Sin presión de aceite", "Fallo en el Circuito de Refrigeración",
            "Fallo de alternador o batería", "Freno de mano puesto", "Puerta abierta", "Airbag desactivado",
            "Cinturón desabrochado", "Fallo en el ABS", "Anomalía en el circuito de gases de escape",
            "Presión de neumaticos baja o rueda pinchada", "Bombilla Fundida", "Velocidad crucero activada")
        //asignar la pantalla que necesitamos ver
        val listaTestigos_apg = findViewById<ListView>(R.id.listaTestigos)
        //Asignarle los valores correctos a la pantalla
        //adaptador_apg = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, testigos_apg)

        //asignamos el adaptador personalizado en la clase AdaptadorRestigos_apgmotor
        val adaptador_apg = AdaptadorTestigosApgmotor(this, R.layout.elementotestigos_apgmotor, testigos_apg, imagenes_apg)
        listaTestigos_apg.adapter = adaptador_apg

        listaTestigos_apg.setOnItemClickListener { parent_apg, view_apg, posicion_apg, id ->
            //Creo la asignación de valores del elemento seleccionado

        }
    }
}