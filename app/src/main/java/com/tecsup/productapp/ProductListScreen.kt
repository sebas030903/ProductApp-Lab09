package com.tecsup.productapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel = viewModel()) {
    val products = viewModel.products

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column {
            Text(
                text = "🛍 Productos",
                color = Color(0xFFFF9800),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
            ) {
                items(products) { product ->
                    ProductCard(product)
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = product.title, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = product.description, color = Color.LightGray, maxLines = 2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Precio: $${product.price}", color = Color(0xFFFF9800))
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = product.thumbnail,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }
    }
}
