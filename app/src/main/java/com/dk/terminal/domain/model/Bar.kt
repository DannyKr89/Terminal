package com.dk.terminal.domain.model

import android.icu.util.Calendar
import androidx.compose.runtime.Immutable

@Immutable
data class Bar(
    val open: Float,
    val close: Float,
    val low: Float,
    val high: Float,
    val time: Calendar
)
