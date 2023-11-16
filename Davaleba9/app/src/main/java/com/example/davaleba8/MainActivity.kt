package com.example.davaleba8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.davaleba8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EquipmentRecyclerAdapter
    private var filtered = mutableListOf<Equipment>()
    private var equipment = mutableListOf<Equipment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val categories = listOf(
            binding.btnAll,
            binding.btnParty,
            binding.btnCamping,
            binding.btnCategory1,
            binding.btnCategory2,
            binding.btnCategory3
        )

        for (category in categories){
           category.setOnClickListener{
                updateRecView(category.text.toString())
            }
        }
        setUp()
        setUpEquipmentRecycler()

    }

    private fun updateRecView(category: String){
        filtered.clear()

        if(category == "All"){
            filtered.addAll(equipment)
        } else {
            for (item in equipment) {
                if (item.category == category) {
                    filtered.add(item)
                }
            }
        }
        adapter.submitList(filtered)
    }

    private fun setUp(){
        setEquipmentsData()
    }

    private fun setUpEquipmentRecycler(){
        adapter = EquipmentRecyclerAdapter(equipment)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter
    }


    private fun setEquipmentsData() {
        equipment.also {
            it.add(
                Equipment(
                    R.drawable.girl_back,
                    "Belt suit blazer",
                    156,
                    "Camping"
                )
            )
            it.add(
                Equipment(
                    R.drawable.girl2,
                    "Belt suit blazer",
                    221,
                    "Category1"
                )
            )
            it.add(
                Equipment(
                    R.drawable.girl3,
                    "Belt suit blazer",
                    1100,
                    "Category2"
                )
            )

            it.add(
                Equipment(
                    R.drawable.girl4,
                    "Belt suit blazer",
                    10230,
                    "Category3"
                )
            )
            it.add(
                Equipment(
                    R.drawable.girl4,
                    "Belt suit blazer",
                    104440,
                    "Category3"
                )
            )

            it.add(
                Equipment(
                    R.drawable.girl4,
                    "Belt suit blazer",
                    1023230,
                    "Category3"
                )
            )
        }
    }


}