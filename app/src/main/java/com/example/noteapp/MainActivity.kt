package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val fm = supportFragmentManager
        var f = fm.findFragmentById(R.id.fragment_container)
        if (f == null) {
            f = MainFragment.newInstance()
            fm.apply {
                beginTransaction()
                    .add(R.id.fragment_container, f)
                    .commit()
            }
        }

        val res = resources
        supportActionBar?.apply {
            title = res.getString(R.string.actionbar_title)
        } ?: ""*/

        val navController = findNavController(this, R.id.nav_host_fragment)
        appBarConfig = AppBarConfiguration.Builder().build()
        setupActionBarWithNavController(this, navController, appBarConfig)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val enabled = destination.id != R.id.mainFragment
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(enabled)
                setDisplayShowHomeEnabled(enabled)
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(this, R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
