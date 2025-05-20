package com.tecsup.productapp

import retrofit2.http.GET

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}
