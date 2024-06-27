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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.interviewproject.R
import com.example.interviewproject.data.ItemData
import com.example.interviewproject.presentation.theme.AppTheme
import com.example.interviewproject.viewmodels.itemscreenvm.ItemScreenViewModel
import dagger.hilt.android.scopes.ViewScoped
@Composable
fun ItemScreen(clickedHome:String,
    clickedHomeLogo:Int
    ,navController: NavController,
               itemScreenViewModel: ItemScreenViewModel = hiltViewModel()) {
    val itemsLighting = listOf(
        ItemData(title = stringResource(R.string.yonetim)),
        ItemData(title = stringResource(R.string.serkan)),
        ItemData(title = stringResource(R.string.abajur)),
        ItemData(title = stringResource(R.string.arge)),
        ItemData(title = stringResource(R.string.lorem)),
        ItemData(title = stringResource(R.string.ipsum)),
        ItemData(title = stringResource(R.string.lorem)),
        ItemData(title = stringResource(R.string.ipsum)),
        ItemData(title = stringResource(R.string.lorem)),
        ItemData(title = stringResource(R.string.ipsum)),
        ItemData(title = stringResource(R.string.lorem)),
        ItemData(title = stringResource(R.string.ipsum)),
        ItemData(title = stringResource(R.string.lorem)),
        ItemData(title = stringResource(R.string.ipsum)),
        ItemData(title = stringResource(R.string.lorem)),
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (clickedHome == "Lighting"){
            LinearGradientItem(clickedHome,clickedHomeLogo, navController,itemsLighting)
        }
        else {
            ElseScreen(navController =navController,clickedHome,clickedHomeLogo)
        }

    }
}

@Composable
fun LinearGradientItem(clickedHome: String,clickedHomeLogo: Int,navController: NavController, items: List<ItemData>) {
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
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = stringResource(id = R.string.back),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(vertical = AppTheme.dimens.small)
                            .clickable {
                                navController.popBackStack()
                            }
                    )

                    Text(
                        text = clickedHome,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(vertical = AppTheme.dimens.small)
                    )

                    Image(
                        painter = painterResource(clickedHomeLogo),
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
                    columns = GridCells.Fixed(2)
                ) {
                    items(items) { item ->
                        GridItems(item = item, navController,clickedHomeLogo)
                    }
                }
            }
        }
    }
}

@Composable
fun GridItems(item: ItemData, navController: NavController, clickedHomeLogo: Int) {
    Box(
        modifier = Modifier
            .size((LocalConfiguration.current.screenWidthDp * 0.30f).dp)
            .padding(8.dp)
            .background(Color.Black.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(clickedHomeLogo),
                contentDescription = null,
                modifier = Modifier.size(50.dp) // Must be responsive
            )
            Text(
                text = item.title,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = AppTheme.dimens.mediumLarge)
            )
        }
    }
}
@Composable
fun ElseScreen(navController: NavController,clickedHome: String,clickedHomeLogo: Int) {
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
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = stringResource(id = R.string.back),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(vertical = AppTheme.dimens.small)
                            .clickable {
                                navController.popBackStack()
                            }
                    )

                    Text(
                        text = clickedHome,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(vertical = AppTheme.dimens.small)
                    )

                    Image(
                        painter = painterResource(clickedHomeLogo),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(40.dp)
                            .padding(end = AppTheme.dimens.small)
                    )
                }
            }
        }
    }
}