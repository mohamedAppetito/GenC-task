package com.test.carapplication.cars.presentation.list

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String) : SearchEvent()

     object SearchNews : SearchEvent()
}
