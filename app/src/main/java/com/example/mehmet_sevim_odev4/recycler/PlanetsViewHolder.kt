package com.example.mehmet_sevim_odev4.recycler

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_odev4.BR
import com.example.mehmet_sevim_odev4.databinding.MenuRecyclerItemBinding
import com.example.mehmet_sevim_odev4.PlanetsModel
import com.squareup.picasso.Picasso

class PlanetsViewHolder (
    val planetsBinding: ViewDataBinding,
): RecyclerView.ViewHolder(planetsBinding.root) {

    fun onBind(planetsModel: PlanetsModel, onItemClickHandler: (planetsModel: PlanetsModel) -> Unit) {
        val planetsBind = planetsBinding as MenuRecyclerItemBinding
        planetsBind.apply {
            root.setOnClickListener{onItemClickHandler(planetsModel)}
            setVariable(BR.planetsModel,planetsModel)
            setImageFromApi(planetsModel.img_src,imageView)

        }

    }

    /**
     * @param imgSourceUrl string image url from api
     * @param imageView  ImageView from menu_recyler_item layout
     * set url to image by using picasso
     */
    fun setImageFromApi(imgSourceUrl:String,imageView:ImageView){
        Picasso.get()
            .load(imgSourceUrl)
            .resize(100, 100)
            .centerCrop()
            .into(imageView);
    }

}