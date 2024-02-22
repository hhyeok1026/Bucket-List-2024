package com.unemployer.bucketlist2024

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.unemployer.bucketlist2024.databinding.FragmentBuketListBinding
import com.unemployer.bucketlist2024.model.BucketListItem

class BucketListFragment : Fragment() {
    // lateinit var로 만들고 싶었지만, lateinit var는 null로 될 수 없다,
    // onDestroyView에서 바인딩 참조를 해제해야하기때문에 nullable하게 사용해야한다.
    private var _binding: FragmentBuketListBinding? = null
    private val binding
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBuketListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // recyclerView setting
        val adapter = BucketListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        // TODO 여기서도 나중에 로컬에 데이터 있는지 확인하고 초기화해야하는지 판단해야함.
        val initialList = MutableList(5) {
            BucketListItem(
                id = it,
                isEditingMode = true,
                isDoneBucket = false,
                contents = "sample",
            )
        }

        /*List(5) {
            BucketListItem(
                id = it,
                isEditingMode = true,
                isDoneBucket = false,
                contents = "sample",
            )
        }*/

        // 일단, 샘플로 이렇게 넣어주고
        adapter.submitList(initialList)

        // TODO 버튼 셋팅해보자.
        // 어댑터에 데이터를 추가해야하는데 어떻게 하는거지?
        binding.addButton.setOnClickListener {
            Toast.makeText(context, "add 버튼을 눌렀다.", Toast.LENGTH_SHORT).show()

            initialList.add(
                BucketListItem(
                    id = initialList.size,
                    isEditingMode = true,
                    isDoneBucket = false,
                    contents = "sample",
                )
            )

            adapter.notifyItemInserted(initialList.size)
        }

        binding.saveButton.setOnClickListener {
            Toast.makeText(context, "save 버튼을 눌렀다.", Toast.LENGTH_SHORT).show()
        }

        // 이건 나중에,
        // 데이터를 옵저빙하면서, isEditngMode값이 false인게 생기면,
        // save버튼을 활성화 시키고, 저장할 수 있는 기능을 넣어줘야할듯?
        /*if ( initialList.firstOrNull() { it.isEditingMode } != null ) {
            binding.saveButton.isEnabled = true
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}