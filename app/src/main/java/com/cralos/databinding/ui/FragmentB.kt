package com.cralos.databinding.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cralos.databinding.R
import com.cralos.databinding.databinding.FragmentBBinding
import com.cralos.databinding.model.Product

class FragmentB : Fragment(), OnClickBack {

    private lateinit var binding: FragmentBBinding

    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? = arguments
        bundle?.let {
            product = bundle.get("product") as Product
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_b, container, false)
        binding.listener = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product.let {
            binding.product = it
        }
    }

    override fun closeProductDescription() {
        findNavController().popBackStack()
    }

    private fun saludo(){
        Log.e("TAG","Hola!!!")
        //comentario
        //otro comentario más
    }

}