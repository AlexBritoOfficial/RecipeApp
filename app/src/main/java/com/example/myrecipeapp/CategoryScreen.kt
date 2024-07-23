package com.example.myrecipeapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myrecipeapp.model.Category

@Composable
fun CategoryScreen(categories: List<Category>,
                   navigateToCategoryDetail: (Category) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {

        items(categories){
                category -> CategoryItem(category = category, navigateToCategoryDetail)
        }

    }
}