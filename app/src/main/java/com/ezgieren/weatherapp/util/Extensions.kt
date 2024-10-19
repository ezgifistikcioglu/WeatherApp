package com.ezgieren.weatherapp.util

import android.view.View
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}
// LiveData callback functions
fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

object AppPadding {
    val xSmallPadding = 1.dp
    val smallPadding = 4.dp
    val normalPadding = 8.dp
    val normal2xPadding = 16.dp
    val symmetricPadding = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
}
fun Modifier.paddingNormal() = this.padding(AppPadding.normalPadding)
fun Modifier.paddingSmall() = this.padding(AppPadding.smallPadding)
fun Modifier.paddingXSmall() = this.padding(AppPadding.xSmallPadding)
fun Modifier.paddingNormal2x() = this.padding(AppPadding.normal2xPadding)
fun Modifier.paddingSymmetric() = this.then(AppPadding.symmetricPadding)

//  An extension function for the TextField
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = Constants.ENTER_CITY,
    onSearch: () -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearch() }
        )
    )
}

// An extension function for the Button
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Text(text)
    }
}