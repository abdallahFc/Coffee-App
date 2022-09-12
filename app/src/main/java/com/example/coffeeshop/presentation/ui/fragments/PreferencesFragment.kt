package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R

class PreferencesFragment : Fragment(R.layout.fragment_preferences) {
    private lateinit var totalPrice: TextView
    private lateinit var count: TextView
    private lateinit var smallCoffe: ImageView
    private lateinit var midCoffe: ImageView
    private lateinit var largeCoffe: ImageView
    private lateinit var price: TextView
    private lateinit var prefOne: ImageView
    private lateinit var prefTwo: ImageView
    private lateinit var oneSugar: ImageView
    private lateinit var  add: ImageView
    private lateinit var remove: ImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefBtn = view.findViewById<Button>(R.id.btn_add_to_cart)
        smallCoffe = view.findViewById(R.id.iv_coffee_small)
        midCoffe = view.findViewById(R.id.iv_coffee_med)
        largeCoffe = view.findViewById(R.id.iv_coffe_large)
        val onSugar = view.findViewById<ImageView>(R.id.iv_no_sugar)
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

        prefBtn.setOnClickListener {
            findNavController().navigate(PreferencesFragmentDirections.actionPreferencesFragmentToCartFragment())
        }
        smallCoffe.setOnClickListener {
            smallCoffe.setColorFilter(R.color.black)
            largeCoffe.clearColorFilter()
            midCoffe.clearColorFilter()
            smallCoffe.tag = R.color.black
            midCoffe.tag = R.color.gray
            largeCoffe.tag = R.color.gray
            calculateTotal()
        }
        midCoffe.setOnClickListener {
            midCoffe.setColorFilter(R.color.black)
            largeCoffe.clearColorFilter()
            smallCoffe.clearColorFilter()
            midCoffe.tag = R.color.black
            smallCoffe.tag = R.color.gray
            largeCoffe.tag = R.color.gray
            calculateTotal()
        }
        largeCoffe.setOnClickListener {
            largeCoffe.setColorFilter(R.color.black)
            largeCoffe.tag = R.color.black
            midCoffe.clearColorFilter()
            smallCoffe.clearColorFilter()
            midCoffe.tag = R.color.gray
            smallCoffe.tag = R.color.gray
            calculateTotal()
        }
        onSugar.setOnClickListener {
            onSugar.setColorFilter(R.color.black)
            oneSugar.clearColorFilter()
            twoSugar.clearColorFilter()
            threeSugar.clearColorFilter()
            onSugar.tag = R.color.black
            oneSugar.tag = R.color.gray
            twoSugar.tag = R.color.gray
            threeSugar.tag = R.color.black
        }
        oneSugar.setOnClickListener {
            oneSugar.setColorFilter(R.color.black)
            onSugar.clearColorFilter()
            twoSugar.clearColorFilter()
            threeSugar.clearColorFilter()
            oneSugar.tag = R.color.black
            onSugar.tag = R.color.gray
            twoSugar.tag = R.color.gray
            threeSugar.tag = R.color.gray
            //calculateTotal()
        }
        twoSugar.setOnClickListener {
            twoSugar.setColorFilter(R.color.black)
            oneSugar.clearColorFilter()
            onSugar.clearColorFilter()
            threeSugar.clearColorFilter()
            oneSugar.tag = R.color.gray
            onSugar.tag = R.color.gray
            twoSugar.tag = R.color.black
            threeSugar.tag = R.color.gray
        }
        threeSugar.setOnClickListener {
            threeSugar.setColorFilter(R.color.black)
            oneSugar.clearColorFilter()
            twoSugar.clearColorFilter()
            onSugar.clearColorFilter()
            oneSugar.tag = R.color.gray
            onSugar.tag = R.color.gray
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
            count.text=(count.text.toString().toInt()+1).toString()
            calculateTotal()
        }

        remove.setOnClickListener {
            if(count.text.toString().toInt()>0){
                count.text=(count.text.toString().toInt()-1).toString()
            }
            calculateTotal()
        }
        defaultSelect()
        calculateTotal()

    }
    private fun defaultSelect(){
        midCoffe.setColorFilter(R.color.black)
        midCoffe.tag = R.color.black
        oneSugar.setColorFilter(R.color.black)
        oneSugar.tag = R.color.black
    }

    private fun calculateTotal() {
        val num = count.text.toString().toInt()
        var total = 0.0
        val smPrice = price.text.toString().toDouble()
        if (midCoffe.tag.equals(R.color.black)) {
            total = smPrice * num*1.5
        } else if (smallCoffe.tag.equals(R.color.black)) {
            total = smPrice * num
        } else if (largeCoffe.tag.equals(R.color.black)) {
            total = smPrice * 2 * num
        }
        totalPrice.text = ("$total EGP")
    }
}