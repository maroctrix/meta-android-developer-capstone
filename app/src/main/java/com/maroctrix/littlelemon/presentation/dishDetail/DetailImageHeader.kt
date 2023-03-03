package com.maroctrix.littlelemon.presentation.dishDetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.maroctrix.littlelemon.components.CircleIconButton
import com.maroctrix.littlelemon.database.MenuItemRoom

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailImageHeader(
    modifier: Modifier = Modifier,
    menuItem: MenuItemRoom,
    onBackButtonClicked: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.TopCenter
        ) {
            GlideImage(
                model = menuItem.image,
                contentDescription = menuItem.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CircleIconButton(
                    icon = Icons.Default.ArrowBack
                ) { onBackButtonClicked.invoke() }
                CircleIconButton(
                    icon = Icons.Default.FavoriteBorder
                ) {}
            }
        }
    }
}