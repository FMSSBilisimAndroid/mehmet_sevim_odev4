package com.example.mehmet_sevim_odev4.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_odev4.BR
import com.example.mehmet_sevim_odev4.adapter.PlanetsAdapter
import com.example.mehmet_sevim_odev4.models.PlanetsModel
import com.example.mehmet_sevim_odev4.SpacesItemDecoration
import com.example.mehmet_sevim_odev4.data.remote.PlanetsApi
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
        fragmentMenuBinding = FragmentMenuBinding.inflate(inflater)


        return fragmentMenuBinding.root
    }

    /**
     * View oluştuktan sonra getAllDataFromApi fonksiyonunu çalıştırıyoruz
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllDataFromApi()
    }

    /**
     *Api den gelen veriyi alıp adapter değişkeni içerisine gönderiyoruz
     */

    private fun getAllDataFromApi() {
        PlanetsApi.retrofitService.getProperties().enqueue(object : Callback<List<PlanetsModel>> {
            override fun onResponse(
                call: Call<List<PlanetsModel>>,
                response: Response<List<PlanetsModel>>
            ) {
                val adapter = PlanetsAdapter(response.body()!!) {
                    /**
                     * gelen veriyi tıklanıldığında details sayfasına gönderecek fonksiyonu çağırıyoruz
                     */
                    sendDataDetailFragment(it)
                }
                setMenuFragmentRecyclerview(adapter)

            }

            override fun onFailure(call: Call<List<PlanetsModel>>, t: Throwable) {

            }
        })
    }

    /**
     * @param planetsModel PlanetsModel türünde gelen datayı detail ekranına gönderiyoruz
     */
    private fun sendDataDetailFragment(planetsModel: PlanetsModel) {
        val planetsDetailActions =
            MenuFragmentDirections.actionMenuFragmentToDetailFragment(planetsDetails = planetsModel)
        findNavController().navigate(planetsDetailActions)
    }

    /**
     * TODO
     *
     * @param adapter PlanetsAdapter türünde gelen veriyi Menu Fragment içerisine gönderiyoruz
     * Recyclerview ayarlarını yapıyoruz
     */
    private fun setMenuFragmentRecyclerview(adapter: PlanetsAdapter) {
        val gridLayoutManager = GridLayoutManager(context, 2)
        fragmentMenuBinding.apply {
            with(MenuScreenRecyclerView) {
                layoutManager = gridLayoutManager
                addItemDecoration(SpacesItemDecoration(15))
            }

            setVariable(BR.adapter, adapter)
        }
    }


}