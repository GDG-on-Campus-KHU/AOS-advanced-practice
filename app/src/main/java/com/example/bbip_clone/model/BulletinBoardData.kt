package com.example.bbip_clone.model

data class BulletinBoardData(
    val studyTitle: String,
    val content: String,
    val writeTime: String,
    val round: String? = null,
    val isNotice: Boolean = false
)