package com.bharathikasi.navigation_component_demo.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bharathikasi.navigation_component_demo.R
import com.bharathikasi.navigation_component_demo.fragment.data_class.Money
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

class SpecifyAmount : Fragment() ,View.OnClickListener{
    private lateinit var mNavController: NavController
    private lateinit var mSendBtn:Button
    private lateinit var mCancelBtn:Button
    private lateinit var mReceipient: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mReceipient = arguments!!.getString("receipient")!!
        recipient.text = "Sending money to $mReceipient"

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = Navigation.findNavController(view)
        mSendBtn       = view.findViewById(R.id.send_btn)
        mCancelBtn     = view.findViewById(R.id.cancel_btn)
        mSendBtn.setOnClickListener(this)
        mCancelBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v!=null){
            when(v.id){
                mSendBtn.id ->{
                    if (!TextUtils.isEmpty(input_amount.text.toString())){
                        val lMoney = Money(BigDecimal(input_amount.text.toString()))
                        val lBundle = bundleOf("amount" to lMoney,
                            "receipient" to mReceipient
                            )
                        mNavController.navigate(R.id.action_specifyAmount_to_confirmation,lBundle)
                    }
                }
                mCancelBtn.id ->{
                    activity?.onBackPressed()
                }
            }
        }
    }


}