package org.d3if0054.assesment1.activity

import android.R
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import org.d3if0054.assesment1.databinding.ActivityMainBinding
import org.d3if0054.assesment1.perhitungan.HitungActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.perhitunganBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,HitungActivity::class.java)
            startActivity(intent)

        }

        binding.postBtn.setOnClickListener{
            val intent = Intent(applicationContext,MovieActivity::class.java)
            startActivity(intent)
        }

        val intent = Intent(this, MainActivity::class.java)
        val contentIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val b = NotificationCompat.Builder(this)

        b.setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_ALL)
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.drawable.ic_dialog_info)
            .setTicker("Hearty365")
            .setContentTitle("Default notification")
            .setContentText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
            .setDefaults(Notification.DEFAULT_LIGHTS or Notification.DEFAULT_SOUND)
            .setContentIntent(contentIntent)
            .setContentInfo("Info")


        val notificationManager = this.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, b.build())

    }





}