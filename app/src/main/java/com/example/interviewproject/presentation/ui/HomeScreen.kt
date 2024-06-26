package com.example.interviewproject.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.interviewproject.R
import com.example.interviewproject.data.HomeItem
import com.example.interviewproject.presentation.theme.AppTheme
import com.example.interviewproject.presentation.ui.navigation.Screen
import dagger.hilt.android.scopes.ViewScoped
import okhttp3.Request
@ViewScoped
@Composable
fun HomeScreen(navController: NavController) {
    val items = listOf(
        HomeItem(title = stringResource(R.string.favourites_text), logo = R.drawable.baseline_favorite_24),
        HomeItem(title = stringResource(R.string.lighting_text), logo = R.drawable.baseline_lightbulb_outline_24),
        HomeItem(title = stringResource(R.string.curtain_text), logo = R.drawable.baseline_curtains_24),
        HomeItem(title = stringResource(R.string.socket_text), logo = R.drawable.baseline_power_24),
        HomeItem(title = stringResource(R.string.scenario_text), logo = R.drawable.baseline_description_24),
        HomeItem(title = stringResource(R.string.controller_text), logo = R.drawable.baseline_padding_24),
        HomeItem(title = stringResource(R.string.camera_text), logo = R.drawable.baseline_photo_camera_24),
        HomeItem(title = stringResource(R.string.alarm_text), logo = R.drawable.baseline_access_alarm_24),
        HomeItem(title = stringResource(R.string.intercom_text), logo = R.drawable.baseline_mic_external_on_24),
        HomeItem(title = stringResource(R.string.system_text), logo = R.drawable.baseline_brightness_5_24),
        HomeItem(title = stringResource(R.string.heating_text), logo = R.drawable.baseline_device_thermostat_24),
        HomeItem(title = stringResource(R.string.air_conditioner_text), logo = R.drawable.baseline_dew_point_24),
        HomeItem(title = stringResource(R.string.sensor_text), logo = R.drawable.baseline_adb_24),
        HomeItem(title = stringResource(R.string.apartment_management_text), logo = R.drawable.baseline_apartment_24),
        HomeItem(title = stringResource(R.string.concierge_text), logo = R.drawable.baseline_handshake_24),
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LinearGradientHome(navController, items)
    }
}

@Composable
fun LinearGradientHome(navController: NavController, items: List<HomeItem>) {
    val gradient = Brush.linearGradient(
        0.0f to Color.Magenta,
        500.0f to Color.Cyan,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Spacer(modifier = Modifier.height(25.dp))
            Row {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((LocalConfiguration.current.screenHeightDp * 0.1f).dp)
                        .background(Color.Black.copy(alpha = 0.5f))
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.inohom_text),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = AppTheme.dimens.small)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.baseline_brightness_5_24),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(40.dp)
                            .padding(end = AppTheme.dimens.small)
                    )
                }
                }
            Row {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(AppTheme.dimens.small),
                    columns = GridCells.Fixed(3)
                ) {
                    items(items) { item ->
                        GridItem(item = item, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun GridItem(item: HomeItem, navController: NavController) {
    Box(
        modifier = Modifier
            .size((LocalConfiguration.current.screenWidthDp * 0.30f).dp)
            .padding(8.dp)
            .background(Color.Black.copy(alpha = 0.5f))
        .clickable(onClick = {
            navController.navigate("${Screen.ItemScreen.route}/${item.title}/${item.logo}")}),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = item.logo),
                contentDescription = null,
                modifier = Modifier.size(50.dp) // Must be responsive
            )
            Text(
                text = item.title,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top =AppTheme.dimens.mediumLarge)
            )
        }
    }
}