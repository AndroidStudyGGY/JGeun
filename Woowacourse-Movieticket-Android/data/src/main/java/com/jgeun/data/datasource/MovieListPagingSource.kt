package com.jgeun.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jgeun.data.datasource.remote.MovieDataSource
import com.jgeun.data.network.model.response.MovieListResponse
import javax.inject.Inject

class MovieListPagingSource @Inject constructor(
    private val dataSource: MovieDataSource
) : PagingSource<String, MovieListResponse.MovieListResultResponse.MovieDto>() {

    override suspend fun load(
        params: LoadParams<String>
    ): LoadResult<String, MovieListResponse.MovieListResultResponse.MovieDto> {
        val page = params.key ?: "1"

        try {
            val response = dataSource.fetchMovieList(
                page = page,
                size = params.loadSize.toString()
            ).movieListResult

            val nextKey = if (response.totalCnt == 0 || response.movieList.isEmpty()) {
                null
            } else {
                page.toInt().plus(1).toString()
            }

            return LoadResult.Page(
                data = response.movieList,
                prevKey = if (page == "1") null else page.toInt().minus(1).toString(),
                nextKey = nextKey
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, MovieListResponse.MovieListResultResponse.MovieDto>): String? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)

            anchorPage?.prevKey?.toInt()?.plus(1)?.toString()
                ?: anchorPage?.nextKey?.toInt()?.minus(1)?.toString()
        }
    }

}