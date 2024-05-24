package com.example.apgmotor

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.Objects

class AdaptadorTestigosApgmotor(private val actividadApg: Context, private val pantalla_apg: LayoutInflater ,private val testigoApg: List<String>, private val imagenesApg: Array<Int>) : BaseAdapter() {
    /**
     * El metodo obtiene la cuenta de los elementos que se van a necesitar
     */
    override fun getCount(): Int {
        return testigoApg.size
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
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //Creamos la vista si no tenemos ninguna creada
        val vistaApg: View
        if (convertView == null) {
            //Asigno la pantalla a la que quiero darle los valores
            val layoutInflater = LayoutInflater.from(actividadApg)
            vistaApg = layoutInflater.inflate(R.layout.elementotestigos_apgmotor, parent, false)
        } else {
            //Si tengo una vista creada, no se efectúan cambios
            vistaApg = convertView
        }
        //Añadimos la lista que deseamos en el orden que van a aparecer
        val nombreTxtApg: TextView = vistaApg.findViewById(R.id.nombreTestigo)
        nombreTxtApg.text = testigoApg[position]
        //Realizamos lo mismo pero para que se detecten las imagenes
        val imagenApg: ImageView = vistaApg.findViewById(R.id.ftTestigo)
        imagenApg.setImageResource(imagenesApg[position])
        //Devolvemos la pantalla que se crea
        return vistaApg
    }
}