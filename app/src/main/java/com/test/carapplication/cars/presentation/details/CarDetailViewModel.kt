package com.test.carapplication.cars.presentation.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.carapplication.cars.data.di.MainDispatcher
import com.test.carapplication.cars.domain.model.Car
import com.test.carapplication.cars.domain.usecase.GetCarItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarDetailViewModel @Inject constructor(
    private val stateHandel: SavedStateHandle,
    private val getCarUseCase: GetCarItemUseCase,
    @MainDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    var state = mutableStateOf<Car?>(null)

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    init {
        val carId=stateHandel.get<Int>("car_id")
        carId?.let { getCarDetail(it) }
    }

    private fun getCarDetail(id: Int) {
        viewModelScope.launch(errorHandler+dispatcher) {
            val car = getCarUseCase(id)
            state.value=car
        }
    }



}