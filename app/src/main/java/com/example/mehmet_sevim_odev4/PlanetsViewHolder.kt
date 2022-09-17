package com.example.mehmet_sevim_odev4

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_odev4.databinding.MenuRecyclerItemBinding

class PlanetsViewHolder (
    val planetsBinding: ViewDataBinding,
): RecyclerView.ViewHolder(planetsBinding.root) {

    fun onBind(planetsModel: PlanetsModel, onItemClickHandler: (planetsModel: PlanetsModel) -> Unit) {
        val binding = planetsBinding as MenuRecyclerItemBinding
        binding.apply {
            root.setOnClickListener{onItemClickHandler(planetsModel)}
            val planetsModelClicked = PlanetsModel(123,"123","0","123")
            textView.setOnClickListener { onItemClickHandler(planetsModelClicked) }
            setVariable(BR.planetsModel,planetsModel)
        }

    }

}