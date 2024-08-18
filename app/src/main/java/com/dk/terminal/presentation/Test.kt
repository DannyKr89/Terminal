package com.dk.terminal.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Test(modifier: Modifier = Modifier) {

    var testData by rememberSaveable(
        saver = TestData.saver
    ) {
        mutableStateOf(TestData(0, "Test"))

    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable { testData = testData.copy(number = testData.number + 1) },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Text: $testData")
    }
}

data class TestData(val number: Int, val text: String) {
    companion object {
        val saver = listSaver<MutableState<TestData>, Any>(
            save = {
                val number = it.value.number
                val text = it.value.text
                listOf(number, text)
            },
            restore = {
                mutableStateOf(
                    TestData(
                        number = it[0] as Int,
                        text = it[1] as String
                    )
                )
            }
        )
    }
}