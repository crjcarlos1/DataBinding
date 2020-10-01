package com.cralos.databinding.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cralos.databinding.R
import com.cralos.databinding.databinding.ItemProductBinding
import com.cralos.databinding.model.Product

class ProductAdapter(var products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var listener: OnClickProduct

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemProductBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_product,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.product = products.get(position)
        holder.binding.containerProduct.setOnClickListener {
            listener.let {
                listener.productSelected(products.get(position))
            }
        }
    }

    class ViewHolder(itemView: ItemProductBinding) : RecyclerView.ViewHolder(itemView.root) {
        val binding = itemView
    }

    fun setOnClickProductSelected(productSelectedListener: OnClickProduct) {
        this.listener = productSelectedListener
    }

    interface OnClickProduct {
        fun productSelected(productSelected: Product)
    }

}