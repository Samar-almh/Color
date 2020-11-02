package com.example.color

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class NewFragment:Fragment() {


    private lateinit var addText: TextView
    companion object {
        fun newInstance(name: String): NewFragment {
            val args = Bundle().apply {
                putSerializable("Name", name)
            }
            return NewFragment().apply {
                arguments = args
            }
        }
    }
    var myName :String =""
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        myName=arguments?.getSerializable("Name") as String
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState:Bundle?
    ): View?{
        val view=inflater.inflate(R.layout.new_fragment,container,false)
        addText=view.findViewById(R.id.add_text)as TextView


        addText.setText(myName)
        return view
    }





}
