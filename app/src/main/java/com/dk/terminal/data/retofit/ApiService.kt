package com.dk.terminal.data.retofit

import com.dk.terminal.data.model.ResultDto
import retrofit2.http.GET

interface ApiService {
    @GET("aggs/ticker/X:BTCUSD/range/1/day/2023-01-09/2023-02-10?adjusted=true&sort=asc&apiKey=zkmRNsxNlA99WQBKF2k6ICtGFri2oJ6J")
    suspend fun loadBars(): ResultDto
}