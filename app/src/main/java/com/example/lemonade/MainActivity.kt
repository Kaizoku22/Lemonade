package com.example.lemonade

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeScreen()


                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun LemonadeScreen() {
    var currentStep by remember {
        mutableStateOf(1)
    }
    when (currentStep) {

    1->Column {
            LemonadeTitle()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    color = colorResource(id = R.color.image_bg),
                    modifier = Modifier
                        .height(250.dp)
                        .width(250.dp)
                        .padding(all = 16.dp)
                        .clickable {currentStep++ },
                    shape = RoundedCornerShape(32.dp),
    
                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = null,
                        modifier=Modifier.padding(32.dp))
                }
                Text(text = stringResource(id = R.string.command_select_lemon))
            }
        }
    2-> Column {
            LemonadeTitle()
        var taps_required=(2..4).random()
        var taps_Done=0
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                color = colorResource(id = R.color.image_bg),
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
                    .padding(all = 16.dp)
                    .clickable { taps_Done++
                               if(taps_Done==taps_required){
                                   currentStep++
                               }},
                shape = RoundedCornerShape(32.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = null,
                    modifier=Modifier.padding(32.dp))
            }
            Text(text = stringResource(id = R.string.command_keep_tapping_to_squeeze))
        }
    }
    3-> Column {
        LemonadeTitle()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                color = colorResource(id = R.color.image_bg),
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
                    .padding(all = 16.dp)
                    .clickable { currentStep++},
                shape = RoundedCornerShape(32.dp),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = null,
                    modifier=Modifier.padding(32.dp))
            }
            Text(text = stringResource(id = R.string.command_tap_to_drink))
        }
    }
    4->Column {
        LemonadeTitle()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                color = colorResource(id = R.color.image_bg),
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
                    .padding(all = 16.dp)
                    .clickable { currentStep=1},
                shape = RoundedCornerShape(32.dp),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = null,
                    modifier=Modifier.padding(32.dp))
            }
            Text(text = stringResource(id = R.string.command_tap_to_start_again))
        }
    }
    }
  }

@Composable
fun LemonadeTitle(modifier: Modifier=Modifier){
    Box() {
        Surface(color = colorResource(id = R.color.yellow),
            modifier = Modifier
                .height(44.dp)
                .fillMaxWidth())
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Lemonade", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
    }




}


@Composable
fun LemonadeContentScreen(command:String,contentImage:Painter,modifier: Modifier){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
        ) {
        Surface(
            color = colorResource(id = R.color.image_bg),
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
                .padding(all = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(32.dp),

                ) {
            Image(
                painter = contentImage,
                contentDescription = null,
                modifier=Modifier.padding(32.dp))
        }
        Text(text = command)
    }
}

