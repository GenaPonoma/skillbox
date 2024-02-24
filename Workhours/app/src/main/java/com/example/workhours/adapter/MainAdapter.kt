package com.example.workhours.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workhours.databinding.MyListViewAdpterBinding

class MainAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MyListViewAdpterBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val valies = values[position]
        holder.binding.textView.text = valies
    }

    override fun getItemCount(): Int = values.size
}


class MyViewHolder(val binding: MyListViewAdpterBinding) : RecyclerView.ViewHolder(binding.root) {

}