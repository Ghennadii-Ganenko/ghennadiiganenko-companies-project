package com.ghennadiiganenko.android.companies.fragments.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghennadiiganenko.android.companies.R
import com.ghennadiiganenko.android.companies.databinding.FragmentCardBinding
import kotlin.properties.Delegates

class CardFragment : Fragment(R.layout.fragment_card) {

    private var binding: FragmentCardBinding by Delegates.notNull()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}