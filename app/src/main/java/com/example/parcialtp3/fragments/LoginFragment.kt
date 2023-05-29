package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.viewmodel.LoginViewModel
import com.example.parcialtp3.utils.ToolbarUitls

class LoginFragment : Fragment() {

    lateinit var loginView : View
    lateinit var txtUserName : TextView
    lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        loginView =  inflater.inflate(R.layout.login_fragment, container, false)

        txtUserName = loginView.findViewById<TextView>(R.id.txt_UserName)
        btnLogin = loginView.findViewById<Button>(R.id.btnLogin)
        var toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar_custom)
        ToolbarUitls.updateToolbarVisibility(toolbar, true)

        return loginView
    }

    override fun onStart() {
        super.onStart()

        val loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener {
            loginViewModel.saveUserName(txtUserName.text.toString())
            var action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            loginView.findNavController().navigate(action)
        }
    }
}