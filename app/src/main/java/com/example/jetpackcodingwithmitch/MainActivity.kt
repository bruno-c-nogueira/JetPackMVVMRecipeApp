package com.example.jetpackcodingwithmitch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFf2f2f2))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())) {

                        Image(
                            painter = painterResource(id = R.drawable.happy_meal_small),
                            contentDescription = "happy meal",
                            Modifier
                                .height(300.dp)
                                .fillMaxWidth()
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Happy Meal",
                                style = TextStyle(fontSize = 26.sp)
                            )
                            Text(
                                textAlign = TextAlign.Center,
                                text = "$5.99",
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    color = Color(0xFF85bb65)
                                ),
                                modifier = Modifier.align(alignment = Alignment.CenterVertically)
                            )
                        }
                Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            text = "800 calories",
                            style = TextStyle(
                                fontSize = 17.sp,
                            )
                        )
                        Button({}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "BUY", color = Color.White, textAlign = TextAlign.Center)
                        }
                    }
        }
    }
}


