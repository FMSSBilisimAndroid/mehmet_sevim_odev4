package com.example.mehmet_sevim_odev4.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_odev4.R
import com.example.mehmet_sevim_odev4.model.PlanetsModel

class PlanetsAdapter (private val list: List<PlanetsModel>,
                      private val onItemClickHandler: (planetsModel: PlanetsModel) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val planetsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.menu_recycler_item,parent,false
        )

        return PlanetsViewHolder(planetsBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlanetsViewHolder).onBind(list.get(position),onItemClickHandler)


    }

    override fun getItemCount(): Int {
        return list.size
    }




}