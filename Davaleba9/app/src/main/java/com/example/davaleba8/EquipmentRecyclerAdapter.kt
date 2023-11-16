package com.example.davaleba8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.davaleba8.databinding.ItemRecyclerviewBinding

class EquipmentRecyclerAdapter(private val equipments: MutableList<Equipment>):RecyclerView.Adapter<EquipmentRecyclerAdapter.EquipmentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentViewHolder {
      return EquipmentViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return equipments.size
    }

    fun submitList(newList: List<Equipment>) {
        equipments.clear()
        equipments.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: EquipmentViewHolder, position: Int) {
        val equipment = equipments[position]
        holder.binding.ivGirl.setImageResource(equipment.image)
        holder.binding.tvNameText.text = equipment.title
        holder.binding.tvPrice.text = equipment.price.toString()
        holder.binding.cardView

    }


    inner class EquipmentViewHolder( val binding:ItemRecyclerviewBinding ):RecyclerView.ViewHolder(binding.root){

    }
}