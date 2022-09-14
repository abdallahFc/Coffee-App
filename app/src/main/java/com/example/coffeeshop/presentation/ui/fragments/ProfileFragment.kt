package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.PersonalInfo


class ProfileFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var userName= view.findViewById<TextView>(R.id.value_username)
        var email= view.findViewById<TextView>(R.id.value_email)
        userName.text= PersonalInfo.getInstance().userName.toString()
        email.text=PersonalInfo.getInstance().mail.toString()
    }
}