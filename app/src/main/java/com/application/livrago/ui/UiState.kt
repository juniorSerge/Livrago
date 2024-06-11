package com.application.livrago.ui

import com.application.livrago.domain.model.Blog
import com.application.livrago.domain.model.User

data class UiState(
    val isSignInSuccessfull : Boolean = false,
    val signinError : String? = null,
    val currentUser: User? = null,
    val isLoading : Boolean = false,
    val blogs : List<Blog> = emptyList()
)