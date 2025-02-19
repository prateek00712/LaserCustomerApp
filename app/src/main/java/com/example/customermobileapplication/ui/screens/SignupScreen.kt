package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes

@Composable
fun SignUpScreen(navController: NavHostController) {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular) // Make sure the font file is in the `res/font` folder
    )
    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold) // Make sure the font file is in the `res/font` folder
    )
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE6A88E), // Pastel peach
                        Color(0xFFF6D9CB), // Lighter complementary color

                    )
                )
            ),// Light background
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f) // Make the card slightly smaller than the screen
                .padding(top = 48.dp,bottom = 48.dp, start = 16.dp, end = 16.dp), // Outer padding
            shape = RoundedCornerShape(16.dp), // Rounded corners
            elevation = CardDefaults.outlinedCardElevation(8.dp), // Shadow for the card
            colors = CardDefaults.cardColors(
                containerColor = Color.White // Background color of the card
            ),

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .verticalScroll(rememberScrollState()) // Enables scrolling
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login_logo), // Replace with your image resource
                    contentDescription = "Welcome Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                        .height(100.dp) ,// Adjust height as needed
                    alignment = Alignment.Center

                )
                // Title
                Text(
                    text = "Create an Account",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 24.dp),
                    textAlign = TextAlign.Justify
                )

                // First Name Field
                TextFieldLabel(label = "First Name*")
                OutlinedTextField(
                    value = firstName,
                    onValueChange = {firstName = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp
                    ),
                    placeholder = { Text("Enter your first name", color = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
//                colors = textFieldColors(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )

                // Last Name Field
                TextFieldLabel(label = "Last Name*")
                OutlinedTextField(
                    value = lastName,
                    onValueChange = {lastName = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp
                    ),
                    placeholder = { Text("Enter your last name", color = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
//                colors = textFieldColors(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )

                // Contact Number Field
                TextFieldLabel(label = "Contact Number*")
                OutlinedTextField(
                    value = number,
                    onValueChange = {number = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp
                    ),
                    placeholder = { Text("Enter your contact number", color = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
//                colors = textFieldColors(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    )
                )

                // Email Field
                TextFieldLabel(label = "Email Id*")
                OutlinedTextField(
                    value = email,
                    onValueChange = {email = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp
                    ),
                    placeholder = { Text("Enter your email", color = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
//                colors = textFieldColors(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )

                // Password Field
                TextFieldLabel(label = "Password*")
                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp
                    ),
                    placeholder = { Text("Enter your password", color = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
//                colors = textFieldColors(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    )
                )

                // Confirm Password Field
                TextFieldLabel(label = "Confirm Password*")
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = {confirmPassword},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp
                    ),
                    placeholder = { Text("Confirm your password", color = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
//                colors = textFieldColors(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )

                // Terms and Conditions Text
                Text(
                    text = "By signing-up you agree to our Terms & Conditions",
                    fontSize = 12.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // Sign Up Button
                Button(
                    onClick = { navController.navigate(Routes.HOME_SCREEN)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFA500), // Orange color
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFontFamily
                    )
                }

                // Footer Text
                Text(
                    text = "Already have an account? Login here",
                    fontSize = 12.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun TextFieldLabel(label: String) {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular) // Make sure the font file is in the `res/font` folder
    )
    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold) // Make sure the font file is in the `res/font` folder
    )

    Text(
        text = label,
        fontSize = 14.sp,
        fontFamily = poppinsFontFamily,
        color = Color.Gray,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}


