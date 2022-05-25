package org.d3if0054.assesment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.d3if0054.assesment1.databinding.FragmentFaktorisasiBinding


class HitungFaktorFragment: Fragment(R.layout.fragment_faktorisasi) {
    private lateinit var binding: FragmentFaktorisasiBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        binding = FragmentFaktorisasiBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.faktorisasiBtn.setOnClickListener { (hitungFaktor()) }

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = FragmentHitungkpkBinding.inflate(layoutInflater)
//
//
//        binding.fpbButton.setOnClickListener{(hitungFpb())}
//        binding.kpkButton.setOnClickListener{(hitungKpk())}
//    }


    private fun hitungFaktor(){


        var result: Int = 1

        val angkaSatu = binding.angkaSatuText.text.toString()
        val first = angkaSatu.toInt()



        if (first <= 0){
            return

        } else {
            for (i in 1..first) {
                result *= i
            }
            val finalSum = result.toString()
            binding.hasilTextView.text = getString(R.string.hasilText_fpb,finalSum)
        }
    }

}