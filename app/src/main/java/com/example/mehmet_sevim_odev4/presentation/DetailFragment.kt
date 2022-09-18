package com.example.mehmet_sevim_odev4.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mehmet_sevim_odev4.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


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
        val id = args.planetsDetails.id
        val type = args.planetsDetails.type
        val img_url = args.planetsDetails.img_src
        fragmentDetailBinding.apply {
            button3.text = "${type.toString()}"
            textView2.text = "${price.toString()}"
            textView3.text = "${id.toString()}"

            setImageFromClick(img_url, imageView3)

            imageButton.setOnClickListener {
                goBackFragment()
            }
        }
    }

    fun setImageFromClick(imgSourceUrl: String, imageView: ImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .resize(350, 350)
            .centerCrop()
            .into(imageView);
    }

    fun goBackFragment() {
        findNavController().navigateUp()
    }

}