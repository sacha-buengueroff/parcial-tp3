package com.example.parcialtp3.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.viewmodel.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var navHostController: NavController
    private lateinit var bottomNavView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Busqueda de elementos de la vista
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navHostController = navHostFragment.navController
        bottomNavView = findViewById(R.id.bottom_bar)

        //Set up custom tool bar
        var toolbar = findViewById<Toolbar>(R.id.toolbar_custom)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //Set up Nav Header
        setupNavHeader()

        //Set up buttom navigation bar
        NavigationUI.setupWithNavController(bottomNavView, navHostController)

        //Set up Drawer Layout menu
        setupDrawerLayout()


    }

    private fun setupNavHeader() {
        val userNameTextView =
            navigationView.getHeaderView(0).findViewById<TextView>(R.id.txt_UserName)
        var loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel.userName.observe(this) { result ->
            userNameTextView.text = result.toString()
        }
    }


    private fun setupDrawerLayout() {
        navigationView.setupWithNavController(navHostController)

        NavigationUI.setupActionBarWithNavController(this, navHostController, drawerLayout)

        navHostController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.setHomeAsUpIndicator(R.drawable.menu)
        }
        setToolBarVisibility()
    }

    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return false
    }

    fun setToolBarVisibility () {
        navHostController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.loginFragment) {
                supportActionBar?.hide()
                bottomNavView.visibility = View.GONE
            } else {
                supportActionBar?.show()
                bottomNavView.visibility = View.VISIBLE
            }
        }
    }
}