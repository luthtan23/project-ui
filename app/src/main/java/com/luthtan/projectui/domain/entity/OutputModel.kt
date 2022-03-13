package com.luthtan.projectui.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OutputModel(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("total")
	val total: String? = null,

	@field:SerializedName("item")
	val item: List<ItemItem>? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
) : Parcelable
