package com.example.coffeeshop.viewmodel



import androidx.lifecycle.ViewModel
import com.example.coffeeshop.R.drawable
import com.example.coffeeshop.data.Product

class HomeViewModel : ViewModel() {
    fun getAdapterList(): List<Product> {
        val coffeList = ArrayList<Product>()
        coffeList.add(Product(drawable.ic_espresso, "Espresso"))
        coffeList.add(Product(drawable.ic_cappuccino, "Cappuccino"))
        coffeList.add(Product(drawable.ic_macciato, "Macciato"))
        coffeList.add(Product(drawable.ic_mocha, "Mocha"))
        coffeList.add(Product(drawable.ic_latte, "Latte"))
        coffeList.add(Product(drawable.ic_espresso, "Espresso"))
        coffeList.add(Product(drawable.ic_espresso, "Espresso"))
        coffeList.add(Product(drawable.ic_espresso, "Espresso"))
        coffeList.add(Product(drawable.ic_espresso, "Espresso"))
        coffeList.add(Product(drawable.ic_espresso, "Espresso"))
        coffeList.add(Product(drawable.ic_espresso, "Espresso"))
        coffeList.add(Product(drawable.ic_latte, "Latte"))
        return coffeList.toList()
    }
}