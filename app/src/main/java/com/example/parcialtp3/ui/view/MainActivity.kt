package com.example.parcialtp3.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.parcialtp3.R
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var bottomNavView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        bottomNavView = findViewById(R.id.bottom_bar)

        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)
        setupDrawerLayout()
    }
    private fun setupDrawerLayout() {

        val navController = navHostFragment.navController
        navigationView.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        navController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.setHomeAsUpIndicator(R.drawable.menu)
        }

        setToolBarVisibility(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return false
    }

    fun setToolBarVisibility (navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
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