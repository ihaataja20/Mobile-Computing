package com.example.mobilecomputing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobilecomputing.Conversation
import com.example.mobilecomputing.Message
import com.example.mobilecomputing.SampleData
import com.example.mobilecomputing.ui.theme.MobileComputingTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileComputingTheme {
                NavHost()
            }
        }
    }
}

@Composable
fun NavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "messages"
    ) {
        composable("messages") {
            Conversation(messages = SampleData.conversationSample, navController = navController)
        }
        composable("settings") {
            SettingsScreen(navController = navController)
        }
    }
}
