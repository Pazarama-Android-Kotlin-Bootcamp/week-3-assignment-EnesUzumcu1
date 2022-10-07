package com.example.week_3_assignment.cooklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_assignment.R
import com.example.week_3_assignment.data.CookModel

class CooksAdapter(
    //Adapterde kullanılacak değişkenler tanımlandı
    private val cookList: MutableList<CookModel>,
    private val listener: CooksListener
) : RecyclerView.Adapter<CooksAdapter.CooksViewHolder>() {
    class CooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //adapter içinde yapılması istenen işlemler için atama yapıldı
        private val cookName = view.findViewById<TextView>(R.id.tvCookName)
        private val cookPrice = view.findViewById<TextView>(R.id.tvCookPrice)
        private val cookImage = view.findViewById<ImageView>(R.id.ivCookImage)
        private val isFavorite = view.findViewById<ImageView>(R.id.ivCookFavorite)
        private val cookStars = view.findViewById<TextView>(R.id.tvCookStar)
        private val buyButton = view.findViewById<Button>(R.id.btnBuy)
        private var favoriteNewStatus: Boolean = false

        //listedeki her bir elemanın ekrana basılması için fonksiyon oluşturuldu
        fun bind(cook: CookModel, listener: CooksListener) {
            cookName.text = cook.cookName
            cookPrice.text = cook.cookPrice
            cookImage.setImageResource(cook.cookImage)

            favoriteNewStatus = if (cook.isFavorite) {
                isFavorite.setImageResource(R.drawable.ic_baseline_favorite_24_like)
                true
            } else {
                isFavorite.setImageResource(R.drawable.ic_baseline_favorite_24_unlike)
                false
            }
            cookStars.text = cook.starCount

            isFavorite.setOnClickListener {
                favoriteNewStatus = if (favoriteNewStatus) {
                    isFavorite.setImageResource(R.drawable.ic_baseline_favorite_24_unlike)
                    false
                } else {
                    isFavorite.setImageResource(R.drawable.ic_baseline_favorite_24_like)
                    true
                }
            }

            buyButton.setOnClickListener {
                listener.onClicked(cook)
            }
        }
    }

    //onCreateViewHolder içinde custom item verildi.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CooksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cook_list, parent, false)
        return CooksViewHolder(view)
    }

    //sayfa oluştuktan sonra onBindViewHolder içinde her bir satırı oluşturuyor
    override fun onBindViewHolder(holder: CooksViewHolder, position: Int) {
        holder.bind(cookList[position], listener)
    }

    override fun getItemCount(): Int {
        return cookList.size
    }

    interface CooksListener {
        fun onClicked(cook: CookModel)
    }
}

