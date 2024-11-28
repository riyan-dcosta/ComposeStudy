package com.kodeman.composestudy.utils.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

class CustomInputField {

    @Composable
    fun BasicInputField(
        modifier: Modifier = Modifier,
        gapModifier: Modifier = Modifier,
        title: String = "",
        value: String,
        onChanged: (newValue: String) -> Unit,
        readOnly: Boolean = false,
        keyboardActions: KeyboardActions = KeyboardActions.Default
    ) {
        Column(modifier) {
            Text(title)
            Box(gapModifier)
            TextField(
                value,
                onValueChange = onChanged,
                readOnly = readOnly,
                keyboardActions = keyboardActions
            )
        }
    }
}