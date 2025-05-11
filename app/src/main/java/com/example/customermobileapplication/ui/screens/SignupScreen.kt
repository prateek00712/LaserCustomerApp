package com.example.customermobileapplication.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.PreferencesManager
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes
import java.util.Calendar

@Composable
fun RegisterScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular) // Make sure the font file is in the `res/font` folder
    )
    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold) // Make sure the font file is in the `res/font` folder
    )
    var selectedDay by remember { mutableStateOf(1) }
    var selectedMonth by remember { mutableStateOf(1) }
    var selectedYear by remember { mutableStateOf(2000) }
    val preferencesManager = PreferencesManager(context)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.GradientColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Heading
        Text(
            text = "Register now",
            fontSize = 28.sp,
            color = Color.Black,
            textAlign = TextAlign.Start,
            fontFamily = poppinsBoldFontFamily,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Tailored Treatments for every",
            fontSize = 20.sp,
            color = Color.Black.copy(alpha = 0.8f),
            textAlign = TextAlign.Start,
            fontFamily = poppinsBoldFontFamily,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "TEXTURE",
            fontSize = 20.sp,
            color = AppColors.Primary,
            textAlign = TextAlign.Start,
            fontFamily = poppinsBoldFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(32.dp))

        // Single Card containing everything
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // makes the card take available height nicely
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = AppColors.PastelPeach)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Name Section
                Text(
                    text = "We promise to remember your name!\nPlease tell us what it is?",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    fontFamily = poppinsBoldFontFamily,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(16.dp))
                // FIRST NAME TextField
                CustomTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    placeholder = "First Name"
                )
                Spacer(modifier = Modifier.height(8.dp))

                CustomTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    placeholder = "Last Name"
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Birthdate Section
                Text(
                    text = "We need your birthdate, but we won't let it show!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsBoldFontFamily
                )
                Spacer(modifier = Modifier.height(16.dp))

                SnapScrollableDatePicker { day, month, year ->

                    selectedDay = day
                    selectedMonth = month
                    selectedYear = year

                    // Calculate age
                    val today = Calendar.getInstance()
                    val birthDate = Calendar.getInstance().apply {
                        set(year, month - 1, day) // month is 0-based in Calendar
                    }
                    var age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)

                    // Adjust if birthdate hasn't occurred yet this year
                    if (today.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
                        age--
                    }

                    if (age < 18) {
                        Toast.makeText(
                            context,
                            "You must be 18 years or older.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(context, "Age verified: $age years old", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Gender Selection Section
                Text(
                    text = "How do you identify yourself?",
                    fontSize = 16.sp,
                    fontFamily = poppinsBoldFontFamily,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GenderOption(
                        label = "Female",
                        selected = selectedGender == "Female",
                        imageRes = R.drawable.ic_login_background_img,
                        onClick = { selectedGender = "Female" }
                    )
                    GenderOption(
                        label = "Male",
                        selected = selectedGender == "Male",
                        imageRes = R.drawable.ic_otp_background_img,
                        onClick = { selectedGender = "Male" }
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = selectedGender == "Prefer not to say",
                        onCheckedChange = {
                            selectedGender = if (it) "Prefer not to say" else null
                        },
                        colors = CheckboxDefaults.colors(checkedColor = AppColors.Primary) // Set checkbox color
                    )
                    Text(
                        text = "Prefer not to say",
                        color = Color.Black,
                        fontFamily = poppinsBoldFontFamily
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Bottom Arrow Button
        Button(
            onClick = {
                if (firstName.isNotBlank() && lastName.isNotBlank() && selectedGender != null) {
                    // All fields filled -> proceed
                    preferencesManager.saveName(firstName)
                    preferencesManager.saveLoginStatus(true)
                    navController.navigate(Routes.HOME_SCREEN)
                } else {
                    // Show error
                    Toast.makeText(context, "Please fill all the details.", Toast.LENGTH_SHORT)
                        .show()
                }
            },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.size(60.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "→",
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.offset(y = (-6).dp) // 🛑 🛑 Key Fix: move text 2dp UP
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}


@Composable
fun GenderOption(
    label: String,
    selected: Boolean,
    imageRes: Int,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) Color(0xFFEADBC8) else Color.Transparent)
            .border(
                BorderStroke(2.dp, if (selected) Color(0xFFB98068) else Color.Transparent),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = label,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular) // Make sure the font file is in the `res/font` folder
    )
    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold) // Make sure the font file is in the `res/font` folder
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            ),
            singleLine = true,
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily
                    )
                }
                innerTextField()
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SnapScrollableDatePicker(
    onDateSelected: (day: Int, month: Int, year: Int) -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Get today's date
    val todayDay = calendar.get(Calendar.DAY_OF_MONTH)
    val todayMonth = calendar.get(Calendar.MONTH) + 1 // Month is zero-based
    val todayYear = calendar.get(Calendar.YEAR)

    var selectedDay by remember { mutableStateOf(todayDay) }
    var selectedMonth by remember { mutableStateOf(todayMonth) }
    var selectedYear by remember { mutableStateOf(todayYear) }

    val days = (1..31).toList()
    val months = (1..12).toList()
    val years = (1900..2025).toList()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SnapColumnPicker(
            items = days,
            selectedItem = selectedDay,
            onItemSelected = { day ->
                selectedDay = day
//                showDateToast(context, selectedDay, selectedMonth, selectedYear)
                onDateSelected(day, selectedMonth, selectedYear)
            }
        )

        SnapColumnPicker(
            items = months,
            selectedItem = selectedMonth,
            onItemSelected = { month ->
                selectedMonth = month
//                showDateToast(context, selectedDay, selectedMonth, selectedYear)
                onDateSelected(selectedDay, month, selectedYear)
            }
        )

        SnapColumnPicker(
            items = years,
            selectedItem = selectedYear,
            onItemSelected = { year ->
                selectedYear = year
//                showDateToast(context, selectedDay, selectedMonth, selectedYear)
                onDateSelected(selectedDay, selectedMonth, year)
            }
        )
    }
}

@Composable
fun SnapColumnPicker(
    items: List<Int>,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    val listState = rememberLazyListState()
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular) // Make sure the font file is in the `res/font` folder
    )
    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold) // Make sure the font file is in the `res/font` folder
    )
    LaunchedEffect(selectedItem) {
        val index = items.indexOf(selectedItem)
        if (index >= 0) {
            listState.scrollToItem(index)
        }
    }

    LazyColumn(
        state = listState,
        modifier = Modifier
            .height(150.dp)
            .width(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(items) { item ->
            Text(
                text = item.toString().padStart(2, '0'),
                fontSize = if (item == selectedItem) 22.sp else 18.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = if (item == selectedItem) FontWeight.Bold else FontWeight.Normal,
                color = if (item == selectedItem) Color.Black else Color.Gray,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable {
                        onItemSelected(item)
                    }
            )
        }
    }
}

fun showDateToast(context: Context, day: Int, month: Int, year: Int) {
    Toast.makeText(context, "Selected: $day/$month/$year", Toast.LENGTH_SHORT).show()
}
