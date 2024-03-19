package com.test.carapplication.cars.presentation.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.carapplication.cars.data.di.MainDispatcher
import com.test.carapplication.cars.domain.model.Car
import com.test.carapplication.cars.domain.usecase.GetCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(
    // private val stateHandel: SavedStateHandle
    private val getCarsUseCase: GetCarsUseCase,
    @MainDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private var receivedCars: List<Car> =emptyList()
    private var _state by mutableStateOf(
        CarsScreenState(
            cars = emptyList(),
            isLoading = true
        )
    )
    val state: State<CarsScreenState> get() = derivedStateOf { _state }

    private var _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        _state = _state.copy(
            isLoading = false,
            error = throwable.message
        )
    }

    init {
        getCars()
    }

    private fun getCars() {
        viewModelScope.launch(errorHandler+dispatcher) {
             receivedCars = getCarsUseCase()
            _state = _state.copy(
                cars = receivedCars,
                isLoading = false
            )
        }
    }

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                _searchState.value = _searchState.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchNews -> {
                searchCars()
            }
        }
    }

    private fun searchCars() {
        val filterCars = receivedCars.filter {
            it.color.contains(_searchState.value.searchQuery, ignoreCase = true)
        }
        _state = if (filterCars.isEmpty()) {
            _state.copy(
                cars = emptyList(),
                isLoading = false,
                error = "No cars found"
            )
        }else {
            _state.copy(
                cars = filterCars,
                isLoading = false,
                error = null
            )
        }

    }

}