package com.dk.terminal.presentation

import com.dk.terminal.domain.model.Bar

sealed class TerminalScreenState {

    data object Initial : TerminalScreenState()
    data class Content(val barList: List<Bar>) : TerminalScreenState()
}