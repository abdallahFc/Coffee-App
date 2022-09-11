package com.example.coffeeshop.viewmodel



import androidx.lifecycle.ViewModel
import com.example.coffeeshop.R.drawable
import com.example.coffeeshop.data.CartItem

class CartViewModel : ViewModel() {
    fun getAdapterList(): List<CartItem> {
        val cartList = ArrayList<CartItem>()
        cartList.add(CartItem(drawable.ic_espresso, "Espresso",2,60))
        cartList.add(CartItem(drawable.ic_cappuccino, "Cappuccino",4,150))
        cartList.add(CartItem(drawable.ic_macciato, "Macciato",1,30))
        cartList.add(CartItem(drawable.ic_mocha, "Mocha",3,120))
        cartList.add(CartItem(drawable.ic_latte, "Latte",1,40))
        cartList.add(CartItem(drawable.ic_espresso, "Espresso",2,60))
        cartList.add(CartItem(drawable.ic_espresso, "Espresso",2,60))
        cartList.add(CartItem(drawable.ic_latte, "Latte",1,40))
        cartList.add(CartItem(drawable.ic_latte, "Latte",1,40))
        cartList.add(CartItem(drawable.ic_espresso, "Espresso",2,60))
        cartList.add(CartItem(drawable.ic_espresso, "Espresso",2,60))
        cartList.add(CartItem(drawable.ic_latte, "Latte",1,60))
        return cartList.toList()
    }
}