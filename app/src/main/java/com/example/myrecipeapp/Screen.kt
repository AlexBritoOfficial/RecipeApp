package com.example.myrecipeapp

sealed class Screen(val route: String) {
    object RecipeScreen: Screen("reciperscreen")
    object DetailScreen: Screen("detailscreen")

}