package com.example.week_3_assignment.data

import android.os.Parcelable
import com.example.week_3_assignment.R
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryModel(
    //Kategori modeli oluşturuldu. tipler belirlendi
    val id: String,
    val categaryName: String,
    val categoryImage: Int
) : Parcelable {
    //veri gönderme sırasında kullanılacak fonksiyonlar yazıldı
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(jsonValue: String): CategoryModel {
            return Gson().fromJson(jsonValue, CategoryModel::class.java)
        }
    }
}

//örnek bir data oluşturuldu
val mockCategoryData = mutableListOf<CategoryModel>(
    CategoryModel(
        "1",
        "Turk Mutfagi",
        R.drawable.turk_yemegi
    ),
    CategoryModel(
        "2",
        "Amerikan Mutfagi",
        R.drawable.american_food
    ),
    CategoryModel(
        "3",
        "Asya Mutfagi",
        R.drawable.asian_food
    ),
    CategoryModel(
        "4",
        "Italyan Mutfagi",
        R.drawable.italian_food
    ),
    CategoryModel(
        "5",
        "Meksika Mutfagi",
        R.drawable.mexican_food
    ),
    CategoryModel(
        "6",
        "Amerikan Mutfagi",
        R.drawable.american_food
    ),
    CategoryModel(
        "7",
        "Asya Mutfagi",
        R.drawable.asian_food
    ),
    CategoryModel(
        "8",
        "Italyan Mutfagi",
        R.drawable.italian_food
    ),
    CategoryModel(
        "9",
        "Meksika Mutfagi",
        R.drawable.mexican_food
    ),
    CategoryModel(
        "10",
        "Turk Mutfagi",
        R.drawable.turk_yemegi
    ),
)
