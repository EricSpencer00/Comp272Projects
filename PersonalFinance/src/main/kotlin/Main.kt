import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

sealed class Screen {
    object Home : Screen()
    object Node1 : Screen()
    object Node2 : Screen()
}

@Composable
@Preview
fun App(currentScreen: Screen, navigateTo: (Screen) -> Unit) {
    MaterialTheme {
        when (currentScreen) {
            is Screen.Home -> HomeScreen(navigateTo)
            is Screen.Node1 -> Node1Screen(navigateTo)
            is Screen.Node2 -> Node2Screen(navigateTo)
        }
    }
}

@Composable
fun HomeScreen(navigateTo: (Screen) -> Unit) {
    Column {
        Button(onClick = { navigateTo(Screen.Node1) }) {
            Text("Go to Node 1")
        }
        Button(onClick = { navigateTo(Screen.Node2) }) {
            Text("Go to Node 2")
        }
        // Add more buttons for navigating to other nodes
    }
}

@Composable
fun Node1Screen(navigateTo: (Screen) -> Unit) {
    Column {
        Text("Node 1")
        Button(onClick = { navigateTo(Screen.Home) }) {
            Text("Back to Home")
        }
        // Add more buttons or content specific to Node 1
    }
}

@Composable
fun Node2Screen(navigateTo: (Screen) -> Unit) {
    Column {
        Text("Node 2")
        Button(onClick = { navigateTo(Screen.Home) }) {
            Text("Back to Home")
        }
        // Add more buttons or content specific to Node 2
    }
}

fun main() = application {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }
    val navigateTo: (Screen) -> Unit = { screen ->
        currentScreen = screen
    }

    Window(onCloseRequest = ::exitApplication) {
        App(currentScreen, navigateTo)
    }
}
