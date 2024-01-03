package com.example.aymarswi.ApiRest

import retrofit2.Response
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

object AppConstantes {
    //Revisar si se actualizó el numero de la ip
    const val BASE_URL = "http://192.168.42.152:3000"
}

interface ServiciosWeb {
    @GET("/usuarios")
    suspend fun obtenerUsuarios(): Response<UsuariosResponse>

    @GET("/usuario/{id}")
    suspend fun obtenerUsuario(
        @Path("id") idUsuario: Int
    ): Response<Usuario>

    @GET("/usuario/existe/{correo}")
    suspend fun verificarCorreoExistente(
        @Path("correo") correo: String
    ) :Response<Boolean>

    @POST("/usuario/add")
    suspend fun agregarUsuario(
        @Body usuario: Usuario
    ): Response<String>

    @PUT("/usuario/update/{id}")
    suspend fun actualizarUsuario(
        @Path("id") idUsuario: Int,
        @Body usuario: Usuario
    ): Response<String>

    @DELETE("/usuario/delete/{id}")
    suspend fun borrarUsuario(
        @Path("id") idUsuario: Int
    ): Response<String>
}

object RetrofitCliente{
    val servicioWeb: ServiciosWeb by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(ServiciosWeb::class.java)
    }
}