package com.uxstate.marsincompose.presentation.estatelist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberImagePainter
import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.R
@Composable
fun MarsEstateItem(
    estate: Estate, isLoading:Boolean, onItemClick: (Estate) -> Unit
) {


    val imgUri = estate.imgSrc.toUri()
        .buildUpon()
        .scheme("https")
        .build()

    Box(modifier = Modifier.clickable { onItemClick(estate) }) {

        Image(
            painter = rememberImagePainter(
                data = imgUri ,
                builder = { crossfade(true)
                    placeholder(R.drawable.loading_img) }

            ),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp, 50.dp)
                .padding(4.dp)
        )

        if (estate.type=="rent"){
            
            Image(
                painter = painterResource(id = R.drawable.ic_for_sale_outline),
                contentDescription = null,
                modifier = Modifier
                    .padding(2.dp)
                    .size(10.dp)

                    .align(Alignment.BottomStart)
            )
        }



    }

}

@Preview(name = "MarsEstateItem")
@Composable
fun MarsEstateItemPreview() {
//https://android-kotlin-fun-mars-server.appspot.com/realestate

val url =  "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"
    val estate = Estate(
        id = "424913",
        imgSrc = url,
        price = 13,
        type = "rent"
    )
    MarsEstateItem(
        estate = estate, false, onItemClick = {}
    )
}