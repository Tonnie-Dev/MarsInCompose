package com.uxstate.marsincompose.domain.model

import com.squareup.moshi.Json

data class Estate(val id: String,
                  val imgSrc: String,
                  val price: Int,
                  val type: String)
