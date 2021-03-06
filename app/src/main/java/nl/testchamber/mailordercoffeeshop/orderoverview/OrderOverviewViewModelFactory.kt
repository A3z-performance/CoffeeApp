package nl.testchamber.mailordercoffeeshop.orderoverview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nl.testchamber.mailordercoffeeshop.data.beverage.BeverageMenuItem

class OrderOverviewViewModelFactory(val beverageMenuItem: BeverageMenuItem) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrderOverviewViewModel(beverageMenuItem) as T
    }
}