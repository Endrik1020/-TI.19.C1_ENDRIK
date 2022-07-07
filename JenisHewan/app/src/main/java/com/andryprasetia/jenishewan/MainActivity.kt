package com.andryprasetia.jenishewan

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.andryprasetia.jenishewan.adapter.AdapterHewan
import com.andryprasetia.jenishewan.databinding.ActivityMainBinding
import com.andryprasetia.jenishewan.model.Hewan

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listHewan = ArrayList<Hewan>()
        listHewan.add(Hewan("Rubah",R.drawable.rubah,"Karnivora","Vivipar"))
        listHewan.add(Hewan("Singa",R.drawable.singa,"Karnivora","Vivipar"))
        listHewan.add(Hewan("Kelinci",R.drawable.kelinci,"Herbivora","Vivipar"))
        listHewan.add(Hewan("Beruang",R.drawable.beruang,"Karnivora","Vivipar"))
        listHewan.add(Hewan("Anjing",R.drawable.anjing,"Karnivora","Vivipar"))

        binding.list.adapter = AdapterHewan(this,listHewan,object :AdapterHewan.OnClickListener {
            override fun detailData(item: Hewan?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_hewan)

                    val image = this.findViewById<ImageView>(R.id.image_hewan)
                    val nama = this.findViewById<TextView>(R.id.txtNamaHewan)
                    val makanan = this.findViewById<TextView>(R.id.txtNamaMakanan)
                    val berkembang = this.findViewById<TextView>(R.id.txtNamaBerkembang)
                    val btn = this.findViewById<TextView>(R.id.btnclose)

                    image.setImageResource(item?.foto ?: 0)
                    nama.text = "${item?.nama}"
                    makanan.text = "${item?.makanan}"
                    berkembang.text = "${item?.berkembang}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode : Int) {
        when (selectedMode) {
            R.id.myprofile ->{
                val intent = Intent(this,Profile::class.java)
                startActivity(intent)
            }
        }
    }
}
