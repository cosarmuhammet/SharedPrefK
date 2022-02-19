package com.example.sharedprefk

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

val dosya_yolu = "com.example.sharedprefk"
val anahtar_isim = "isim"
val anahtar_yas = "yas"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var kaydet = findViewById<Button>(R.id.kaydet)
        var sil = findViewById<Button>(R.id.sil)
        var isim = findViewById<EditText>(R.id.isim)
        var yas = findViewById<EditText>(R.id.yas)
        var tutucu = getSharedPreferences(dosya_yolu , Context.MODE_PRIVATE) //ÖNEMLİ !
        var tutucuedit = tutucu.edit()

        Toast.makeText(applicationContext ,
            "İsim : ${tutucu.getString(anahtar_isim, "Deger yok")} \n" +
                    "Yas : ${tutucu.getInt(anahtar_yas , 0)} \n" ,Toast.LENGTH_LONG).show()


        kaydet.setOnClickListener {
            tutucuedit
                .putString(anahtar_isim, isim.text.toString())  //ÖNEMLİ !
                .putInt(anahtar_yas, yas.text.toString().toInt()) //ÖNEMLİ !
                .apply() //ÖNEMLİ !
            Toast.makeText(applicationContext,"Kayıt başarılı",Toast.LENGTH_SHORT).show()
        }
        sil.setOnClickListener {
            tutucuedit
                .remove(anahtar_isim)
                .remove(anahtar_yas)
                .apply()
            Toast.makeText(applicationContext,"Silme işlemi başarılı",Toast.LENGTH_SHORT).show()
        }



    }
    /*override fun onstart() {
        super.onStart()
        println("Onstart çağırıldı")
    }
    override fun onResume() {
        super.onResume()
        println("OnResume çağırıldı")
    }
    override fun onPause() {
        super.onPause()
        println("OnPause çağırıldı")
    }
    override fun onstop() {
        super.onStop()
        println("OnStop çağırıldı")
    }
    override fun onRestart() {
        super.onRestart()
        println("OnRestart çağırıldı")
    }
    override fun onDestroy() {
        super.onDestroy()
        println("OnDestroy çağırıldı")
    }*/


}