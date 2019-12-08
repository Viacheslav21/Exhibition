package com.example.exhibition.ui.main_screen

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exhibition.main.BaseFragment
import com.example.exhibition.R
import com.example.exhibition.objects.MainObj
import kotlinx.android.synthetic.main.fragment_main_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : BaseFragment<MainScreenViewModel>(R.layout.fragment_main_screen) {

    override val viewModel: MainScreenViewModel by viewModel()

    private val adapter: ExhibitionAdapter by lazy {
        ExhibitionAdapter {
            openDetailScreen(it)
        }
    }

    private fun openDetailScreen(it: Int) {
        findNavController().navigate(MainScreenFragmentDirections.actionMainFragmentToDetailFragment(it))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.getElements()
    }

    override fun subscribeToEvents() {
        super.subscribeToEvents()
        viewModel.showMainScreenEvent.observe(this, Observer { addData(it) })
    }


    private fun initRecyclerView() {
        main_screen_recycler.layoutManager = LinearLayoutManager(requireContext())
        main_screen_recycler.setHasFixedSize(true)
        main_screen_recycler.adapter = adapter
    }


    private fun addData(list: List<MainObj>) {
        adapter.addItem(list)
    }


}