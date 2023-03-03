package com.maroctrix.littlelemon.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.maroctrix.littlelemon.Constants.DEFAULT_CATEGORY
import com.maroctrix.littlelemon.Constants.DESSERTS_CATEGORY
import com.maroctrix.littlelemon.Constants.DRINKS_CATEGORY
import com.maroctrix.littlelemon.Constants.MAINS_CATEGORY
import com.maroctrix.littlelemon.Constants.STARTERS_CATEGORY
import com.maroctrix.littlelemon.R
import com.maroctrix.littlelemon.ui.theme.DarkGray
import com.maroctrix.littlelemon.ui.theme.Gray
import com.maroctrix.littlelemon.ui.theme.LightGray

@Composable
fun MenuCategories(onItemClick: (String) -> Unit) {
    val categories = listOf(
        STARTERS_CATEGORY, MAINS_CATEGORY, DESSERTS_CATEGORY, DRINKS_CATEGORY, DEFAULT_CATEGORY
    )
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.order_for_delivery),
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            items(categories) { category ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onItemClick(category) },
                    shape = RoundedCornerShape(26.dp),
                    backgroundColor = LightGray
                ) {
                    Text(
                        text = category,
                        textAlign = TextAlign.Center,
                        color = DarkGray,
                        modifier = Modifier.padding(8.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Divider(color = Gray, thickness = 1.dp, modifier = Modifier.padding(top = 24.dp))
    }
}