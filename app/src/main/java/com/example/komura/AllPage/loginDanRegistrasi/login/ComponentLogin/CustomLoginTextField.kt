package com.example.komura.AllPage.loginDanRegistrasi.registrasi.ComponentRegistrasi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomLoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    placeholder: String = "",
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        content = {
            TextField(
                value = value,
                onValueChange = { newName ->
                    onValueChange(newName)
                },
                placeholder = { Text(text = placeholder) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions.Default,
                singleLine = true,
                label = {
                    Text(text = label)
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()

            )
            Divider(color = Color.Black, modifier = Modifier.padding(start = 15.dp,end = 15.dp))
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomTextFieldPrev() {
    CustomLoginTextField("",{},"Name","Your Name", modifier = Modifier.padding(10.dp))
}