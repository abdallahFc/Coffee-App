package com.example.coffeeshop.presentation.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.AddToCart
import com.example.coffeeshop.data.model.CartItem
import java.util.ArrayList


class PreferencesFragment : Fragment(R.layout.fragment_preferences) {
    private lateinit var totalPrice: TextView
    private lateinit var count: TextView
    private lateinit var smallCoffee: ImageView
    private lateinit var midCoffee: ImageView
    private lateinit var largeCoffee: ImageView
    private lateinit var price: TextView
    private lateinit var prefOne: ImageView
    private lateinit var prefTwo: ImageView
    private lateinit var oneSugar: ImageView
    private lateinit var add: ImageView
    private lateinit var remove: ImageView
    private lateinit var image: ImageView
    private lateinit var name: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_preferences, container, false)
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefBtn = view.findViewById<Button>(R.id.btn_add_to_cart)
        smallCoffee = view.findViewById(R.id.iv_coffee_small)
        midCoffee = view.findViewById(R.id.iv_coffee_med)
        largeCoffee = view.findViewById(R.id.iv_coffe_large)
        val noSugar = view.findViewById<ImageView>(R.id.iv_no_sugar)
        oneSugar = view.findViewById(R.id.iv_sugar1)
        val twoSugar = view.findViewById<ImageView>(R.id.iv_sugar2)
        val threeSugar = view.findViewById<ImageView>(R.id.iv_sugar3)
        prefOne = view.findViewById(R.id.iv_pref1)
        prefTwo = view.findViewById(R.id.iv_pref2)
        count = view.findViewById(R.id.counter)
        totalPrice = view.findViewById(R.id.tv_total_Price)
        price = view.findViewById(R.id.price)
        add = view.findViewById(R.id.add)
        remove = view.findViewById(R.id.remove)
        image = view.findViewById(R.id.image)
        name = view.findViewById(R.id.category)
        val back = view.findViewById<ImageView>(R.id.iv_back)
        val rName = arguments?.get("name").toString()
        val rPrice = arguments?.get("price").toString()
        val img = arguments?.get("image").toString()
        Glide.with(image).load(img).into(image)
        name.text = rName
        price.text = rPrice
        prefBtn.setOnClickListener {
            val list: ArrayList<CartItem> = AddToCart.getInstance()
            val sCount = count.text.toString()
            val c = totalPrice.text.toString().split(" ")
            val sPrice = c[0]
            list.add(CartItem(img, rName, sCount, sPrice))
            Toast.makeText(requireContext(), "Successfully Order Check Cart", Toast.LENGTH_SHORT)
                .show()
            var totalCount = 0.0
            for (item in list) {
                totalCount += item.price.toDouble()
            }
            Toast.makeText(requireContext(), "$totalCount", Toast.LENGTH_SHORT)
                .show()
           // findNavController().navigate(PreferencesFragmentDirections.actionPreferencesFragmentToCartFragment())
        }
        smallCoffee.setOnClickListener {
            smallCoffee.setColorFilter(R.color.black)
            largeCoffee.clearColorFilter()
            midCoffee.clearColorFilter()
            smallCoffee.tag = R.color.black
            midCoffee.tag = R.color.gray
            largeCoffee.tag = R.color.gray
            calculateTotal()
        }
        midCoffee.setOnClickListener {
            midCoffee.setColorFilter(R.color.black)
            largeCoffee.clearColorFilter()
            smallCoffee.clearColorFilter()
            midCoffee.tag = R.color.black
            smallCoffee.tag = R.color.gray
            largeCoffee.tag = R.color.gray
            calculateTotal()
        }
        largeCoffee.setOnClickListener {
            largeCoffee.setColorFilter(R.color.black)
            largeCoffee.tag = R.color.black
            midCoffee.clearColorFilter()
            smallCoffee.clearColorFilter()
            midCoffee.tag = R.color.gray
            smallCoffee.tag = R.color.gray
            calculateTotal()
        }
        noSugar.setOnClickListener {
            noSugar.setColorFilter(R.color.black)
            oneSugar.clearColorFilter()
            twoSugar.clearColorFilter()
            threeSugar.clearColorFilter()
            noSugar.tag = R.color.black
            oneSugar.tag = R.color.gray
            twoSugar.tag = R.color.gray
            threeSugar.tag = R.color.black
        }
        oneSugar.setOnClickListener {
            oneSugar.setColorFilter(R.color.black)
            noSugar.clearColorFilter()
            twoSugar.clearColorFilter()
            threeSugar.clearColorFilter()
            oneSugar.tag = R.color.black
            noSugar.tag = R.color.gray
            twoSugar.tag = R.color.gray
            threeSugar.tag = R.color.gray
            //calculateTotal()
        }
        twoSugar.setOnClickListener {
            twoSugar.setColorFilter(R.color.black)
            oneSugar.clearColorFilter()
            noSugar.clearColorFilter()
            threeSugar.clearColorFilter()
            oneSugar.tag = R.color.gray
            noSugar.tag = R.color.gray
            twoSugar.tag = R.color.black
            threeSugar.tag = R.color.gray
        }
        threeSugar.setOnClickListener {
            threeSugar.setColorFilter(R.color.black)
            oneSugar.clearColorFilter()
            twoSugar.clearColorFilter()
            noSugar.clearColorFilter()
            oneSugar.tag = R.color.gray
            noSugar.tag = R.color.gray
            twoSugar.tag = R.color.gray
            threeSugar.tag = R.color.black
        }
        prefOne.setOnClickListener {
            prefOne.setColorFilter(R.color.black)
            prefTwo.clearColorFilter()
            prefOne.tag = R.color.black
            prefTwo.tag = R.color.gray
            calculateTotal()
        }
        prefTwo.setOnClickListener {
            prefTwo.setColorFilter(R.color.black)
            prefOne.clearColorFilter()
            prefOne.tag = R.color.gray
            prefTwo.tag = R.color.black

        }
        add.setOnClickListener {
            count.text = (count.text.toString().toInt() + 1).toString()
            calculateTotal()
        }

        remove.setOnClickListener {
            if (count.text.toString().toInt() > 0) {
                count.text = (count.text.toString().toInt() - 1).toString()
            }
            calculateTotal()
        }
        back.setOnClickListener {
            activity?.onBackPressed()
        }
        defaultSelect()
        calculateTotal()

    }

    private fun defaultSelect() {
        midCoffee.setColorFilter(R.color.black)
        midCoffee.tag = R.color.black
        oneSugar.setColorFilter(R.color.black)
        oneSugar.tag = R.color.black
    }


    @SuppressLint("SetTextI18n")
    private fun calculateTotal() {
        val num = count.text.toString().toInt()
        var total = 0.0
        val smPrice = price.text.toString().toDouble()
        if (midCoffee.tag.equals(R.color.black)) {
            total = smPrice * num * 1.5
        } else if (smallCoffee.tag.equals(R.color.black)) {
            total = smPrice * num
        } else if (largeCoffee.tag.equals(R.color.black)) {
            total = smPrice * 2 * num
        }
        totalPrice.text = ("$total EGP")
    }
}