package org.d3if0054.assesment1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if0054.assesment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fpbButton.setOnClickListener{(hitungFpb())}
        binding.kpkButton.setOnClickListener{(hitungKpk())}
    }

    private fun hitungKpk(){
        //mengambil angka dari inputan user
        val angkaSatu = binding.angkaSatuText.text.toString()
        if(TextUtils.isEmpty(angkaSatu)){
            Toast.makeText(this,R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val angkaDua = binding.angkaDuaText.text.toString()
        if(TextUtils.isEmpty(angkaDua)){
            Toast.makeText(this,R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return

        }


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
        if(TextUtils.isEmpty(angkaSatu)){
            Toast.makeText(this,R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val angkaDua = binding.angkaDuaText.text.toString()
        if(TextUtils.isEmpty(angkaDua)){
            Toast.makeText(this,R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }


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
        binding.hasilTextView.text = getString(R.string.hasilText_fpb,finalSum)

    }
}