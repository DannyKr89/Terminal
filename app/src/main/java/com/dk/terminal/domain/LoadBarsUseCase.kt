package com.dk.terminal.domain

import com.dk.terminal.domain.model.Bar

class LoadBarsUseCase(private val repository: TerminalRepository) {

    suspend operator fun invoke(): List<Bar> {
        return repository.loadBars()
    }
}