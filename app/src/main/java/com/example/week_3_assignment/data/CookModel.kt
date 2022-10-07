package com.example.week_3_assignment.data

import android.os.Parcelable
import com.example.week_3_assignment.R
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Parcelize
class CookModel(
    //Yemek modeli oluşturuldu. tipler belirlendi
    val id: String,
    val cookName: String,
    val cookImage: Int,
    val cookPrice: String,
    val isFavorite: Boolean,
    val starCount: String

) : Parcelable {
    //veri gönderme sırasında kullanılacak fonksiyonlar yazıldı
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(jsonValue: String): CookModel {
            return Gson().fromJson(jsonValue, CookModel::class.java)
        }
    }
}

//örnek bir data oluşturuldu
val mockCookData = mutableListOf<CookModel>(
    CookModel(
        "1",
        "Patates Kızartması",
        R.drawable.patates,
        "$5",
        false,
        "4.9 (500+)"
    ),
    CookModel(
        "2",
        "Pizza",
        R.drawable.pizza,
        "$51",
        true,
        "1.9 (100+)"
    ),
    CookModel(
        "1",
        "Hamburger",
        R.drawable.hamburger,
        "$500",
        false,
        "0.1 (5000+)"
    ),
    CookModel(
        "1",
        "Elma Kızartması",
        R.drawable.pizza,
        "$5",
        false,
        "4.9 (500+)"
    ),
    CookModel(
        "1",
        "Armut Kızartması",
        R.drawable.patates,
        "$1",
        true,
        "4.1 (150+)"
    ),
    CookModel(
        "1",
        "Kiraz Kızartması",
        R.drawable.hamburger,
        "$1",
        false,
        "3.3 (500+)"
    ),
    CookModel(
        "1",
        "Ayva Kızartması",
        R.drawable.patates,
        "$15",
        true,
        "4.9 (500+)"
    ),
    CookModel(
        "1",
        "Erik Kızartması",
        R.drawable.pizza,
        "$45",
        false,
        "4.9 (500+)"
    ),
    CookModel(
        "1",
        "Kabak Kızartması",
        R.drawable.hamburger,
        "$2",
        false,
        "4.0 (500+)"
    ),
    CookModel(
        "1",
        "Biber Kızartması",
        R.drawable.pizza,
        "$5",
        true,
        "4.9 (500+)"
    ),
)