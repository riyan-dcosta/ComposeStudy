package com.kodeman.composestudy

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeman.composestudy.qr.QrScannerKit
import com.kodeman.composestudy.tips.view.TipView
import com.kodeman.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TipView(Modifier.padding(innerPadding))
//                    QrScanner(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
    }
}

@Composable
fun QrScanner(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(color = Color.Black)
        ) {
            Text("This contains the camera preview", color = Color.White)
        }

        Box(
            Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            IconButton(
                {
                    val qrScannerKit = QrScannerKit()
                    qrScannerKit.initializeScanner()
                },
                Modifier
                    .clip(shape = CircleShape)
                    .background(color = Color.Magenta)
                    .height(50.dp)
                    .width(50.dp)
                    .align(Alignment.Center)
            ) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "scanning")
            }
        }
    }
}

@Preview(showBackground = true, name = "LightTheme", uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, name = "DarkTheme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun QrScannerPreview() {
    ComposeStudyTheme {
        QrScannerKit()
    }
}