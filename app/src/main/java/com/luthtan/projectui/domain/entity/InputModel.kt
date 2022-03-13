package com.luthtan.projectui.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InputModel(

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("item")
	val item: List<ItemItem>? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable

