package com.maroctrix.littlelemon.presentation.profile

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maroctrix.littlelemon.Constants.DARK_MODE
import com.maroctrix.littlelemon.Constants.EMAIL_PREF
import com.maroctrix.littlelemon.Constants.FIRST_NAME_PREF
import com.maroctrix.littlelemon.Constants.IS_REGISTERED_PREF
import com.maroctrix.littlelemon.Constants.LAST_NAME_PREF
import com.maroctrix.littlelemon.Constants.LIGHT_MODE
import com.maroctrix.littlelemon.Constants.PREF_NAME
import com.maroctrix.littlelemon.R
import com.maroctrix.littlelemon.core.navigation.OnBoardingScreen
import com.maroctrix.littlelemon.ui.theme.DarkGray
import com.maroctrix.littlelemon.ui.theme.LittleLemonTheme
import com.maroctrix.littlelemon.ui.theme.Yellow

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    var firstName = sharedPreferences.getString(FIRST_NAME_PREF, "")
    var lastName = sharedPreferences.getString(LAST_NAME_PREF, "")
    var email = sharedPreferences.getString(EMAIL_PREF, "")

    LazyColumn {
        item {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillParentMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(140.dp),
                    contentScale = ContentScale.FillWidth,
                )
                Spacer(modifier = Modifier.height(46.dp))
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.personal_information),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    OutlinedTextField(
                        value = firstName ?: "",
                        onValueChange = { firstName = it },
                        label = { Text(text = stringResource(id = R.string.first_name)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 26.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Yellow,
                            unfocusedBorderColor = DarkGray,
                            disabledLabelColor = Color.Black,
                            disabledTextColor = Color.Black
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                        ),
                        enabled = false
                    )
                    OutlinedTextField(
                        value = lastName ?: "",
                        onValueChange = { lastName = it },
                        label = { Text(text = stringResource(id = R.string.last_name)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Yellow,
                            unfocusedBorderColor = DarkGray,
                            disabledLabelColor = Color.Black,
                            disabledTextColor = Color.Black
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                        ),
                        enabled = false
                    )
                    OutlinedTextField(
                        value = email ?: "",
                        onValueChange = { email = it },
                        label = { Text(text = stringResource(id = R.string.email)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Yellow,
                            unfocusedBorderColor = DarkGray,
                            disabledLabelColor = Color.Black,
                            disabledTextColor = Color.Black
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                        ),
                        enabled = false
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    onClick = {
                        sharedPreferences.edit(commit = true) {
                            putBoolean(IS_REGISTERED_PREF, false)
                        }
                        sharedPreferences.edit(commit = true) {
                            putString(FIRST_NAME_PREF, "")
                        }
                        sharedPreferences.edit(commit = true) {
                            putString(LAST_NAME_PREF, "")
                        }
                        sharedPreferences.edit(commit = true) {
                            putString(EMAIL_PREF, "")
                        }
                        navController.navigate(OnBoardingScreen.route)
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Yellow,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(16)
                ) {
                    Text(text = stringResource(id = R.string.log_out))
                }
            }
        }
    }
}

@Composable
@Preview(name = LIGHT_MODE)
@Preview(name = DARK_MODE, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ProfilePreview() {
    LittleLemonTheme {
        Surface {
            val navController = rememberNavController()
            Profile(navController)
        }
    }
}