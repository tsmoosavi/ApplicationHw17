package com.example.myapplication.data.network

import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.MovieListApiResult
import com.example.myapplication.model.SearchMovie
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"
const val api_key = "8615e332ad100989dfaaba4d95fa88c7"
const val poster_path ="https://image.tmdb.org/t/p/w500"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("movie/popular")
    suspend fun getMovies(
//        @Query("page")page :Int = 1,
        @Query("api_key") apiKey :String = api_key
    ): MovieListApiResult

    @GET("search/movie")
    suspend fun searchMovie(
//        @Query("page")page :Int,
        @Query("api_key") apiKey :String = api_key,
        @Query("query") query: String
    ):SearchMovie

    @GET("movie/{movie_id}")
    suspend fun MovieDetail(
        @Query("api_key") apiKey :String = api_key,
        @Path(value = "movie_id") movieId: Int
    ): MovieDetail


}

object MovieApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}


