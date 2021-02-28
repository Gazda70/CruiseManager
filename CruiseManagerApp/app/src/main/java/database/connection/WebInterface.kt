package database.connection

import database.entities.CourseInfo
import database.entities.UsernameInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebInterface {
    @GET("username")
    fun getCurrentUsername(@Query("username") username:String): Call<UsernameInfo>
}