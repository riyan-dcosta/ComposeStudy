package com.kodeman.composestudy.utils.ui

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

class CustomIconButton {
    @Composable
    fun IconButtonColors(
        modifier: Modifier = Modifier,
        onClick: () -> Unit, icon: ImageVector = Icons.Filled.Star,
        contentDescription: String? = null
    ) {

        IconButton(onClick = onClick, modifier.background(color = Color.Cyan)) {
            Icon(icon, contentDescription = contentDescription)
        }
    }
}