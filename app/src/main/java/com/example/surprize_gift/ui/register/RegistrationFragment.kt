package com.example.surprize_gift.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.surprize_gift.R

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         return inflater.inflate(R.layout.registration_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.alreadyAccount).setOnClickListener{
            val fragmentMan = requireFragmentManager().beginTransaction()
            fragmentMan.replace(R.id.main_fragment, LoginFragment(), "LOGIN_FRAG")
            fragmentMan.commit()
        }
    }
}