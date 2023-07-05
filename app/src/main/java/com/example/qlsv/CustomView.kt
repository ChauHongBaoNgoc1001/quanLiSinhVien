package com.example.qlsv

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.provider.MediaStore.Audio.Radio
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.newFixedThreadPoolContext

class CustomListAdapter(context: Context, private val resource: Int, private val items:  MutableList<Item>) :
    ArrayAdapter<Item>(context, resource, items) {

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(resource, null)


        val item: Item = items[position]
        val img: ImageView = view.findViewById(R.id.img)
        val nu:String = "Nữ"

        if(item.Gioitinh == nu){
            img.setImageResource(R.drawable.nu)
        }
        else{  img.setImageResource(R.drawable.nam)}


        var ma: TextView = view.findViewById(R.id.ma)
        ma.text = item.ma

        var ten: TextView = view.findViewById(R.id.ten)
        ten.text =item.ten

        var GioiTinh:TextView = view.findViewById(R.id.Gioitinh)
        GioiTinh.text = item.Gioitinh



            val Sua:ImageView = view.findViewById(R.id.sua)
            Sua.setOnClickListener {
            // Tạo layout hiển thị DIALOG.XML

            // Tạo dialog để gán với layout

            val builder = AlertDialog.Builder(context)

            // Thành lập dialog
            // Bước 1 Tạo layout
            val inflater = (context as Activity).layoutInflater
            val view = inflater.inflate(R.layout.dialog, null)
            builder.setView(view)

            // Bước 2 - Ánh xạ
            val Ten = view.findViewById<EditText>(R.id.ht)
            val mssv = view.findViewById<EditText>(R.id.ms)
             val gioiTinh = view.findViewById<EditText>(R.id.gt)

            // Bước 3 -Set tiêu đề
            builder.setTitle("  UPDATE FORM  ")

            // Bước 4  Xử lý button cập nhật
            builder.setPositiveButton("CẬP NHẬT") { dialog, which ->
                // Lấy về dữ liệu nhập vào dialog
                val Ma = mssv.text.toString()
                val Ten = Ten.text.toString()
                val Gioi = gioiTinh.text.toString()
//                Cập nhật vào list
                items[position].ma = Ma
                items[position].ten = Ten
                items[position].Gioitinh = Gioi
            }

            // Tạo AlertDialog
            val alertDialog = builder.create()
            alertDialog.show()
        }

        val Xoa:ImageView = view.findViewById(R.id.xoa)
        Xoa.setOnClickListener {
            items.removeAt(position)// xóa item tại vị trí đó
            notifyDataSetChanged()// cập nhật lại listView
        }

        return view

    }
}
