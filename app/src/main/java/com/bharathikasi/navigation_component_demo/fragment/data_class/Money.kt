package com.bharathikasi.navigation_component_demo.fragment.data_class

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal


@Parcelize
data class Money(val pAmount:BigDecimal):Parcelable {
}