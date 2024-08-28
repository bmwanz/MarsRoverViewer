package com.bw.marsroverviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bw.marsroverviewer.ui.theme.MarsRoverViewerTheme
import com.bw.marsroverviewer.ui.view.RoverList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MarsRoverViewerTheme {
                RoverList()
            }
        }
    }
}