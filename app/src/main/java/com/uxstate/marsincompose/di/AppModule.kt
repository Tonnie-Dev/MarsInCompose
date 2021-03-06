package com.uxstate.marsincompose.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.marsincompose.data.remote.MarsEstateAPI
import com.uxstate.marsincompose.data.repository.EstateRepositoryImpl
import com.uxstate.marsincompose.domain.repo.EstateRepository
import com.uxstate.marsincompose.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/*Here we define the dependencies that we have to tell Hilt
* the way to created the dependencies*/

/*annotate with SingletonComponent to imply this needs to live
* as long as our application lives - this implies that all the
* dependencies in this module live as long as the application*/


/*@InstallIn tells Hilt the containers where the bindings are
available by specifying a Hilt component.

You can think of a Hilt component as a container. */
@Module
@InstallIn(SingletonComponent::class)

object AppModule {

/*using MoshiBuilder to create MoshiObject i.e. the
JSON-String-to-Kotlin-Object converter*/

/*For Moshi's annotations to work properly with Kotlin
add the KotlinJsonAdapterFactory*/

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

/*We can annotate a function with @Provides in Hilt modules to tell
 Hilt how to provide types that cannot be constructor injected.*/


    //1. API - dependency to be injected
    @Provides
    @Singleton
    fun providesAPIDependency(): MarsEstateAPI {
        //Retrofit is not on our project - so we need builder to create its instance
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MarsEstateAPI::class.java)
    }


//2. REPO Dependency to be injected - it returns the real repo (an implementation of the interface)

    @Provides
    @Singleton
    fun providesEstateRepository(api: MarsEstateAPI): EstateRepository {

        return EstateRepositoryImpl(api = api)
    }
}