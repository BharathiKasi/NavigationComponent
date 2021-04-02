package com.bharathikasi.navigation_component_demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bharathikasi.navigation_component_demo.R
import com.bharathikasi.navigation_component_demo.fragment.data_class.Money
import kotlinx.android.synthetic.main.fragment_confirmation.*

class Confirmation : Fragment() {


    private lateinit var mReceipient:String
    private lateinit var mMoney: Money
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mReceipient = arguments!!.getString("receipient")!!
        mMoney      = arguments!!.getParcelable<Money>("amount") as Money

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lAmount = mMoney.pAmount
        val lConfirmationMessage = "You have sent $lAmount to $mReceipient"
        confirmation_message.text = lConfirmationMessage
    }

}