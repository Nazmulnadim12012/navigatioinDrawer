package com.example.navigationdrawernd

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var buttonDrawerToggle: ImageButton
    lateinit var navigationView: NavigationView
    lateinit var headerView : View
    lateinit var btnTl : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        drawerLayout = findViewById(R.id.main)
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle)
        navigationView = findViewById(R.id.navigationView)

        headerView = navigationView.getHeaderView(0)
        val headerImage =headerView.findViewById<ImageView>(R.id.header_image)
        val headerUser = headerView.findViewById<TextView>(R.id.header_user_name)

        btnTl = findViewById(R.id.btnTableLayoutId)
        btnTl.setOnClickListener {
            val intent = Intent(this,TabelLayoutActivity::class.java)
            startActivity(intent)
        }

        headerImage.setOnClickListener {
            Toast.makeText(this,headerUser.text,Toast.LENGTH_SHORT).show()
            drawerLayout.close()
        }



        buttonDrawerToggle.setOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.home ->{
                    Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                }

                R.id.message -> {
                    Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                }

                R.id.sync -> {
                    Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                }

                R.id.settings -> {
                    Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                }

                R.id.rateUs -> {
                    Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                }
            }
            false

        }



    }
}