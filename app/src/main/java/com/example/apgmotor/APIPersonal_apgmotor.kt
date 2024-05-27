package com.example.apgmotor

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

/**
 * En esta clase se preparan los métodos para lanzar las consultas definidas
 */
class APIPersonal_apgmotor {
    //Variables privadas para establecer el JSON para las consultas
    private val client = OkHttpClient()
    private val baseUrl = "https://api.alejandroapp.duckdns.org/query"

    /**
     * Método para lanzar las consultas, se recogen en el formato deseado el usuario,
     * y la contraseña para conectar con la web de la API y se le pasa la consulta para
     * obtener una respuesta.
     */
    @Throws(IOException::class)
    fun ejecutarConsulta(user: String, passwd: String, query: String): JSONObject? {
        val url_apg = "$baseUrl?user=$user&passwd=$passwd&query=$query"
        val respuesta_apg = Request.Builder()
            .url(url_apg)
            .build()

        client.newCall(respuesta_apg).execute().use { respuesta ->
            if (!respuesta.isSuccessful) throw IOException("Fallo en los manejos de los datos $respuesta")

            val responseBody_apg = respuesta.body?.string()
            return JSONObject(responseBody_apg)
        }
    }
}