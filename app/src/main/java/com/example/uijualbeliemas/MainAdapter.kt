package com.example.uijualbeliemas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uijualbeliemas.databinding.ItemListBinding

class MainAdapter(val list: ArrayList<Catalog>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class MainViewHolder(itemView: View, private val listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        fun bind(data: Catalog) {
            binding.tvJudul.text = data.judul
            binding.tvTerjual.text = data.terjual
            binding.tvHarga.text = data.harga
            binding.mainImg.setImageResource(data.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MainViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
