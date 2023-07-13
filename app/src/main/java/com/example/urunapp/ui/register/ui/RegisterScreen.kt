package com.example.urunapp.ui.register.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.urunapp.R
import com.example.urunapp.graphs.AuthScreen

import com.example.urunapp.network.retrofit.RetrofitInstance
import com.example.urunapp.network.service.AuthService
import com.example.urunapp.repository.CredentialsRepository

@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel) {
    val authService: AuthService = RetrofitInstance.getLoginService()
    val repository = CredentialsRepository(api = authService)

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Register(
            modifier = Modifier.align(Alignment.Center),
            viewModel = viewModel,
            navController = navController,
            repository = repository
        )
    }
}




@Composable
fun Register(modifier: Modifier,
             viewModel: RegisterViewModel,
             navController: NavController,
             repository: CredentialsRepository) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val name: String by viewModel.name.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(email) { viewModel.email.value = it }
        Spacer(modifier = Modifier.padding(4.dp))
        UserField(name) { viewModel.name.value = it }
        Spacer(modifier = Modifier.padding(8.dp))
        PasswordField(password) { viewModel.password.value = it }
        Spacer(modifier = Modifier.padding(16.dp))
        RegisterButton(navController, viewModel, repository)
        Spacer(modifier = Modifier.padding(16.dp))
        AccountHave(Modifier.align(Alignment.CenterHorizontally), modifier.padding(PaddingValues(16.dp)), navController = navController)
        Spacer(modifier = Modifier.padding(16.dp))
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onEmailChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = onEmailChanged,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
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
fun AccountHave(
    modifier: Modifier = Modifier,
    padding: Modifier = Modifier,
    navController: NavController
) {
    Text(
        text = "Ya tienes una cuenta? Inicia sesión",
        modifier = modifier.clickable { navController.navigate(AuthScreen.LoginScreen.route) },
        // Navega a LoginScreen
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFCCFF00),
    )
}


@Composable
fun RegisterButton(navController: NavController, viewModel: RegisterViewModel, repository: CredentialsRepository) {
    val status: RegisterUiStatus by viewModel.status.observeAsState(RegisterUiStatus.Resume)

    Button(
        onClick = {
            viewModel.onRegister()
            if (status == RegisterUiStatus.Success) {
                navController.navigate(AuthScreen.LoginScreen.route)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFCCFF00),
            contentColor = Color(0xFF1E1E1E)
        )
    ) {
        Text(text = "Registrarse")
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onPasswordChanged: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = onPasswordChanged,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E),
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField(name: String, onNameChanged: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = onNameChanged,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Usuario") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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

