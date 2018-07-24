package com.example.looser43.testapp.updateValTest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.looser43.testapp.Models
import com.example.looser43.testapp.R

class UpdateValueTestActivity : AppCompatActivity(), View.OnClickListener, SimpleCallBack {

    override fun onClickItem(position: Int) {
        Toast.makeText(this@UpdateValueTestActivity, "Item clicked at position $position", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {

        Toast.makeText(this@UpdateValueTestActivity, "Update value of horizontal list", Toast.LENGTH_SHORT).show()
    }

    private var horizontalDataModelList: ArrayList<Models.DataModel> = ArrayList()
    private var dataAdapterHorizontal: DataAdapterHorizontal? = null
    private var rv_hori: RecyclerView? = null
    private var btnUpdate: Button? = null
    private var listener: AdapterListener? = null

    init {
        listener = this@UpdateValueTestActivity as AdapterListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_value_test)
        populateData()
        initializeViews()
    }

    private fun initializeViews() {
        btnUpdate = findViewById(R.id.btn_update)
        btnUpdate?.setOnClickListener(this@UpdateValueTestActivity)
        rv_hori = findViewById(R.id.rv_hori_test)
        rv_hori?.setHasFixedSize(true)
        rv_hori?.adapter = DataAdapterHorizontal(horizontalDataModelList, this@UpdateValueTestActivity)
        rv_hori?.layoutManager = LinearLayoutManager(this@UpdateValueTestActivity, LinearLayoutManager.HORIZONTAL, false)
    }

    fun populateData() {
        horizontalDataModelList.clear()

        var a = Models.DataModel("2", "Not Viewed")
        horizontalDataModelList.add(a)

        a = Models.DataModel("3", "Viewed")
        horizontalDataModelList.add(a)

        a = Models.DataModel("1", "Shortlisted")
        horizontalDataModelList.add(a)

        a = Models.DataModel("4", "Interview List")
        horizontalDataModelList.add(a)

        a = Models.DataModel("3", "Final List")
        horizontalDataModelList.add(a)

        a = Models.DataModel("5", "Reject List")
        horizontalDataModelList.add(a)

        dataAdapterHorizontal?.notifyDataSetChanged()
    }
}
