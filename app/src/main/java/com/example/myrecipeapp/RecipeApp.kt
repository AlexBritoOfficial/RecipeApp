package com.example.myrecipeapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myrecipeapp.model.Category
import com.example.myrecipeapp.viewmodels.MainViewModel

// This file will serve as the entry point to our application

/**
 *
 *
 **/

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoryResponseState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {

            composable(route = Screen.RecipeScreen.route){
                RecipeScreen(modifier = Modifier.fillMaxSize(),
                    viewState,
                    navigateToCategoryDetail = {

                        //
                        navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                        navController.navigate(Screen.DetailScreen.route)
                    })
            }

        composable(route = Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat") ?: Category("","","","")
            
            CategoryDetailScreen(category = category)
        }
     }
}