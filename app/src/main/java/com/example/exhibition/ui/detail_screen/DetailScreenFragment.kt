package com.example.exhibition.ui.detail_screen

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.exhibition.R
import com.example.exhibition.main.BaseFragment
import com.example.exhibition.objects.MainObj
import kotlinx.android.synthetic.main.fragment_detail_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailScreenFragment : BaseFragment<DetailScreenViewModel>(R.layout.fragment_detail_screen) {

    override val viewModel: DetailScreenViewModel by viewModel()
    private val args by navArgs<DetailScreenFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getElements()
    }

    override fun subscribeToEvents() {
        super.subscribeToEvents()
        viewModel.showMainScreenEvent.observe(this, Observer { initData(it) })
    }


    private fun initData(list: List<MainObj>) {
        val adapter = DetailScreenAdapter(requireContext(), list)
        view_pager.adapter = adapter
        view_pager.currentItem = args.position
    }

}