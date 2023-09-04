package com.yuu.com

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(private val comiclist: ArrayList<comics>, private val context: Context) : RecyclerView.Adapter<adapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, overview, foto) = comiclist[position]
        holder.imgFoto.setImageResource(foto)
        holder.titleTV.text = title
        holder.overviewTV.text = overview

        holder.itemView.setOnClickListener {
            val move = Intent(context, detail::class.java)
            move.putExtra("comic", comiclist[position])
            context.startActivity(move)
        }
    }

    override fun getItemCount(): Int = comiclist.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFoto: ImageView = itemView.findViewById(R.id.recImage)
        val titleTV: TextView = itemView.findViewById(R.id.recTitle)
        val overviewTV: TextView = itemView.findViewById(R.id.recOverview)
    }
}