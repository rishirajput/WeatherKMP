package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.stringResource
import org.rishirajput.weatherkmp.domain.errors.InvalidCityException
import org.rishirajput.weatherkmp.domain.errors.NoNetworkException
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.invalid_city_name
import weather.composeapp.generated.resources.network_error

/**
 * Displays an error message in a Snackbar based on the error emitted from the errorFlow.
 *
 * @param snackBarHostState The state of the Snackbar host.
 * @param errorFlow A Flow that emits Throwable errors.
 */
@Composable
fun ErrorSnackBar(snackBarHostState: SnackbarHostState, errorFlow: Flow<Throwable>) {
    val networkErrorMessage = stringResource(Res.string.network_error)
    val invalidCityErrorMessage = stringResource(Res.string.invalid_city_name)

    LaunchedEffect(Unit) {
        errorFlow.collectLatest { error ->
            val errorMessage = when (error) {
                is NoNetworkException -> networkErrorMessage
                is InvalidCityException -> invalidCityErrorMessage
                else -> ""
            }
            if (errorMessage.isNotEmpty()) {
                snackBarHostState.showSnackbar(errorMessage)
            }
        }
    }
}