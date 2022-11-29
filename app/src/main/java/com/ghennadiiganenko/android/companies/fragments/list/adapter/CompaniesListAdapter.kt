package com.ghennadiiganenko.android.companies.fragments.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ghennadiiganenko.android.companies.data.common.Common.BASE_URL
import com.ghennadiiganenko.android.companies.databinding.ItemCompaniesListBinding
import com.ghennadiiganenko.android.companies.domain.models.CompanyEntity
import com.squareup.picasso.Picasso

class CompaniesListAdapter(
    private val clickListener: ItemClickListener,
    private val view: View,
) : ListAdapter<CompanyEntity, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    private class ItemsDiffCallback : DiffUtil.ItemCallback<CompanyEntity>() {
        override fun areItemsTheSame(
            oldItem: CompanyEntity,
            newItem: CompanyEntity
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: CompanyEntity,
            newItem: CompanyEntity
        ): Boolean =
            oldItem == newItem
    }

    inner class CompaniesViewHolder(private val binding: ItemCompaniesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CompanyEntity) {
            binding.apply {
                root.setOnClickListener {
                    it.isClickable = false
                    it.postDelayed({ it.isClickable = true }, 1000)
                    clickListener.onItemClicked(item, view)
                }

                Picasso.get().load("$BASE_URL/${item.img}").into(companyImage)
                companyName.text = item.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder =
        CompaniesViewHolder(
            ItemCompaniesListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val packHolder = holder as CompaniesViewHolder
        packHolder.bind(item)
    }

    interface ItemClickListener {
        fun onItemClicked(item: CompanyEntity, view: View)
    }
}