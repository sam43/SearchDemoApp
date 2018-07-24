package com.example.looser43.testapp.updateValTest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.looser43.testapp.Models
import com.example.looser43.testapp.R


class DataAdapterHorizontal(private val items: ArrayList<Models.DataModel>, context: Context) : RecyclerView.Adapter<DataAdapterHorizontal.MyViewHolderHorizontal>(), AdapterListener {
    override fun updateValue(value: String) {
        Log.d("adapter", "updated value $value")
    }

    private var call: SimpleCallBack? = null
    var locValue: String? = null

    init {
        call = context as SimpleCallBack
    }

    override fun onBindViewHolder(holder: MyViewHolderHorizontal, position: Int) {
//
        val dModel = items[position]
        holder.number_Value.text = dModel.application
        holder.string_Value.text = dModel.value
        holder.itemView.setOnClickListener {
            call?.onClickItem(position)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderHorizontal {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return DataAdapterHorizontal.MyViewHolderHorizontal(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolderHorizontal(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var number_Value: TextView = itemView!!.findViewById(R.id.number_TV)
        var string_Value: TextView = itemView!!.findViewById(R.id.value_TV)

    }
}