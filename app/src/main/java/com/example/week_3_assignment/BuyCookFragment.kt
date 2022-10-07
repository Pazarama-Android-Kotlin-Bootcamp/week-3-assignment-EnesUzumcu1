package com.example.week_3_assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.week_3_assignment.data.CookModel

class BuyCookFragment : Fragment() {

    private lateinit var cookNameBuy: TextView
    private lateinit var cookPriceBuy: TextView
    private lateinit var cookImageBuy: ImageView
    private lateinit var btnBuy: Button

    //onCreateView içinde activity verildi.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buy_cook, container, false)
    }

    //onViewCreated activity oluşturulduktan sonra atamalar yapıldı
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews(view)
    }

    //ekrandaki diğer viewler için atamalar yapıldı.
    private fun setupViews(view: View) {
        cookNameBuy = view.findViewById(R.id.tvCookNameBuyCook)
        cookPriceBuy = view.findViewById(R.id.tvCookPriceBuyCook)
        cookImageBuy = view.findViewById(R.id.ivBuyCookImage)
        btnBuy = view.findViewById(R.id.btnBuy)

        //diğer sayfadan veri alındı
        arguments?.let {
            val cookData = it.getString("cookModel")

            cookData?.let { safeCookData ->
                val cook = CookModel.fromJson(safeCookData)

                cookNameBuy.text = cook.cookName
                cookPriceBuy.text = cook.cookPrice
                cookImageBuy.setImageResource(cook.cookImage)

            }
        }
        //butona onClick verildi
        btnBuy.setOnClickListener {
            Toast.makeText(view.context, "Siparişiniz alındı.", Toast.LENGTH_SHORT).show()
        }
    }
}