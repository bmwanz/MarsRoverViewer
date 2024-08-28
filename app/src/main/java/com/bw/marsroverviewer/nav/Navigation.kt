package com.bw.marsroverviewer.nav

import androidx.navigation.NavController
import com.bw.marsroverviewer.nav.Destinations.Home

object Destinations {
    const val Home = "Home"
    const val Manifest = "manifest/{roverName}"
}

class Action(navController: NavController) {
    val home: () -> Unit = { navController.navigate(Home) }
    val manifest: (roverName: String) -> Unit = { roverName ->
        navController.navigate("manifest/${roverName}")
    }
}