package com.example.simpsonfrases.views.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simpsonfrases.R
import com.example.simpsonfrases.models.PersonajesSimpsons
import com.google.android.material.bottomsheet.BottomSheetDialog

class PersonajeAdapter (
    val context: Context,
    var listaPersonajes: List<PersonajesSimpsons>
): RecyclerView.Adapter<PersonajeAdapter.ViewHolder>() {
    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        val cvPersonaje= item.findViewById(R.id.cvPersonaje) as CardView
        val ivPersonaje = item.findViewById(R.id.iv_Personaje) as ImageView
        val tvnombrePersonaje = item.findViewById(R.id.tvNombrePersonaje) as TextView

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_personaje, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personaje = listaPersonajes[position]

        Glide
            .with(context)
            .load(personaje.image)
            .centerInside()
            .into(holder.ivPersonaje)

        holder.tvnombrePersonaje.text = personaje.character

        holder.cvPersonaje.setOnClickListener{
            mostrarFrase(personaje.quote)
        }
    }



    override fun getItemCount(): Int {
        return listaPersonajes.size
    }

    private fun mostrarFrase(quote: String) {
        val frase = BottomSheetDialog(context)
        frase.setContentView(R.layout.frase_personaje)

        val tvFrase = frase.findViewById<TextView>(R.id.tvFrase)

        tvFrase!!.text = quote
        frase.show()
    }



}