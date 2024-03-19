package com.test.carapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.test.carapplication.DummyCarList.getDummyList
import com.test.carapplication.cars.presentation.SemanticsDescription
import com.test.carapplication.cars.presentation.list.CarsScreen
import com.test.carapplication.cars.presentation.list.CarsScreenState
import com.test.carapplication.cars.presentation.list.SearchState
import com.test.carapplication.ui.theme.CarApplicationTheme
import org.junit.Rule
import org.junit.Test

class CarsScreenTest {

    // to add function to existing class and work with composable ui and set content without need for host such activity or fragment
    @get:Rule
    val testRule: ComposeContentTestRule = createComposeRule()


    @Test
    fun loadingState_isActive() {
        testRule.setContent {
            CarApplicationTheme {
                CarsScreen(
                    state = CarsScreenState(cars = emptyList(), isLoading = true),
                    onItemClick = {}, event = {}, searchState = SearchState()
                )
            }
        }
        testRule.onNodeWithContentDescription(SemanticsDescription.CARS_LIST_LOADING)
            .assertIsDisplayed()
    }

    @Test
    fun loadingContentState_isActive() {
        val dummyList = getDummyList()

        testRule.setContent {
            CarApplicationTheme {
                CarsScreen(
                    state = CarsScreenState(cars = dummyList, isLoading = false, error = null),
                    onItemClick = {}, event = {}, searchState = SearchState()
                )
            }
        }
        testRule.onNodeWithText(dummyList[0].id.toString()).assertIsDisplayed()
        testRule.onNodeWithContentDescription(SemanticsDescription.CARS_LIST_LOADING)
            .assertDoesNotExist()
    }

    @Test
    fun loadingError_isActive() {
        val errorText = "failed to load data"
        testRule.setContent {
            CarApplicationTheme {
                CarsScreen(
                    state = CarsScreenState(
                        cars = emptyList(),
                        isLoading = false,
                        error = errorText
                    ),
                    onItemClick = {}, event = {}, searchState = SearchState()
                )
            }
        }
        testRule.onNodeWithText(errorText).assertIsDisplayed()
        testRule.onNodeWithContentDescription(SemanticsDescription.CARS_LIST_LOADING)
            .assertDoesNotExist()
    }

    @Test
    fun onItemClicked_idIsPassedCorrectly() {
        val dummyList = DummyCarList.getDummyList()
        testRule.setContent {
            CarApplicationTheme {
                CarsScreen(
                    state = CarsScreenState(cars = dummyList, isLoading = false),
                    onItemClick = { id ->
                        assert(dummyList[0].id == id)
                    }, event = {}, searchState = SearchState()
                )
            }
        }
        testRule.onNodeWithText(dummyList[0].color.toString()).performClick()
    }
}