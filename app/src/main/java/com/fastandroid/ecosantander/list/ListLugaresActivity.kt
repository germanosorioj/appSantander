package com.fastandroid.ecosantander.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastandroid.ecosantander.R
import com.fastandroid.ecosantander.detalle.DetalleActivity
import com.fastandroid.ecosantander.model.LugarTuristico
import com.fastandroid.ecosantander.model.LugarTuristicoItem
import com.google.gson.Gson

class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listaLugares: ArrayList<LugarTuristicoItem>
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var lugaresRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        lugaresRecyclerView = findViewById(R.id.lugares_recyclerview)

        //listaLugares = createMockLugares()
        listaLugares = loadMockLugaresFromJson()
        
        
        lugaresAdapter = LugaresAdapter(listaLugares,onItemClicked = {onLugaresClicked(it)})

        lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun onLugaresClicked(lugarTuristico: LugarTuristicoItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("lugarTuristico",lugarTuristico)
        startActivity(intent)

    }

    private fun loadMockLugaresFromJson(): ArrayList<LugarTuristicoItem> {
        val lugaresString: String = applicationContext.assets.open("lugares.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val data = gson.fromJson(lugaresString, LugarTuristico::class.java)
        return data
    }


}