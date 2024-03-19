package com.test.carapplication

import com.test.carapplication.cars.data.remote.CarsApiService
import com.test.carapplication.cars.data.remote.RemoteCar
import com.test.carapplication.cars.data.repository.CarsRepositoryImpl
import com.test.carapplication.cars.domain.usecase.GetCarsUseCase
import com.test.carapplication.cars.presentation.list.CarsScreenState
import com.test.carapplication.cars.presentation.list.CarsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class CarsViewModelTest {

    private val dispatcher= StandardTestDispatcher()
    private val scope= TestScope(dispatcher)

    @Test
    fun loadingState_isSetCorrectly() = scope.runTest {
        val viewModel = getViewModel()

        val state=viewModel.state.value

        assert(
            state == CarsScreenState(
                cars = emptyList(),
                isLoading = true,
                error = null
            )
        )

    }

    @Test
    fun loadingContentState_isSetCorrectly() = scope.runTest {
        val viewModel = getViewModel()
        advanceUntilIdle()
        val state=viewModel.state.value
        assert(
            state == CarsScreenState(
                cars = DummyCarList.getDummyCarList(),
                isLoading = false,
                error = null
            )
        )

    }

    private fun getViewModel(): CarsViewModel {

        val carsRepository = CarsRepositoryImpl(TestCarApiServices(),dispatcher)
        val getCarsUseCase = GetCarsUseCase(carsRepository)
        return CarsViewModel(getCarsUseCase,dispatcher)
    }
}

class TestCarApiServices : CarsApiService {
    override suspend fun getCars(): List<RemoteCar> {
        return DummyCarList.getDummyList()
    }

    override suspend fun getCarDetail(id: Int): Map<String, RemoteCar> {
        TODO("Not yet implemented")
    }

}