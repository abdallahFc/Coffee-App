package com.example.coffeeshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.R.id
import com.example.coffeeshop.R.layout
import com.example.coffeeshop.data.CartItem

class CartAdapter(
    private val list: List<CartItem>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView
        val name: TextView
        val price:TextView
        val count:TextView

        init {
            imageView = itemView.findViewById(id.cart_Image)
            name = itemView.findViewById(id.cart_title)
            price=itemView.findViewById(id.item_cart_price)
            count=itemView.findViewById(id.tv_quantityNum)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout.cart_item, parent, false)
        val vh = ViewHolder(view)
        return vh
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = list[position]
        holder.imageView.setImageResource(item.image)
        holder.name.text=item.name
        holder.count.text= item.count.toString()
        holder.price.text= item.price.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}