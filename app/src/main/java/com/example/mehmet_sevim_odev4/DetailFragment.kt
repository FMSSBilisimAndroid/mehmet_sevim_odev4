package com.example.mehmet_sevim_odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mehmet_sevim_odev4.databinding.FragmentDetailBinding
import com.example.mehmet_sevim_odev4.databinding.FragmentLetsGoBinding


class DetailFragment : Fragment() {

    private lateinit var fragmentDetailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentDetailBinding = FragmentDetailBinding.inflate(inflater)
        return fragmentDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val price = args.planetsDetails.price
        fragmentDetailBinding.apply {
            textView2.text="${price.toString()}"
        }
    }


}