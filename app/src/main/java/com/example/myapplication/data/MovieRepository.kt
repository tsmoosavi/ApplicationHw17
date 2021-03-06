package com.example.myapplication.data

import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult
import com.example.myapplication.model.VideoResult

class MovieRepository (val movieRemoteDataSource:MovieRemoteDataSource, val movieLocalDataSource: MovieLocalDataSource){
    
    suspend fun getMovie():List<Movie>{
        return movieRemoteDataSource.getMovie()
    }
    suspend fun searchMovie(query:String):List<Movie>{
        return movieRemoteDataSource.searchMovie(query)
    }
    suspend fun upComingMovieList():List<UpComingResult>{
        return movieRemoteDataSource.upComingMovies()
    }
    suspend fun getMovieDetail(id:Int):MovieDetail{
        return movieRemoteDataSource.MovieDetail(id)
    }
    suspend fun getVideoOfMovie(id:Int):List<VideoResult>{
        return movieRemoteDataSource.getVideoOfMovie(id)
    }



}