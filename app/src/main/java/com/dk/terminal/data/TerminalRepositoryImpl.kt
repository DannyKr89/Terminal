package com.dk.terminal.data

import com.dk.terminal.data.retofit.ApiService
import com.dk.terminal.domain.TerminalRepository
import com.dk.terminal.domain.model.Bar
import javax.inject.Inject

class TerminalRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    TerminalRepository {
    override suspend fun loadBars(): List<Bar> {
        return apiService.loadBars().barList.map {
            it.toBar()
        }
    }
}