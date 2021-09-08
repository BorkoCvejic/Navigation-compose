package com.easycruise.navigation_compose_practice.screens.home_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.easycruise.navigation_compose_practice.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    var nameInput by remember {
        mutableStateOf("")
    }

    var isError by remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 200.dp)
    ) {
        TextField(
            value = nameInput,
            onValueChange = { newInput ->
                nameInput = newInput
                isError = false
            },
            label = {
                Text(text = "Name")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xffd8e6ff),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xffd8e6ff),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color(0xff76a9ff),
                errorCursorColor = Color.Red,
                errorIndicatorColor = Color.Red,
                errorTrailingIconColor = Color.Red,
            ),
            isError = isError
        )
        if (isError) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Name can't be empty",
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (nameInput.isEmpty()) {
                    isError = true
                } else {
                    navController.navigate(Screen.DetailScreen.withArgs(nameInput))
                }
            }
        ) {
            Text(text = "To DetailScreen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}