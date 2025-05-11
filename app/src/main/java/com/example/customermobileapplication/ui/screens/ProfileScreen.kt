package com.example.customermobileapplication.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.PreferencesManager
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel

@Composable
fun ProfileScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
){
    var selectedTab by remember { mutableStateOf("My Profile") }
    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB))
            .padding(16.dp)
    ) {
        // Header Card
        Card(
            colors = CardDefaults.cardColors(AppColors.Primary), // Orange
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("${preferencesManager.getName()}", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 18.sp)
                Text("${preferencesManager.getPhoneNumber()}", color = Color.White, fontSize = 14.sp)
            }
        }

        // Navigation Menu
        Card(
            shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column {
                listOf("My Profile", "Address", "My Appointments", "My Orders").forEach { item ->
                    val isSelected = item == selectedTab
                    val bgColor = if (isSelected) AppColors.NewButtonColor2 else Color.Transparent

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(bgColor)
                            .clickable { selectedTab = item }
                            .padding(12.dp)
                    ) {
                        val icon = when (item) {
                            "My Profile" -> Icons.Default.Person
                            "Address" -> Icons.Default.LocationOn
                            "My Appointments" -> Icons.Default.DateRange
                            "My Orders" -> Icons.Default.ShoppingCart
                            else -> Icons.Default.Info
                        }
                        Icon(icon, contentDescription = null, tint = AppColors.TextPrimary)
                        Spacer(Modifier.width(8.dp))
                        Text(item, fontFamily = FontFamily(Font(R.font.poppins_medium)), color = AppColors.TextPrimary)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Content Based on Selection
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            when (selectedTab) {
                "My Profile" -> ProfileView(
                    preferencesManager.getName().toString(),
                    preferencesManager.getPhoneNumber().toString(),
                    gender = "Male",
                    email = preferencesManager.getUserName().toString(),
                    modifier = Modifier.fillMaxWidth()
                )
                "Address" -> AddressView()
                "My Appointments" -> AppointmentsView()
                "My Orders" -> OrdersView()
            }
        }
    }
}

@Composable
fun ProfileView(
    fullName: String,
    phone: String,
    gender: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
//            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
//            .padding(16.dp)
    ) {
        // Note
        /*Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Note: ")
                }
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append("Please update your profile!")
                }
            },
            fontFamily = FontFamily(Font(R.font.poppins_medium))
        )

        Spacer(modifier = Modifier.height(12.dp))*/

        // Header
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Personal Information",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AppColors.TextPrimary,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                tint = AppColors.Primary,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { /* Handle edit click */ }
            )
        }

        Divider(
            color = AppColors.Primary.copy(alpha = 0.2f),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
        )

        // Info rows
        ProfileItem(label = "Full Name", value = fullName)
        ProfileItem(label = "Phone", value = phone)
        ProfileItem(label = "Gender", value = gender)
        ProfileItem(label = "Email Id", value = email)
    }
}

@Composable
fun ProfileItem(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)) {
        Text(
            text = label,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.poppins_medium))
        )
        Text(
            text = value,
            color = AppColors.TextSecondary,
            fontFamily = FontFamily(Font(R.font.poppins_medium))
        )
    }
}

@Composable
fun AddressView() {
    Column(modifier = Modifier.background(Color.White).fillMaxWidth().wrapContentHeight().verticalScroll(rememberScrollState())) {
        Text("My Address", fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = AppColors.Primary, fontSize = 20.sp, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp).fillMaxWidth())
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Add padding to the sides
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary)
        ) {
            Icon(
                imageVector = Icons.Default.Add, // Built-in "+" icon
                contentDescription = "Add",
                tint = Color.White,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
            Text(
                text = "Add Address",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 14.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun AppointmentsView() {
    Column(modifier = Modifier.background(Color.White).fillMaxSize().verticalScroll(rememberScrollState())) {
        Text("My Appointments", fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = AppColors.Primary, fontSize = 20.sp, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp).fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_no_appointment_img),
            contentDescription = null,
            modifier = Modifier.height(150.dp).fillMaxWidth(),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Text("No appointments scheduled for now.", fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = AppColors.Primary, fontSize = 16.sp, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth())
    }
}

@Composable
fun OrdersView() {
    Column(modifier = Modifier.background(Color.White).fillMaxSize().verticalScroll(rememberScrollState())) {
        Text("My Orders", fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = AppColors.Primary, fontSize = 20.sp, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp).fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_no_orders_img),
            contentDescription = null,
            modifier = Modifier.height(150.dp).fillMaxWidth(),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Text("No orders for now.", fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = AppColors.Primary, fontSize = 16.sp, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth())
    }
}
