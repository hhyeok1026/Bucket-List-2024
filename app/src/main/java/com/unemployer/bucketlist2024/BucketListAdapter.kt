package com.unemployer.bucketlist2024

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.unemployer.bucketlist2024.BucketListAdapter.BucketListViewHolder
import com.unemployer.bucketlist2024.databinding.RecyclerviewItemBinding
import com.unemployer.bucketlist2024.model.BucketListItem

class BucketListAdapter :
    ListAdapter<BucketListItem, BucketListViewHolder>(BucketListItemsComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BucketListViewHolder {
        return BucketListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BucketListViewHolder, position: Int) {
        val currentBucketListItem = getItem(position)
        holder.bind(currentBucketListItem)
    }

    class BucketListViewHolder private constructor(
        private val binding: RecyclerviewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        // 뷰 속성을 바꾸게 되면 재활용에 문제가 생기는데, 여기서 else구현 여기서 해줘야함?
        fun bind(bucketListItem: BucketListItem) {
            val idText = "${bucketListItem.id}. "
            binding.idTextView.text = idText
            binding.contentsTextView.text = bucketListItem.contents

            if (bucketListItem.isDoneBucket) {
                setStrikeThrough(binding.idTextView)
                setStrikeThrough(binding.contentsTextView)
                binding.checkBox.isChecked = true
            } else {
                removeStrikeThrough(binding.idTextView)
                removeStrikeThrough(binding.contentsTextView)
                binding.checkBox.isChecked = false
            }
        }

        // textView: TextView 객체
        private fun setStrikeThrough(textView: TextView) {
            textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        private fun removeStrikeThrough(textView: TextView) {
            textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        companion object {
            fun create(parent: ViewGroup): BucketListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecyclerviewItemBinding.inflate(layoutInflater, parent, false)
                return BucketListViewHolder(binding)
            }
        }
    }

    class BucketListItemsComparator : DiffUtil.ItemCallback<BucketListItem>() {
        override fun areItemsTheSame(
            oldItem: BucketListItem, newItem: BucketListItem
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: BucketListItem, newItem: BucketListItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}