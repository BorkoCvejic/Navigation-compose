package com.easycruise.navigation_compose_practice.screens.settings_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SettingsScreen() {
    val itemList = mutableListOf("")

    for (i in 1..30) {
        itemList.add(i.toString())
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(itemList) { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {

                        }
                )
            }
        }
    }
}
