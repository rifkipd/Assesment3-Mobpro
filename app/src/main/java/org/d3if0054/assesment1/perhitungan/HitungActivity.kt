package org.d3if0054.assesment1.perhitungan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.d3if0054.assesment1.R
import org.d3if0054.assesment1.databinding.ActivityHitungBinding


class HitungActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHitungBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHitungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goBtn1.setOnClickListener {
            replaceFragment(HitungFaktorFragment())
        }

        binding.goBtn2.setOnClickListener {
            replaceFragment(HitungFragment())
        }

        binding.goBtn3.setOnClickListener {
            replaceFragment(HitungPrimaFragment())
        }


    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}