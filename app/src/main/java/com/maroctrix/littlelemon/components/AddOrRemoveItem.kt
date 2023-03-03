package com.maroctrix.littlelemon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maroctrix.littlelemon.ui.theme.PrimaryGray

@Composable
fun AddOrRemoveItem(onButtonsPressed: (Int) -> Unit) {
    var counter by remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(44.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleIconButton(
            icon = Icons.Default.KeyboardArrowLeft
        ) {
            if (counter > 1) {
                counter--
                onButtonsPressed.invoke(counter)
            }
        }
        Text(
            text = counter.toString(),
            color = PrimaryGray,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        CircleIconButton(
            icon = Icons.Default.KeyboardArrowRight
        ) {
            if (counter < 20) {
                counter++
                onButtonsPressed.invoke(counter)
            }
        }
    }
}