package com.dk.terminal.data

import com.dk.terminal.data.model.BarDto
import com.dk.terminal.domain.model.Bar

fun BarDto.toBar(): Bar {
    return Bar(
        open = open,
        close = close,
        low = low,
        high = high,
        time = calendar
    )
}