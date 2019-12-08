package com.example.exhibition.ui.main_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exhibition.R
import com.example.exhibition.objects.MainObj
import kotlinx.android.synthetic.main.item_exhibit.view.*
import java.text.SimpleDateFormat
import java.util.*

class ExhibitionAdapter(private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<MainObjViewHolder>() {

    private val list = mutableListOf<MainObj>()

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainObjViewHolder {
        return MainObjViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_exhibit,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainObjViewHolder, position: Int) {
        holder.bind(list[position], onClick)
    }

    fun addItem(list: List<MainObj>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()

    }
}

class MainObjViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {


    companion object {
        const val DATE_PATTERN = "dd-MMMM-yy HH:MM"
    }

    fun bind(obj: MainObj, onClick: (Int) -> Unit) {

        itemView.setOnClickListener { onClick(adapterPosition) }
        itemView.item_title.text = obj.name

        Glide.with(itemView.context)
            .asBitmap()
            .load(obj.image)
            .override(1600, 1600)
            .centerCrop()
            .into(itemView.item_image)

        itemView.item_date.text = getCorrectDate(obj.time)
        itemView.item_desc.text = obj.description
    }

    private fun getCorrectDate(date: Long): String {
        val mDate = Date(date)
        val df2 = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
        return df2.format(mDate)
    }


}