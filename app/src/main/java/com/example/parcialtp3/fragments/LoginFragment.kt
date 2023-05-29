package com.example.parcialtp3.fragments

import android.content.Context
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.viewmodel.LoginViewModel
import com.example.parcialtp3.utils.ToolbarUitls

class LoginFragment : Fragment() {

    lateinit var loginView : View
    lateinit var txtUserName : TextView
    lateinit var txtPass: TextView
    lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginView =  inflater.inflate(R.layout.login_fragment, container, false)

        txtUserName = loginView.findViewById<TextView>(R.id.txt_UserName)
        txtPass = loginView.findViewById<TextView>(R.id.txt_Password)
        txtPass.transformationMethod = PasswordTransformationMethod.getInstance()
        btnLogin = loginView.findViewById<Button>(R.id.btnLogin)
        var toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar_custom)
        ToolbarUitls.updateToolbarVisibility(toolbar, true)

        return loginView
    }

    override fun onStart() {
        super.onStart()

        val loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener {
            try {
                loginViewModel.saveUserName(txtUserName.text.toString())
                loginViewModel.savePass(txtPass.text.toString())
                var action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                loginView.findNavController().navigate(action)
            } catch (error: IllegalArgumentException){
                loginError(requireContext(), error.message)
            }
        }
    }

    private fun loginError(context: Context, errorMessage: String?) {
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("Error")
            .setMessage(errorMessage)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
    }
}