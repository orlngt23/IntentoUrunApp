package com.example.urunapp.ui.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.urunapp.R
import com.example.urunapp.graphs.AuthScreen


@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {
    val email: String by viewModel.email.observeAsState("")
    val password: String by viewModel.password.observeAsState("")
    val status: LoginUiStatus by viewModel.status.observeAsState(LoginUiStatus.Resume)

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
            .padding(horizontal = 20.dp)
    ) {
        Login(
            Modifier.align(Alignment.Center),
            email = email,
            password = password,
            onEmailChanged = { updatedEmail: String ->
                viewModel.email.value = updatedEmail
            },
            onPasswordChanged = { updatedPassword: String ->
                viewModel.password.value = updatedPassword
            },
            onLoginSelected = { viewModel.onLogin() },
            navController = navController,
            viewModel = viewModel
        )

        when (status) {
            is LoginUiStatus.ErrorWithMessage -> {
                // Display error message
                Text(
                    text = (status as LoginUiStatus.ErrorWithMessage).message,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
            is LoginUiStatus.Success -> {
            }
            else -> Unit
        }
    }
}

@Composable
fun Login(
    modifier: Modifier,
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginSelected: () -> Unit,
    navController: NavController,
    viewModel: LoginViewModel
) {
    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(email, onEmailChanged)
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(password, onPasswordChanged)
        Spacer(modifier = Modifier.padding(8.dp))
        LoginButton(navController, onLoginSelected, viewModel)
        Spacer(modifier = Modifier.padding(16.dp))
        ForgotPassword(Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun LoginButton(navController: NavController,onLoginSelected: () -> Unit, viewModel: LoginViewModel) {
    val status: LoginUiStatus by viewModel.status.observeAsState(LoginUiStatus.Resume)
    Button(
        onClick = {if(status is LoginUiStatus.Success) {
            navController.navigate(AuthScreen.WelcomeScreen.route)
        }else {
            onLoginSelected()
        }},

        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFCCFF00),
            disabledContainerColor = Color(0xFFCCFF00),
            contentColor = Color(0xFF1E1E1E),
            disabledContentColor = Color(0xFF1E1E1E)
        )
    ) {
        Text(
            text = "Iniciar Sesión"
        )
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Olvidaste la contraseña?",
        modifier = Modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFCCFF00),
    )
}

//@OptIn(ExperimentalMaterial3Api::class)
//
//@Composable
//fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
//    var hidden by remember { mutableStateOf(true) }
//    TextField(
//        value = password,
//        onValueChange = { updatedPassword: String -> onTextFieldChanged(updatedPassword) },
//        placeholder = { Text(text = "Contraseña") },
//        modifier = Modifier.fillMaxWidth(),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        singleLine = true,
//        maxLines = 1,
//        visualTransformation =
//        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
//        colors = TextFieldDefaults.textFieldColors(
//            textColor = Color(0xFFCCFF00),
//            containerColor = Color(0xFF1E1E1E),
//        )
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    var hidden by remember { mutableStateOf(true) }
    TextField(
        value = password,
        onValueChange = { updatedPassword: String -> onTextFieldChanged(updatedPassword) },
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E),
        ),
        trailingIcon = {
            val visibilityIcon =
                if (hidden) painterResource(id = R.drawable.nover)
                else painterResource(id = R.drawable.ver)
            IconButton(
                onClick = { hidden = !hidden },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    painter = visibilityIcon,
                    contentDescription = if (hidden) "Mostrar contraseña" else "Ocultar contraseña",
                    tint = Color(0xFFCCFF00)
                )
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { updatedEmail: String -> onTextFieldChanged(updatedEmail) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Correo Electrónico") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E),
        )
    )
}

@Composable
fun HeaderImage(Modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo1),
        contentDescription = "Header",
        modifier = Modifier
    )
}
