package com.example.color

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ColorFragment: Fragment() {



    private lateinit var mColorTextView:TextView
    private lateinit var nameButton: Button

    companion object {
        fun newInstance(name: String): ColorFragment {
            val args = Bundle().apply {
                putSerializable("Name", name)
            }

            return ColorFragment().apply {
                arguments = args
            }
        }
    }
    var mColor :String =""
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        mColor=arguments?.getSerializable("Name") as String
    }
    interface Callbacks {
        fun onAddName(Name:String)
    }
    private var callbacks:Callbacks? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks= context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container:ViewGroup?,
        savedInstanceState:Bundle?
    ): View?{
        val view=inflater.inflate(R.layout.color_fragment,container,false)
        mColorTextView=view.findViewById(R.id.text)as TextView
        nameButton=view.findViewById(R.id.name_button)
        nameButton.setOnClickListener{
            callbacks?.onAddName("samar ahmed ")

        }
        mColorTextView.setText(mColor)
        return view
    }
}

