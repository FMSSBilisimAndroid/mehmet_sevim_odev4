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
        /**
         * safe arguments ile gelen veriyi değişkenlere alıp fonksiyona gönderiyoruz
         */
        val price = args.planetsDetails.price
        val id = args.planetsDetails.id
        val type = args.planetsDetails.type
        val img_url = args.planetsDetails.img_src
        setDetailScreenData(type, id, price.toString())

        fragmentDetailBinding.apply {
            /**
             * butona tıklandığında bir önceki fragment'a gönderen fonksiyonu çağırıyoruz
             */
            imageButton.setOnClickListener {
                goBackFragment()
            }
            /**
             * picassoya image url gönderiyoruz
             */
            setImageDetailScreen(img_url, imageView3)
        }

    }

    /**
     * @param imgSourceUrl String Picasso için gerekli olan api'den gelen image url
     * @param imageView ImageView Picasso'nun aldığı veriyi göstereceği yer
     * url'i Picasso'ya gönderip imageview içerisinde gösteriyoruz
     */
    fun setImageDetailScreen(imgSourceUrl: String, imageView: ImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .resize(350, 350)
            .centerCrop()
            .into(imageView);
    }

    /**
     *Bir önceki Fragment'a yönlendiren fonksiyon
     */
    fun goBackFragment() {
        findNavController().navigateUp()
    }

    /**
     * @param type String
     * @param price String
     * @param id String
     * @param img_url String
     * gelen verileri Details fragment üzerinde gerekli alanlara gönderiyoruz
     */
    fun setDetailScreenData(type: String, price: String, id: String) {
        fragmentDetailBinding.apply {
            button3.text = "$type"
            textView2.text = "$price"
            textView3.text = "$id"


        }
    }


}