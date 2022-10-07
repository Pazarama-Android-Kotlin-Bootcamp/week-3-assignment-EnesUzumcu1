package com.example.week_3_assignment.categorylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_assignment.R
import com.example.week_3_assignment.data.CategoryModel
import com.example.week_3_assignment.data.mockCategoryData

class CategoryListFragment : Fragment(), CategoriesAdapter.CategoriesListener {
    private lateinit var rvCategoryList: RecyclerView
    private lateinit var navController: NavController

    //onCreateView içinde activity verildi.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    //onViewCreated activity oluşturulduktan sonra atamalar yapıldı
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //fragmentin çalışacağı yer verildi
        navController = findNavController()
        rvCategoryList = view.findViewById(R.id.rvCategoryList)
        setupAdapter()
    }

    //recyclerview içi adapter oluşturuldu
    private fun setupAdapter() {
        rvCategoryList.adapter = CategoriesAdapter(mockCategoryData, this)
    }

    //recyclerviewdeki herhangi bir itema tıklayınca olacak olan olaylar ayarlandı
    override fun onClicked(category: CategoryModel) {
        navController.navigate(
            R.id.action_categoryListFragment_to_cookListFragment,
            Bundle().apply {
                putString("categoryModel", category.toJson())
            })
    }
}