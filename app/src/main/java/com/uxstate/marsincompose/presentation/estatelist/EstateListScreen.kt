package com.uxstate.marsincompose.presentation.estatelist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.uxstate.marsincompose.presentation.EstateViewModel

@ExperimentalFoundationApi
@Composable
fun EstateListScreen(
    navController: NavController,
    viewModel: EstateViewModel = hiltViewModel()
) {


    val state by viewModel.state


    Box(modifier = Modifier.fillMaxSize()){

        LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(5.dp)){}
    }

}