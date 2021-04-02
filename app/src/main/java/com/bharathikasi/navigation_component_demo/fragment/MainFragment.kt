package com.bharathikasi.navigation_component_demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bharathikasi.navigation_component_demo.R

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(),View.OnClickListener {

    private lateinit var mNavController: NavController
    private lateinit var mViewTransactionBtn:Button
    private lateinit var mSendMoneyBtn:Button
    private lateinit var mViewBalanceBtn:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController      = Navigation.findNavController(view)
        mViewTransactionBtn = view.findViewById(R.id.view_transactions_btn)
        mSendMoneyBtn       = view.findViewById(R.id.send_money_btn)
        mViewBalanceBtn     = view.findViewById(R.id.view_balance_btn)
        mViewTransactionBtn .setOnClickListener(this)
        mSendMoneyBtn       .setOnClickListener(this)
        mViewBalanceBtn     .setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v!=null){
            when(v.id){
                mViewTransactionBtn.id ->{
                    mNavController.navigate(R.id.action_mainFragment_to_viewTransaction)
                }
                mSendMoneyBtn.id ->{
                    mNavController.navigate(R.id.action_mainFragment_to_chooseReceipient)

                }
                mViewBalanceBtn.id ->{
                    mNavController.navigate(R.id.action_mainFragment_to_viewBalance)
                }
            }
        }
    }
}