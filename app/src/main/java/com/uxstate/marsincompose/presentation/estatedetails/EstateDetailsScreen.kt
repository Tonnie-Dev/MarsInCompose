package com.uxstate.marsincompose.presentation.estatedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.presentation.estatedetails.components.DetailImage
import com.uxstate.marsincompose.presentation.estatedetails.components.PriceHeaderText
import com.uxstate.marsincompose.presentation.estatedetails.components.TypeHeaderText


@Composable
fun EstateDetailsScreen(estate: Estate) {

    Column(modifier = Modifier.fillMaxSize()) {

        DetailImage(estate = estate)
        TypeHeaderText(estate = estate)
        PriceHeaderText(estate = estate)
    }

}