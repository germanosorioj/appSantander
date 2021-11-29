package com.fastandroid.ecosantander

import android.util.Half.toFloat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class LugaresAdapter(
    private val lugareslist: ArrayList<LugarTuristicoItem>
) : RecyclerView.Adapter<LugaresAdapter.LugarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_lugar_item,parent,false)
        return LugarViewHolder(view)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugarturistico = lugareslist[position]
        holder.bind(lugarturistico)
    }

    override fun getItemCount(): Int = lugareslist.size

    class LugarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var nameTextView: TextView = itemView.findViewById(R.id.name_textView)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.description_textView)
        private var punctuationRatingBar: RatingBar = itemView.findViewById(R.id.punctuationRatingBar)
       private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(lugarturistico: LugarTuristicoItem){
            nameTextView.text = lugarturistico.name
            descriptionTextView.text = lugarturistico.description
            Picasso.get().load(lugarturistico.urlPicture).into(pictureImageView)
            punctuationRatingBar.rating = lugarturistico.punctuation.toFloat()
        }
    }

}