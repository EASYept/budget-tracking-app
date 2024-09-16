package ru.cashwriter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import ru.cashwriter.AppScreens.FILL_FORM_SCREEN
import ru.cashwriter.AppScreens.TABLE_SCREEN
import ru.cashwriter.data.FillFormWindow


@Composable
fun TodoNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
//    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    startDestination: String = AppDestinations.TABLE_ROUTE,
    navActions: AppNavigationActions = remember(navController) {
        AppNavigationActions(navController)
    }
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(AppDestinations.TABLE_ROUTE) {
            TableScreen(navActions)
        }
        composable(AppDestinations.FILL_FORM_ROUTE) {
            FillFormWindow(navActions)
        }
    }
}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToFillForm() {
        navController.navigate(AppDestinations.FILL_FORM_ROUTE)
    }

    fun navigateToTable() {
        navController.navigate(AppDestinations.TABLE_ROUTE)
    }

}

private object AppScreens {
    const val TABLE_SCREEN = "table_screen"
    const val FILL_FORM_SCREEN = "fill_form_screen"
}

object AppDestinations {
    const val TABLE_ROUTE = "$TABLE_SCREEN"
    const val FILL_FORM_ROUTE = FILL_FORM_SCREEN
}
