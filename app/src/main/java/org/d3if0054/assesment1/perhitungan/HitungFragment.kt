package org.d3if0054.assesment1.perhitungan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0054.assesment1.R
import org.d3if0054.assesment1.databinding.FragmentHitungkpkBinding

class HitungFragment:Fragment(R.layout.fragment_hitungkpk) {
    private lateinit var binding: FragmentHitungkpkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        binding = FragmentHitungkpkBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fpbButton.setOnClickListener { (hitungFpb()) }
        binding.kpkButton.setOnClickListener { (hitungKpk()) }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = FragmentHitungkpkBinding.inflate(layoutInflater)
//
//
//        binding.fpbButton.setOnClickListener{(hitungFpb())}
//        binding.kpkButton.setOnClickListener{(hitungKpk())}
//    }

    private fun hitungKpk(){
        //mengambil angka dari inputan user
        val angkaSatu = binding.angkaSatuText.text.toString()

        val angkaDua = binding.angkaDuaText.text.toString()



        //merubah angka menjadi int
        val first = angkaSatu.toInt()
        val second = angkaDua.toInt()

        //pengecekan angka ke 1 dan ke 2 yang akan dimasukan kedalam variable kpk
        var kpk = if(first > second)
            first
        else
            second


        //proses perhitungan untuk mencari nilai kpk
        while (true) {
            if ((kpk % first == 0) && (kpk % second == 0)) {
                val finalSum = kpk.toString()
                binding.hasilTextView.text = getString(R.string.hasilText_kpk,finalSum)
                break
            }
            ++kpk
        }

    }

    private fun hitungFpb(){
        //mengambil angka dari yg di inputkan user
        val angkaSatu = binding.angkaSatuText.text.toString()

        val angkaDua = binding.angkaDuaText.text.toString()



        //angka di rubah dari string ke int
        var first = angkaSatu.toInt()
        var second = angkaDua.toInt()


        //proses perhitungan untuk mencari nilai FPB
        while (first != second){
            if (first > second) {
                first -= second
            }else{
                second -= first
            }
        }

        //hasil di rubah lagi menjadi string
        val finalSum = first.toString()
        binding.hasilTextView.text = getString(R.string.hasilText_faktor,finalSum)

    }
}