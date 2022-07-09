package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentSetupBinding

class SetupFragment: Fragment(R.layout.fragment_setup) {
    private var _binding: FragmentSetupBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSetupBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}