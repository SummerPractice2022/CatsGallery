package ru.teamfive.catsgallery.ui.fragments

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// базовый фрагмент, здесь просто настраевается ViewBinding
// вместо T надо передавать ViewBinding фрагмента или активити
open class BaseFragment<T : ViewBinding> : Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}