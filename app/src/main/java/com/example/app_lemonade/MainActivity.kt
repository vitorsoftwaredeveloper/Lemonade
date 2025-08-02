package com.example.app_lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_lemonade.ui.theme.App_LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Lemonade(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Lemonade(name: String, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ,modifier = Modifier.fillMaxSize()){
        val lemontree= painterResource(R.drawable.lemon_tree)

        Box(
            modifier = Modifier
                .background(Color(0xFFB2DFDB), shape = RoundedCornerShape(32.dp)) // cor de fundo e bordas arredondadas
                .padding(64.dp,16.dp)
        ) {
            Image(
                painter = lemontree,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(250.dp)
                    .width(150.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(R.string.lemon_tree), fontSize = 18.sp, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App_LemonadeTheme {
        Lemonade("Android")
    }
}