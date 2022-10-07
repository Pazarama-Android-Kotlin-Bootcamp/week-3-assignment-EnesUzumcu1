package com.example.week_3_assignment.categorylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_assignment.R
import com.example.week_3_assignment.data.CategoryModel

class CategoriesAdapter(
    //Adapterde kullanılacak değişkenler tanımlandı
    private val categoryList: MutableList<CategoryModel>,
    private val listener: CategoriesListener

) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //adapter içinde yapılması istenen işlemler için atama yapıldı
        private val categoriName = view.findViewById<TextView>(R.id.tvCategoryName)
        private val categoriImage = view.findViewById<ImageView>(R.id.ivCategoryImage)

        //listedeki her bir elemanın ekrana basılması için fonksiyon oluşturuldu
        fun bind(category: CategoryModel, listener: CategoriesListener) {
            categoriName.text = category.categaryName
            categoriImage.setImageResource(category.categoryImage)

            itemView.setOnClickListener {
                listener.onClicked(category)
            }
        }
    }

    //onCreateViewHolder içinde custom item verildi.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category_list, parent, false)

        return CategoriesViewHolder(view)
    }

    //sayfa oluştuktan sonra onBindViewHolder içinde her bir satırı oluşturuyor
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categoryList[position], listener)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    interface CategoriesListener {
        fun onClicked(category: CategoryModel)
    }
}
