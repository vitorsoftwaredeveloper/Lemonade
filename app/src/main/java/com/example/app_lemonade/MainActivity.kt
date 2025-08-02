package com.example.app_lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
    Box(
        modifier = Modifier
            .background(Color(0xFFB2DFDB))
            .padding(18.dp)
    ){
        Text(text = "Lemonade",
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
    }

    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ,modifier = Modifier.fillMaxSize()){
        var result by remember { mutableStateOf(1) }
        val lemontree = when(result) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else-> R.drawable.lemon_restart
        }

        val description = when(result) {
            1 -> R.string.lemon_tree
            2 -> R.string.lemon_squeeze
            3 -> R.string.lemon_drink
            else-> R.string.lemon_restart
        }

        var repeatCount by remember { mutableStateOf(0) }

        Box(
            modifier = Modifier
                .background(Color(0xFFB2DFDB), shape = RoundedCornerShape(32.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current
                ){
                    when(result) {
                        1 -> {
                            result = 2
                            repeatCount = (2..4).random()
                        }
                        2 -> if (repeatCount <= 4) {
                                repeatCount++
                            } else {
                                result = 3
                            }
                        3 -> result = 4
                        else -> result = 1
                    }
                }
                .padding(64.dp,16.dp)
        ) {
            Image(
                painter = painterResource(lemontree) ,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(250.dp)
                    .width(150.dp)

            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(description), fontSize = 18.sp, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App_LemonadeTheme {
        Lemonade("Android")
    }
}