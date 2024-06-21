package com.example.wirawicara.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.wirawicara.R
import com.example.wirawicara.databinding.ActivityMainBinding
import com.example.wirawicara.ui.view.HomeFragment
import com.example.wirawicara.ui.view.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var fragmentHome: HomeFragment? = null
    private lateinit var startResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentProfile = ProfileFragment()
        fragmentHome = HomeFragment()
        switchFragment(fragmentHome!!)

        startResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // fragmentHome?.onRefresh()
            }
        }

        binding.bottomNavigationView.background = null // sembunyikan lapisan abnormal di bottom nav

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    switchFragment(fragmentHome!!)
                    true
                }
                // Tambahkan logika untuk item navigasi lainnya jika diperlukan
                else -> false
            }
        }
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
