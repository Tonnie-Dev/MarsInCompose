package com.uxstate.marsincompose.presentation.estatedetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberImagePainter
import com.uxstate.marsincompose.R
import com.uxstate.marsincompose.domain.model.Estate


@Composable
fun DetailImage(estate: Estate) {

    val imgUri = estate.imgSrc.toUri()
        .buildUpon()
        .scheme("https")
        .build()

    Image(
        painter = rememberImagePainter(
            data = imgUri,
            builder = {
                crossfade(true)
                placeholder(R.drawable.loading_animation)
            }
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth().height(300.dp)
            .padding(16.dp)

    )


}


@Composable
fun TypeHeaderText(estate: Estate) {


    Text(
        text = if (estate.type == "rent")
            stringResource(id = R.string.type_rent)
        else
            stringResource(id = R.string.type_sale)
    )

}

@Composable
fun PriceHeaderText(estate: Estate){
    
    if (estate.type=="rent"){

        Text(text = stringResource(id = R.string.display_price_monthly_rental, estate.price.toDouble()))

    }else{
        Text(text = stringResource(id = R.string.display_price, estate.price.toDouble()))

    }

}