package org.example.ktortesting

//import org.example.ktortesting.model.Hourly
//import org.example.ktortesting.model.WeatherWeeklyData
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.example.ktortesting.Network.WeatherClient
import org.example.weatherkmm.Model.WeatherWeeklyData
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import weatherkmm.composeapp.generated.resources.Res
import weatherkmm.composeapp.generated.resources.cloud_bg

@Composable
@Preview
fun App() {

   val weatherApiClient = WeatherClient()


    val corountineScope = rememberCoroutineScope()

    LaunchedEffect(Unit){
        corountineScope.launch {
              weatherApiClient.getWeather(16.8428503,96.2095844)
        }
    }

    val weatherData = null
    weatherData?.let {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(Res.drawable.cloud_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            WeatherCard(weatherData = it)
        }
    }

}

@Composable
fun WeatherCard(weatherData: WeatherWeeklyData){

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Current Day",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 30.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = weatherData.current.temperature_2m.toString()+"\u00B0"+"C",
            fontSize = 40.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(16.dp))

    }

}







