package com.example.week_3_assignment.cooklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_assignment.R
import com.example.week_3_assignment.data.CategoryModel
import com.example.week_3_assignment.data.CookModel
import com.example.week_3_assignment.data.mockCookData

class CookListFragment : Fragment(), CooksAdapter.CooksListener {
    private lateinit var rvCookList: RecyclerView
    private lateinit var navController: NavController
    private lateinit var tvCategoryName: TextView

    //onCreateView içinde activity verildi.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cook_list, container, false)
    }

    //onViewCreated activity oluşturulduktan sonra atamalar yapıldı
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //fragmentin çalışacağı yer verildi
        navController = findNavController()
        rvCookList = view.findViewById(R.id.rvCookList)
        setupAdapter()
        setupViews(view)
    }

    //recyclerview içi adapter oluşturuldu
    private fun setupAdapter() {
        rvCookList.adapter = CooksAdapter(mockCookData, this)
    }

    //ekrandaki diğer viewler için atamalar yapıldı.
    private fun setupViews(view: View) {
        tvCategoryName = view.findViewById(R.id.tvCategoryNameCookList)

        //diğer sayfadan veri alındı
        arguments?.let {
            val categoryData = it.getString("categoryModel")

            categoryData?.let { safeCategoryData ->
                val category = CategoryModel.fromJson(safeCategoryData)

                tvCategoryName.text = category.categaryName

            }
        }
    }

    //recyclerviewdeki herhangi bir itema tıklayınca olacak olan olaylar ayarlandı
    override fun onClicked(cook: CookModel) {
        navController.navigate(R.id.action_cookListFragment_to_buyCookFragment, Bundle().apply {
            putString("cookModel", cook.toJson())
        })
    }
}