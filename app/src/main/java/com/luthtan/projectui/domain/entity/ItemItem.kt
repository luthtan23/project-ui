package com.luthtan.projectui.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemItem(

    @field:SerializedName("icon_url")
    val iconUrl: String? = null,

    @field:SerializedName("help")
    val help: Boolean? = null,

    @field:SerializedName("help_info")
    val helpInfo: HelpInfo? = null,

    @field:SerializedName("other_currency")
    val otherCurrency: List<OtherCurrencyItem?>? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("currency")
    val currency: String? = null,

    var isSelected: Boolean = false
) : Parcelable

@Parcelize
data class HelpInfo(

    @field:SerializedName("sub_item")
    val subItem: List<SubItemItem>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null
) : Parcelable

@Parcelize
data class SubItemItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description ")
    val description: String? = null
) : Parcelable

@Parcelize
data class OtherCurrencyItem(

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("currency")
    val currency: String? = null
) : Parcelable
