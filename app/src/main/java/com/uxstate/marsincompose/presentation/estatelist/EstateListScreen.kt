package com.uxstate.marsincompose.presentation.estatelist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.uxstate.marsincompose.R
import com.uxstate.marsincompose.presentation.Screens
import com.uxstate.marsincompose.presentation.estatelist.components.MarsEstateItem

@ExperimentalFoundationApi
@Composable
fun EstateListScreen(
    navController: NavController,
    viewModel: EstateViewModel = hiltViewModel()
) {


    val state by viewModel.state

    val list by remember { mutableStateOf(state.estates) }

    Box(modifier = Modifier.fillMaxSize()) {

        val listState = rememberLazyListState()
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),

            contentPadding = PaddingValues(2.dp)
        ) {


            items(state.estates) {

                    estate ->

                MarsEstateItem(estate = estate, onItemClick = {

marsEstate ->
                    navController.navigate("${Screens.DETAILSSCREEN.route}/${marsEstate.id}")


                })
            }
        }


        if (state.isLoading) {

            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

        }

        if (state.error.isNotBlank()) {

            Image(
                painter = painterResource(id = R.drawable.ic_broken_image),
                contentDescription = null,
                modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center)
            )
        }
    }


}