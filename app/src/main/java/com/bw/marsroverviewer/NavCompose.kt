package com.bw.marsroverviewer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bw.marsroverviewer.nav.Action
import com.bw.marsroverviewer.nav.Destinations
import com.bw.marsroverviewer.ui.theme.MarsRoverViewerTheme
import com.bw.marsroverviewer.ui.view.ManifestScreen
import com.bw.marsroverviewer.ui.view.RoverList

@Composable
fun NavCompose() {

    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }

    MarsRoverViewerTheme {
        NavHost(navController = navController, startDestination = Destinations.Home) {
            composable(Destinations.Home) {
                RoverList() { roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(Destinations.Manifest) { backStackEntry ->
                backStackEntry.arguments?.getString("roverName")?.let {
                    ManifestScreen(
                        roverName = it
                    )
                }
            }
        }
    }

}