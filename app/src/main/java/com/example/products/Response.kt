package com.example.products

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("Products")
	val products: List<ProductsItem?>? = null
)

data class ProductsItem(

	@field:SerializedName("Category")
	val category: String? = null,

	@field:SerializedName("ProductName")
	val productName: String? = null,

	@field:SerializedName("Rate")
	val rate: Int? = null,

	@field:SerializedName("ProductId")
	val productId: Int? = null,

	@field:SerializedName("Tax")
	val tax: Int? = null
)
