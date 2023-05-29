package com.example.parcialtp3.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import com.example.parcialtp3.R
import com.google.android.material.bottomnavigation.BottomNavigationView

object ToolbarUitls {
    fun updateToolbarVisibility(toolbar: Toolbar, isConfigVisible: Boolean) {
        val premierTextView = toolbar.findViewById<TextView>(R.id.toolbar_txtPremier)
        val rentcarTextView = toolbar.findViewById<TextView>(R.id.toolbar_txtRentcar)
        val configTextView = toolbar.findViewById<TextView>(R.id.txt_configuracion)

        configTextView.visibility = if (isConfigVisible) View.VISIBLE else View.GONE
        premierTextView.visibility = if (!isConfigVisible) View.VISIBLE else View.GONE
        rentcarTextView.visibility = if (!isConfigVisible) View.VISIBLE else View.GONE

    }

    fun setToolBarVisibility(
        navHostController: NavController,
        supportActionBar: ActionBar?,
        bottomNavView: BottomNavigationView
    ) {
        navHostController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment) {
                supportActionBar?.hide()
                bottomNavView.visibility = View.GONE
            } else {
                supportActionBar?.show()
                bottomNavView.visibility = View.VISIBLE
            }
        }
    }
}