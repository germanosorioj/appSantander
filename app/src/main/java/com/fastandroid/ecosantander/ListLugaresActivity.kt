package com.fastandroid.ecosantander

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        
        
        lugaresAdapter = LugaresAdapter(listaLugares)

        lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockLugaresFromJson(): ArrayList<LugarTuristicoItem> {
        val lugaresString: String = applicationContext.assets.open("lugares.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val data = gson.fromJson(lugaresString, LugarTuristico::class.java)
        return data
    }

    /*private fun createMockLugares() : ArrayList<LugarTuristico>{
        return arrayListOf(
            LugarTuristico(
                name = "Santurban",
                description = "El Paramo Santurban es un macizo montañoso considerado monumento nacional desde 1975",
               punctuation = 4.0F,
               urlPicture = "https://res.cloudinary.com/dtg3eecnd/image/upload/v1637528476/santurban_pmqc73.jpg"
            ),
            LugarTuristico(
                name = "Barichara",
                description = "Pueblo monumento nacional desde 1975, uno de los pueblos mas bellos de Colombia.",
                punctuation = 3F,
                urlPicture = "https://res.cloudinary.com/dtg3eecnd/image/upload/v1637503550/barichara_vh3ve2.jpg"
            ),
            LugarTuristico(
                name = "CerrodelSantisimo",
                description = "Ecoparque ubicado en la Vereda Helechales, sector rural de Floridablanca (Santander), conocido por poseer una escultura de Jesus de Nazaret de 35 m de alto",
                punctuation = 5.0F,
                urlPicture = "https://res.cloudinary.com/dtg3eecnd/image/upload/v1637528476/cerrosantisimo_jelga4.jpg"
            )
        )
    } */

}