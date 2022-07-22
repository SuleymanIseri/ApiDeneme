package com.example.apideneme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apideneme.R
import com.example.apideneme.model.City
import kotlinx.android.synthetic.main.city_recycler_row.view.*

class CityRecyclerAdapter(val cityList : ArrayList<City>) : RecyclerView.Adapter<CityRecyclerAdapter.CityViewHolder>() {
    class CityViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.city_recycler_row,parent,false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.itemView.cityName.text = cityList.get(position).cityName
        holder.itemView.cityDesc.text = cityList.get(position).cityDesc
        holder.itemView.citypopulation.text = cityList.get(position).cityPopulation
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    fun cityListUpdate(newCityList: List<City>){
        cityList.clear()
        cityList.addAll(newCityList)
        notifyDataSetChanged()
    }
}