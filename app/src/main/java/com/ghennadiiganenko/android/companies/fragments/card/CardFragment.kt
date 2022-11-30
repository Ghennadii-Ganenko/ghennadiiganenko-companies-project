package com.ghennadiiganenko.android.companies.fragments.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ghennadiiganenko.android.companies.R
import com.ghennadiiganenko.android.companies.data.common.Common
import com.ghennadiiganenko.android.companies.databinding.FragmentCardBinding
import com.ghennadiiganenko.android.companies.fragments.card.viewmodel.CardViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates

class CardFragment : Fragment(R.layout.fragment_card) {

    private var binding: FragmentCardBinding by Delegates.notNull()
    private val viewModel by viewModel<CardViewModel>()
    private val args: CardFragmentArgs by navArgs()

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

        viewModel.companyCard.observe(viewLifecycleOwner) {result ->
            binding.apply {

                Picasso
                    .get()
                    .load(context?.getString(R.string.image_url, Common.BASE_URL,result.img))
                    .into(companyImage)

                companyName.text = result.name
                companyDescription.text = result.description
                companyCoordinates.text = context?.getString(R.string.company_coordinates, result.lat, result.lon)
                companyUrl.text = context?.getString(R.string.company_url, result.www)
                companyPhoneNumber.text = context?.getString(R.string.company_phone_number, result.phone)

            }
        }

            viewModel.getCompanyCard(args.id)
    }
}