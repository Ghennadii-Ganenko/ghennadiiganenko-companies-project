package com.ghennadiiganenko.android.companies.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.companies.R
import com.ghennadiiganenko.android.companies.databinding.FragmentListBinding
import com.ghennadiiganenko.android.companies.domain.models.CompanyEntity
import com.ghennadiiganenko.android.companies.fragments.list.adapter.CompaniesListAdapter
import com.ghennadiiganenko.android.companies.fragments.list.viewmodel.ListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates

class ListFragment : Fragment(R.layout.fragment_list), CompaniesListAdapter.ItemClickListener {

    private var binding: FragmentListBinding by Delegates.notNull()
    private val viewModel by viewModel<ListViewModel>()
    private lateinit var companiesListAdapter: CompaniesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        companiesListAdapter = CompaniesListAdapter(this, view)

        binding.companiesListRecyclerview.adapter = companiesListAdapter

        viewModel.companyList.observe(viewLifecycleOwner) {result ->
            companiesListAdapter.submitList(result)
        }

        viewModel.getCompaniesList()
    }

    override fun onItemClicked(item: CompanyEntity, view: View) {
        navigateToCardFragment()
    }

    private fun navigateToCardFragment() = findNavController().navigate(R.id.card_fragment)
}