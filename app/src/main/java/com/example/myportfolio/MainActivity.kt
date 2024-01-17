package com.example.myportfolio

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myportfolio.ui.theme.MyPortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPortfolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp) // That's the way to do elevation
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(15.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                // Add content inside the Card
                imageProfile()
                Divider(color = Color.LightGray, thickness = 1.dp)
                profileDescription()
                Button(onClick = { Log.d("Clicked", "CreateBizCard: ") }) {
                    Text("Portfolio",
                        style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

@Composable
private fun profileDescription() {
    Text(
        "Medley Diaries", modifier = Modifier
            .padding(10.dp),
        fontFamily = FontFamily.Cursive,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.W900,
        fontSize = 30.sp
    )
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            "Full Stack Developer",
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            fontSize = 15.sp
        )
        Divider(modifier = Modifier.width(170.dp))
        Text(
            "@medleydiaries",
            fontFamily = FontFamily.SansSerif, style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun imageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(15.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.LightGray),
        shadowElevation = 10.dp,
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_copy),
            contentDescription = "logo_copy",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyPortfolioTheme {
        CreateBizCard()
    }
}