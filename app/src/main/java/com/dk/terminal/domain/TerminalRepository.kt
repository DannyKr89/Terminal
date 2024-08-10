package com.dk.terminal.domain

import com.dk.terminal.domain.model.Bar

interface TerminalRepository {

    suspend fun loadBars(): List<Bar>
}