package com.example.qlsv

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var customListAdapter: CustomListAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var Msv: EditText = findViewById(R.id.maSV)
        var Ten: EditText = findViewById(R.id.hoten)
        val Nhap = findViewById<Button>(R.id.nhap)
        var nam=findViewById<RadioButton>(R.id.nam)
        var nu=findViewById<RadioButton>(R.id.nu)
        var Gt = findViewById<RadioGroup>(R.id.RDGroup)

        var DanhSach=findViewById<ListView>(R.id.listView)

        var Sua = findViewById<ImageView>(R.id.sua)
        var Xoa = findViewById<ImageView>(R.id.xoa)


        var danhsach:MutableList<Item> = mutableListOf()
        var adapter:CustomListAdapter = CustomListAdapter(this, R.layout.layouitem, danhsach)

        DanhSach.adapter = adapter



        Nhap.setOnClickListener{

            val ma = Msv.text.toString()
            val ten = Ten.text.toString()
            val Gioitinh = if (nam.isChecked) "Nam" else "Nữ"

            val userInfo = Item(   ma, ten, Gioitinh  )

            danhsach.add(userInfo)
            adapter.notifyDataSetChanged()// cập nhật lại listview

            Msv.text.clear()
            Ten.text.clear()
            Gt.clearCheck()
        }



    }
}

