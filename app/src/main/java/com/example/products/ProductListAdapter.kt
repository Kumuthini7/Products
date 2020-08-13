package com.example.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_item.view.*
import java.util.ArrayList

/**
 * Created by Kumuthini.N on 12-08-2020
 */
class ProductListAdapter(private val details: List<ProductsItem?>?) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return details?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(details as ArrayList<ProductsItem>, position)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: ArrayList<ProductsItem>, position: Int) {
            itemView.product_id.text = item[position].productId.toString()+": "
            itemView.name.text = item[position].productName.toString()
            itemView.category.text = "Category: " +item[position].category.toString()
            itemView.rate.text = "Rate: Rs." +item[position].rate.toString()
            itemView.tax.text = "Tax: Rs." +item[position].tax.toString()
            val price = item[position].tax?.let { item[position].rate?.plus(it) }
            itemView.price.text = "Rs.$price"
        }
    }
}
