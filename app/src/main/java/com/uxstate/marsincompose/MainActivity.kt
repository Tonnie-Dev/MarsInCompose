package com.uxstate.marsincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uxstate.marsincompose.presentation.Screens
import com.uxstate.marsincompose.presentation.estatedetails.EstateDetailsScreen
import com.uxstate.marsincompose.presentation.estatelist.EstateListScreen
import com.uxstate.marsincompose.ui.theme.MarsInComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Timber.i("Inside MainActivity")
            MarsInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {


                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screens.OVERVIEWSCREEN.route
                    ){

                        composable(route = Screens.OVERVIEWSCREEN.route){
                            EstateListScreen(navController = navController)

                        }
                        
                        composable(route = "${Screens.DETAILSSCREEN.route}/{estateId13}"){

                            
                            EstateDetailsScreen()
                        }
                    }




                }
            }
        }
    }
}

