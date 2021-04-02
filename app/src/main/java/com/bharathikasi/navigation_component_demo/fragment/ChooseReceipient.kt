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
import kotlinx.android.synthetic.main.fragment_choose_receipient.*

class ChooseReceipient : Fragment(),View.OnClickListener {

    private lateinit var mNavController: NavController
    private lateinit var mNextBtn:Button
    private lateinit var mCancelBtn:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_receipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = Navigation.findNavController(view)
        mNextBtn       = view.findViewById(R.id.next_btn)
        mCancelBtn     = view.findViewById(R.id.cancel_btn)
        mNextBtn.setOnClickListener(this)
        mCancelBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v!=null){
            when(v.id){
                mNextBtn.id ->{
                    if(!TextUtils.isEmpty(input_recipient.text.toString())){
                        val lBundle = bundleOf("receipient" to input_recipient.text.toString())
                        mNavController.navigate(R.id.action_chooseReceipient_to_specifyAmount,lBundle)
                    }
                }
                mCancelBtn.id ->{
                    activity?.onBackPressed()
                }
            }
        }
    }

}