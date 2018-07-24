package com.example.looser43.testapp.textSwitcherTest

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.TextSwitcher
import android.widget.TextView
import android.widget.ViewSwitcher
import com.example.looser43.testapp.R

class TextSwitcherActivity : AppCompatActivity(), ViewSwitcher.ViewFactory {
    override fun makeView(): View {
        val txtView = TextView(this@TextSwitcherActivity)
        txtView.setTextColor(Color.BLACK)
        txtView.gravity = Gravity.CENTER_HORIZONTAL
        txtView.typeface = Typeface.DEFAULT_BOLD
        txtView.setShadowLayer(10F, 10F, 10F, Color.GRAY)
        txtView.textSize = 45F
        return txtView
    }

    private var textSwitch: TextSwitcher? = null
    //private var tvVal: TextView? = null
    private var change: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_switcher)
        textSwitch = findViewById(R.id.ts_test)
        //tvVal = findViewById(R.id.tv_val)
        textSwitch?.setFactory(this@TextSwitcherActivity)
    }

    fun onClickUpdate(v: View) {
        change = change?.plus(1)
        textSwitch?.setText((change).toString())
    }
}
