package com.example.exhibition.ui.detail_screen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.exhibition.R
import com.example.exhibition.objects.MainObj
import com.example.exhibition.ui.main_screen.MainObjViewHolder
import kotlinx.android.synthetic.main.item_exhibit.view.*
import java.text.SimpleDateFormat
import java.util.*


class DetailScreenAdapter(private val mContext: Context, private val mListData: List<MainObj>) :
    PagerAdapter() {

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return mListData.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.item_exhibit, container, false) as ViewGroup

        val obj = mListData[position]

        view.item_title.text = obj.name

        Glide.with(view.context)
            .asBitmap()
            .load(obj.image)
            .override(2000, 2000)
            .centerCrop()
            .into(view.item_image)

        view.item_date.text = getCorrectDate(obj.time)
        view.item_desc.text = obj.description

        container.addView(view)
        return view
    }


    private fun getCorrectDate(date: Long): String {
        val mDate = Date(date)
        val df2 = SimpleDateFormat(MainObjViewHolder.DATE_PATTERN, Locale.getDefault())
        return df2.format(mDate)
    }

}
