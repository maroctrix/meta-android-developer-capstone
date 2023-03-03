package com.littlelemon.littlelemon.presentation.register

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.Constants.DARK_MODE
import com.littlelemon.littlelemon.Constants.EMAIL_PREF
import com.littlelemon.littlelemon.Constants.FIRST_NAME_PREF
import com.littlelemon.littlelemon.Constants.IS_REGISTERED_PREF
import com.littlelemon.littlelemon.Constants.LAST_NAME_PREF
import com.littlelemon.littlelemon.Constants.LIGHT_MODE
import com.littlelemon.littlelemon.Constants.PREF_NAME
import com.littlelemon.littlelemon.R
import com.littlelemon.littlelemon.core.navigation.HomeScreen
import com.littlelemon.littlelemon.ui.theme.DarkGray
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme
import com.littlelemon.littlelemon.ui.theme.PrimaryGray
import com.littlelemon.littlelemon.ui.theme.Yellow

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OnBoarding(navController: NavHostController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    LazyColumn(
        Modifier.fillMaxSize()
    ) {
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
                Row(
                    modifier = Modifier
                        .background(color = PrimaryGray)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.on_boarding_header),
                        modifier = Modifier
                            .weight(1f)
                            .padding(55.dp),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
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
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text(text = stringResource(id = R.string.first_name)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Yellow,
                            unfocusedBorderColor = DarkGray
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                        ),
                    )
                    OutlinedTextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text(text = stringResource(id = R.string.last_name)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Yellow,
                            unfocusedBorderColor = DarkGray
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                        ),
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = stringResource(id = R.string.email)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Yellow,
                            unfocusedBorderColor = DarkGray
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                        ),
                        keyboardActions = KeyboardActions {
                            KeyboardActions(onDone = {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                            })
                        }
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    onClick = {
                        if (firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()) {
                            showMessage(context.getString(R.string.registration_success), context)
                            sharedPreferences.edit(commit = true) {
                                putBoolean(IS_REGISTERED_PREF, true)
                            }
                            sharedPreferences.edit(commit = true) {
                                putString(FIRST_NAME_PREF, firstName)
                            }
                            sharedPreferences.edit(commit = true) {
                                putString(LAST_NAME_PREF, lastName)
                            }
                            sharedPreferences.edit(commit = true) {
                                putString(EMAIL_PREF, email)
                            }
                            navController.navigate(HomeScreen.route)
                        } else {
                            showMessage(context.getString(R.string.registration_failed), context)
                        }
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
                    Text(text = stringResource(id = R.string.register))
                }
            }
        }
    }
}

private fun showMessage(message: String, context: Context) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
@Preview(name = LIGHT_MODE)
@Preview(name = DARK_MODE, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun OnBoardingPreview() {
    LittleLemonTheme {
        Surface {
            val navController = rememberNavController()
            OnBoarding(navController)
        }
    }
}