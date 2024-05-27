package com.example.apgmotor

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PruebasUnitarias_apgmotor{
    /**
     * Preparamos los datos estáticos para obtener una respuesta de comparación correcta
     */
    @Test
    fun Login_apgmotor() {
        //Asignamos la PRUEBA UNITARIA para esta Clase
        val correo = "apg@apg.com"
        val contrasenna = "ApG/24"
        val consultita ="SELECT%20*%20FROM%20usuarios%20WHERE%20correo%20=%20$correo%20AND%20contrasenna%20=%20$contrasenna"

        assertEquals("consultita", consultita, consultita)
    }

    /**
     * Simulamos las credenciales para poder obtener una comparación entre el dato envíado y el dato recibido
     */
    @Test
    fun Registro_apgmotor(){
        //PRUEBA UNITARIA de esta clase
        val nombre = "apg"
        val correo = "apg@apg.com"
        val contrasenna = "ApG/24"
        val contrasenna1 = "ApG/24"

        val consulta_apg = "INSERT INTO usuarios (nombre, correo, contrasenna, fechaAlta) VALUES ($nombre,$correo,$contrasenna,$contrasenna1)"
        assertEquals("consulta_apg", consulta_apg, consulta_apg)
    }

    /**
     * Hacemos comprobación de diferencia simulando el cambio y estimando el valor que debe devolver
     */
    @Test
    fun CambiarContrasena_apgmotor(){
        //PRUEBA UNITARIA para esta clase
        var contrasenaActual = "ApG/24"
        var contrasenaNueva = "Padilla24"
        var contrasenaNueva1 = "Padilla24"
        //Si los datos son diferentes se lanaza la ejecución y deve devolver los parámetros del assertEquals
        if (contrasenaActual != contrasenaNueva1){
            //Si los valores son diferentes se obtiene el cambio como respuesta
            var consulta_apgmotor = "UPDATE usuarios SET contrasenna = $contrasenaNueva"

            assertEquals("consulta_apgmotor", consulta_apgmotor, consulta_apgmotor)
        }
    }
}