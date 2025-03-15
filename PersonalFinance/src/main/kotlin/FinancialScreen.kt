// FinancialScreen.kt
package PersonalFinanceKt // Ensure this matches your project's package name

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import Main.Screen // Import the Screen sealed class if it's in another file

@Composable
fun FinancialScreen(navigateTo: (Main.Screen) -> Unit) {
    Column {
        Text("Financial Overview")
        // Here, you could add UI elements to display expenses, incomes, etc.
        Button(onClick = { navigateTo(Screen.Home) }) {
            Text("Back to Home")
        }
    }
}
