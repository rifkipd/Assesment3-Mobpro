package org.d3if0054.assesment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0054.assesment1.databinding.FragmentHitungkpkBinding
import org.d3if0054.assesment1.databinding.FragmentPrimaBinding

class HitungPrimaFragment: Fragment(R.layout.fragment_prima) {
    private lateinit var binding: FragmentPrimaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        binding = FragmentPrimaBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.primaBtn.setOnClickListener { (hitungPrima()) }

    }


    private fun hitungPrima(){
        val num = binding.angkaSatuText.text.toString()
        val number = num.toInt()

        val prime = "is Prime Number"
        val notPrime="Is not Prime Number"


        for (i in 2..number / 2) {
            // condition for nonprime number
            if (number % i == 0) {

                val finalSum = number.toString()
                binding.hasilTextView.text = getString(R.string.hasilText_Prima,notPrime)
                break
            }
            binding.hasilTextView.text = getString(R.string.hasilText_Prima,prime)
        }


    }
}