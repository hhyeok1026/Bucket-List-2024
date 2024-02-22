package com.unemployer.bucketlist2024.model
data class BucketListItem(
    val id: Int, // 이걸 넣는게 이쁠지 확인해보자. 넣는게 나을듯?
    val isEditingMode: Boolean = true,
    val isDoneBucket: Boolean = false,
    val contents: String = "",
)
