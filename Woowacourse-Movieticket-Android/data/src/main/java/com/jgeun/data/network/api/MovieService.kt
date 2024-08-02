package com.jgeun.data.network.api

import com.jgeun.data.network.constants.NetworkConstants
import com.jgeun.data.network.model.response.MovieInfoResultResponse
import com.jgeun.data.network.model.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/searchMovieList.json")
    suspend fun fetchMovieList(
        @Query("curPage") page: String,
        @Query("itemPerPage") size: String,
        @Query("key") key: String = NetworkConstants.KEY
    ): MovieListResponse

    @GET("movie/searchMovieInfo.json")
    suspend fun fetchMovieInfo(
        @Query("movieCd") movieCode: String,
        @Query("key") key: String = NetworkConstants.KEY
    ): MovieInfoResultResponse
}