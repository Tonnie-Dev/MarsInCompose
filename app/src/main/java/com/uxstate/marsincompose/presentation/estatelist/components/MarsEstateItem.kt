package com.uxstate.marsincompose.presentation.estatelist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberImagePainter
import com.uxstate.marsincompose.domain.model.Estate

@Composable
fun MarsEstateItem(
    estate: Estate, onItemClick: (Estate) -> Unit
) {
    val imgUri = estate.imgSrc.toUri()
        .buildUpon()
        .scheme("https")
        .build()

    Box(modifier = Modifier.clickable { onItemClick(estate) }) {

        Image(
            painter = rememberImagePainter(
                data = imgUri ,
                builder = { crossfade(true) }
            ),
            contentDescription = null,
            modifier = Modifier.size(50.dp, 50.dp).padding(4.dp)
        )


    }

}

@Preview(name = "MarsEstateItem")
@Composable
fun MarsEstateItemPreview() {

    val estate = Estate(
        id = "424913",
        imgSrc = "https://picsum.photos/300/300",
        price = 13,
        type = "rent"
    )
    MarsEstateItem(
        estate = estate, onItemClick = {}
    )
}