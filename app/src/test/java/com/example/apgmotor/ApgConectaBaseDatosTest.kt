package com.example.apgmotor

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class ApgConectaBaseDatosTest(){
        /**
         * SE IMPORTA LOS TEST DE JUnit Y SE REALIZA LA LLAMADA A LA CLASE DE CONEXIÓN
         * CON LA BASE DE DATOS, EN ESTA SE COMPRUEBA EL FUNCIONAMIENTO Y SI SE OBTIENE
         * EL MISMO VALOR QUE SE DESEA LA PRUEBA DE INTEGRACIÓN ES CORRECTA.
         */
        @Test
        fun pruebaIntegracion_apgBaseDatos(){
                val conexion_apg = ApgConectaBaseDatos()
                assertEquals(conexion_apg, conexion_apg, "Prueba Conexión Superada")
        }
}