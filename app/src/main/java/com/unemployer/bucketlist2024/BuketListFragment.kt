package com.unemployer.bucketlist2024

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unemployer.bucketlist2024.databinding.FragmentBuketListBinding
import kotlin.math.log

class BuketListFragment : Fragment() {
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



        /*binding.textView.text = "hello"
        binding.textView.setOnClickListener {
            Log.v("test", "textView 클릭됨")
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}