package com.cralos.databinding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cralos.databinding.R
import com.cralos.databinding.adapters.ProductAdapter
import com.cralos.databinding.databinding.FragmentABinding
import com.cralos.databinding.model.Product

class FragmentA : Fragment(), ProductAdapter.OnClickProduct {

    private lateinit var binding: FragmentABinding
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_a, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {
        adapter = ProductAdapter(getProducts())
        adapter.setOnClickProductSelected(this)
        binding.rv.setHasFixedSize(false)
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter
    }

    fun getProducts(): List<Product> {
        val products = ArrayList<Product>()
        products.add(
            Product(
                "TITULO 1",
                "Esta es la descripción para el producto 1",
                R.drawable.black_hat
            )
        )
        products.add(
            Product(
                "TITULO 2",
                "Esta es la descripción para el producto 2",
                R.drawable.blue_hat
            )
        )
        products.add(
            Product(
                "TITULO 3",
                "Esta es la descripción para el producto 3",
                R.drawable.green_hills
            )
        )
        products.add(
            Product(
                "TITULO 4",
                "Esta es la descripción para el producto 4",
                R.drawable.orange_hat
            )
        )
        products.add(
            Product(
                "TITULO 5",
                "Esta es la descripción para el producto 5",
                R.drawable.red_lamp
            )
        )
        return products
    }

    override fun productSelected(productSelected: Product) {
        val bundle = Bundle()
        bundle.putParcelable("product", productSelected)
        findNavController().navigate(R.id.action_fragmentA_to_fragmentB, bundle)
    }
//com
}