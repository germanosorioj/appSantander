package com.fastandroid.ecosantander.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
//import android.view.LayoutInflater
import com.fastandroid.ecosantander.R
import com.fastandroid.ecosantander.databinding.ActivityDetalleBinding
import com.fastandroid.ecosantander.model.LugarTuristicoItem
import com.squareup.picasso.Picasso
import java.io.Serializable

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val lugarTuristico: LugarTuristicoItem = intent.extras?.getSerializable("lugarTuristico") as LugarTuristicoItem
        with(detalleBinding){
            nameTextView.text = lugarTuristico.name
            descriptionTextView.text = lugarTuristico.description
           Picasso.get().load(lugarTuristico.urlPicture).into(pictureImageView)
        }
    }


}