package com.maroctrix.littlelemon.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maroctrix.littlelemon.Constants
import com.maroctrix.littlelemon.Constants.BUTTON_ICON
import com.maroctrix.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun CircleIconButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
   Box(
       modifier = Modifier.padding(10.dp)
   ) {
       Box(
           modifier = Modifier
               .padding(5.dp)
               .background(
                   color = MaterialTheme.colors.surface,
                   shape = CircleShape
               )
               .clickable { onClick() }
       ) {
           Icon(
               icon,
               contentDescription = BUTTON_ICON,
               modifier = Modifier.padding(5.dp)
           )
       }
   }
}


@Composable
@Preview(name = Constants.LIGHT_MODE)
@Preview(name = Constants.DARK_MODE, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewCircleIconButton() {
    LittleLemonTheme {
       Surface {
           CircleIconButton(icon = Icons.Default.FavoriteBorder) {}
       }
   }
}

