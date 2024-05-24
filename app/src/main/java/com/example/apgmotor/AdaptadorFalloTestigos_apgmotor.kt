package com.example.apgmotor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorFalloTestigos_apgmotor(private val actividad_apg: Context, private val pantalla_apg: Int, private val descripcion_apg: List<String>, private val imagenes_apg: Array<Int>) : BaseAdapter() {
    /**
     * El metodo obtiene la cuenta de los elementos que se van a necesitar
     */
    override fun getCount(): Int {
        return descripcion_apg.size
    }

    /**
     * Este metodo no se utiliza, pero tiene que estar declarado pues deriva de la interfaz
     */
    override fun getItem(position: Int): Any? {
        return null
    }
    /**
     * Este metodo no se utiliza, pero tiene que estar declarado pues deriva de la interfaz
     */
    override fun getItemId(position: Int): Long {
        return 0
    }

    /**
     * Ajustamos todos los valores para obtener la pantalla que se desea
     */
    override fun getView(position_apg: Int, convertView_apg: View?, parent_apg: ViewGroup?): View {
        //Creamos la vista si no tenemos ninguna creada
        val vistaApg: View
        if (convertView_apg == null) {
            //Asigno la pantalla a la que quiero darle los valores
            val layoutInflater = LayoutInflater.from(actividad_apg)
            vistaApg = layoutInflater.inflate(R.layout.activity_fallostestigos_apgmotor, parent_apg, false)
        } else {
            //Si tengo una vista creada, no se efectúan cambios
            vistaApg = convertView_apg
        }
        //Añadimos la lista que deseamos en el orden que van a aparecer
        val nombreTxtApg: TextView = vistaApg.findViewById(R.id.descripcionTestigo)
        nombreTxtApg.text = descripcion_apg[position_apg]
        //Realizamos lo mismo pero para que se detecten las imagenes
        val imagenApg: ImageView = vistaApg.findViewById(R.id.imagenTestigo1)
        imagenApg.setImageResource(imagenes_apg[position_apg])
        //Devolvemos la pantalla que se crea
        return vistaApg
    }
}