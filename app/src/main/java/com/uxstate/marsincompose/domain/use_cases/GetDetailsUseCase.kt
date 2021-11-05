package com.uxstate.marsincompose.domain.use_cases

import com.uxstate.marsincompose.domain.repo.EstateRepository
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val repo:EstateRepository) {


    operator fun invoke()
}