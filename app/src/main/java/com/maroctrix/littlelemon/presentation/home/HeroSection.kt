package com.maroctrix.littlelemon.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maroctrix.littlelemon.ui.theme.*
import com.maroctrix.littlelemon.R

@Composable
fun HeroSection(onPhraseSelected: (String) -> Unit) {
    var searchPhrase by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(color = PrimaryGray)
            .padding(start = 12.dp, end = 12.dp, bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 18.dp)
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.restaurant_name),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Yellow
                )
                Text(
                    text = stringResource(id = R.string.restaurant_city),
                    fontSize = 24.sp,
                    color = White
                )
                Text(
                    text = stringResource(id = R.string.short_description),
                    color = White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(bottom = 28.dp, end = 8.dp, top = 24.dp)
                        .fillMaxWidth(0.6f)
                )
            }
            Column(modifier = Modifier.padding(top = 48.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .size(170.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = searchPhrase,
            onValueChange = { searchPhrase = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    tint = Color.Black,
                    contentDescription = stringResource(R.string.search),
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = LightGray,
                focusedIndicatorColor = LightGray,
                unfocusedIndicatorColor = LightGray,
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
            ),
            label = {
                Text(
                    text = stringResource(id = R.string.enter_search_phrase),
                    color = DarkGray
                )
            })
    }

    if (searchPhrase.isNotEmpty()) onPhraseSelected(searchPhrase)
}