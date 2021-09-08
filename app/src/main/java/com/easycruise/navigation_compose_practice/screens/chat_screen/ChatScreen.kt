package com.easycruise.navigation_compose_practice.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview
@ExperimentalPagerApi
@Composable
fun ChatScreen() {
    val pages = remember {
        listOf("News", "Shows", "Movies", "Books")
    }

    Column(Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(pages.size)
        val composableScope = rememberCoroutineScope()

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(
                        pagerState = pagerState,
                        tabPositions = tabPositions
                    )
                )
            }
        ) {
            pages.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        composableScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState
        ) { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                Card(Modifier.padding(16.dp)) {
                    Box(Modifier.fillMaxSize()) {
                        if (page != 1) {
                            Text(
                                text = "Page: ${pages[page]}",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        } else {
                            Image(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}
