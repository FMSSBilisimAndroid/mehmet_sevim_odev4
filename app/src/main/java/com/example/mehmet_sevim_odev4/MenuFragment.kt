package com.example.mehmet_sevim_odev4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_odev4.databinding.FragmentMenuBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuFragment : Fragment() {
private lateinit var fragmentMenuBinding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMenuBinding=FragmentMenuBinding.inflate(inflater)


        return fragmentMenuBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PlanetsApi.retrofitService.getProperties().enqueue(object : Callback<List<PlanetsModel>>{
            override fun onResponse(call: Call<List<PlanetsModel>>,response: Response<List<PlanetsModel>>){
                response.body()?.let {
                    Log.v("PATIKA", "${it.toString()}")
                }
                val adapter = PlanetsAdapter(response.body()!!) { item ->
                    Log.v("PATIKA", "${item.id.toString()} - ${item.price.toString()}")
                }
                val gridLayoutManager=GridLayoutManager(context,2)
                fragmentMenuBinding.apply {
                    recyclerView.layoutManager = gridLayoutManager
                    setVariable(BR.adapter,adapter)
                }


            }

            override fun onFailure(call: Call<List<PlanetsModel>>, t: Throwable) {

            }
        })
        val menuItemlist = listOf(
            PlanetsModel(12345,"12","buy","12"),

        )
        val adapter = PlanetsAdapter(menuItemlist) { item ->
            Log.v("PATIKA", "${item.id.toString()} - ${item.price.toString()}")
        }
        val gridLayoutManager=GridLayoutManager(context,2)
        fragmentMenuBinding.apply {
            recyclerView.layoutManager = gridLayoutManager
            setVariable(BR.adapter,adapter)
        }


    }





}