package com.example.looser43.testapp.modalView

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.looser43.testapp.R

class ModalActivity : AppCompatActivity(), View.OnClickListener, DialogeFragment.OnFragmentInteractionListener {
    override fun onSearchClicked(value: String?) {
        Toast.makeText(applicationContext, "Got value $value", Toast.LENGTH_SHORT).show()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View?) {
        val fm = supportFragmentManager
        val fragment = DialogeFragment()
        fragment.show(fm, "dialogFragment")
    }

    private var btnClick: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modal)
        btnClick = findViewById(R.id.btn_click2View)
        btnClick?.setOnClickListener(this@ModalActivity)

    }
}
