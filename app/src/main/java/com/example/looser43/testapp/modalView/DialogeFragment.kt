package com.example.looser43.testapp.modalView

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.looser43.testapp.R

class DialogeFragment : DialogFragment() {
    private var listener: OnFragmentInteractionListener? = null
    private var toolbarFilter: Toolbar? = null
    private var btnSearch: Button? = null
    private var etKeyword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomDialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_dialoge, container, false)
        //dialog.setTitle("Simple Dialog")
        etKeyword = rootView.findViewById(R.id.keyword_ET)
        btnSearch = rootView.findViewById(R.id.btn_search)
        btnSearch?.setOnClickListener {
            listener?.onSearchClicked(etKeyword?.text.toString())
            dismiss()
        }
        toolbarFilter = rootView.findViewById(R.id.toolbar_filter)
        toolbarFilter?.title = "Filters"
        toolbarFilter?.setNavigationOnClickListener {
            //Toast.makeText(activity?.applicationContext, "Close working!", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        dialog.setCancelable(false)
        return rootView
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)

        fun onSearchClicked(value: String?)
    }

}
