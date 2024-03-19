package com.test.carapplication.cars.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.carapplication.cars.presentation.component.CarDetails

@Composable
fun CarsDetailsScreen() {

    val viewModel: CarDetailViewModel  = hiltViewModel()
    val item = viewModel.state.value

    item?.let {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            CarDetails(
                car = it,
                alignment = Alignment.CenterHorizontally
            )

        }
    }

}