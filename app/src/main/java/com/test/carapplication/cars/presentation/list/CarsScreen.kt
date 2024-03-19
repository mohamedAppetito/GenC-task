@file:OptIn(ExperimentalMaterial3Api::class)

package com.test.carapplication.cars.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.carapplication.R
import com.test.carapplication.cars.domain.model.Car
import com.test.carapplication.cars.presentation.SemanticsDescription
import com.test.carapplication.cars.presentation.component.CarDetails
import com.test.carapplication.cars.presentation.component.CustomSearchBar
import com.test.carapplication.ui.theme.CarApplicationTheme

@Composable
fun CarsScreen(
    searchState: SearchState,
    event: (SearchEvent) -> Unit,
    state: CarsScreenState,
    onItemClick: (Int) -> Unit,
) {


    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize()
        ) {
            CustomSearchBar(
                text = searchState.searchQuery,
                readOnly = false,
                onValueChange = {
                    event(SearchEvent.UpdateSearchQuery(it))
                },
                onSearch = {
                     event(SearchEvent.SearchNews)
                }
            )

            LazyColumn {
                items(state.cars) { car ->
                    CarItem(
                        car = car,
                        onItemClick = { onItemClick(it) },
                    )
                }
            }
        }
        if (state.isLoading) CircularProgressIndicator(
            Modifier.semantics {
                this.contentDescription = SemanticsDescription.CARS_LIST_LOADING
            }
        )
        state.error?.let { Text(text = it) }
    }
}

@Composable
fun CarItem(car: Car, onItemClick: (Int) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp,bottom = 16.dp)
            .clickable { onItemClick(car.id) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        CarDetails(car)
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewScreen() {
    CarApplicationTheme {
        // GymsScreen()
    }
}
