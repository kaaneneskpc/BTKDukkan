package com.btkakademi.btkdukkanmobile.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.btkakademi.btkdukkanmobile.R
import com.btkakademi.btkdukkanmobile.adapter.ProductRecyclerAdapter
import com.btkakademi.btkdukkanmobile.model.Product
import com.btkakademi.btkdukkanmobile.service.ProductAPI
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_products.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class ProductFragment : Fragment() ,ProductRecyclerAdapter.ProductListener {

    private val productViewModel : ProductViewModel by activityViewModels()  //access viewModel on fragment
    private var productRecyclerAdapter : ProductRecyclerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(activity?.baseContext,2)

        productViewModel.downloadData()
        productViewModel.productList.observe(viewLifecycleOwner, Observer {
         productRecyclerAdapter=ProductRecyclerAdapter(it,this)
         recyclerView.adapter = productRecyclerAdapter
     })

    }

    override fun onItemClick(product: Product) {
        productViewModel.addToBasket(product)
    }


}