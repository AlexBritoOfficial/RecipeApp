package com.example.myrecipeapp.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipeapp.model.Category
import com.example.myrecipeapp.network.recipeService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoryResponseState = mutableStateOf(RecipeState())


    //
    val categoryResponseState: State<RecipeState> = _categoryResponseState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {

                val response = recipeService.getCategories()
                _categoryResponseState.value = _categoryResponseState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            } catch (e: Exception) {
                _categoryResponseState.value =
                    _categoryResponseState.value.copy(loading = false, error = e.message.toString())
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}