package com.example.mehmet_sevim_odev4.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mehmet_sevim_odev4.R
import com.example.mehmet_sevim_odev4.databinding.FragmentLetsGoBinding


class LetsGoFragment : Fragment() {
    private lateinit var fragmentLetsGoBinding: FragmentLetsGoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLetsGoBinding = FragmentLetsGoBinding.inflate(inflater)
        return fragmentLetsGoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goNextFragment()
    }

    /**
     *Bir sonraki Fragment'a yönlendiren fonksiyon
     */
    private fun goNextFragment() {
        fragmentLetsGoBinding.apply {
            LetsGoScreenLetsButton.setOnClickListener {
                findNavController().navigate(R.id.action_letsGoFragment_to_menuFragment)
            }
        }
    }
}

