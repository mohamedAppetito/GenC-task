package com.test.carapplication.cars.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.test.carapplication.cars.presentation.details.CarsDetailsScreen
import com.test.carapplication.cars.presentation.list.CarsScreen
import com.test.carapplication.cars.presentation.list.CarsViewModel
import com.test.carapplication.ui.theme.CarApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CarsAroundApp()
                }
            }
        }
    }
}

@Composable
private fun CarsAroundApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "cars") {
        composable(route = "cars") {
            val viewModel: CarsViewModel = hiltViewModel()
            CarsScreen(
                state = viewModel.state.value,
                searchState = viewModel.searchState.value,
                event = viewModel::onEvent,
                onItemClick = { id ->
                    navController.navigate("cars/$id")
                },
            )
        }

        composable(
            route = "cars/{car_id}",
            arguments = listOf(navArgument(name = "car_id") { type = NavType.IntType }),
            deepLinks = listOf(navDeepLink {
                uriPattern = "https://www.carsaround.com/details/{car_id}"
            }),
        )
        {
            val carId = it.arguments?.getInt("car_id")
            CarsDetailsScreen()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CarApplicationTheme {
    }
}