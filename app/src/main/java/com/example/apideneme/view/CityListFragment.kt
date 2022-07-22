package com.example.apideneme.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apideneme.R
import com.example.apideneme.adapter.CityRecyclerAdapter
import com.example.apideneme.viewmodel.CityListViewModel
import kotlinx.android.synthetic.main.fragment_city_list.*


class CityListFragment : Fragment() {

    private lateinit var viewModel : CityListViewModel
    private val recyclerCityAdapter = CityRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CityListViewModel::class.java)
        viewModel.refreshData()

        cityListRecycler.layoutManager = LinearLayoutManager(context)
        cityListRecycler.adapter = recyclerCityAdapter

        swipeRefreshLayout.setOnRefreshListener {
            cityLoading.visibility = View.VISIBLE
            cityErrorMessage.visibility = View.GONE
            cityListRecycler.visibility = View.GONE

            viewModel.refreshData()
            swipeRefreshLayout.isRefreshing = false
        }
        observeLiveData()
    }

    fun observeLiveData(){

        viewModel.cities.observe(viewLifecycleOwner, Observer { cities ->
            cities?.let {
                cities.data?.cities?.let {
                    cityListRecycler.visibility = View.VISIBLE
                    recyclerCityAdapter.cityListUpdate(it)
                }

            }
        })

        viewModel.cityErrorMessage.observe(viewLifecycleOwner,Observer{ error ->
            error?.let{
            if(it){
                cityErrorMessage.visibility = View.VISIBLE
               }
                else { cityErrorMessage.visibility = View.GONE

                }
            }
        })

        viewModel.cityLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let{
                if(it){
                    cityListRecycler.visibility = View.GONE
                    cityErrorMessage.visibility = View.GONE
                    cityLoading.visibility = View.GONE
                }  else{
                    cityLoading.visibility = View.GONE

                }

            }

        })

    }


}



