package com.example.project1androidui.navigation

// file: app/src/main/java/com/example/project1androidui/ui/ProfileScreen.kt


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    onLogout: () -> Unit,
    onNavigateToAvatar: () -> Unit
) {
    // Di aplikasi nyata, data ini akan datang dari ViewModel atau parameter navigasi
    val userProfile = mapOf(
        "First Name" to "John",
        "Last Name" to "Doe",
        "Username" to "johndoe",
        "Email" to "john.doe@example.com",
        "Phone Number" to "+1234567890",
        "Date of Birth" to "01/01/1990",
        "Bio" to "Android developer passionate about Jetpack Compose and building beautiful UIs."
    )

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("User Profile", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(24.dp))

            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile Picture",
                modifier = Modifier.size(120.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Menampilkan semua data profil
            userProfile.forEach { (label, value) ->
                ProfileInfoItem(label = label, value = value)
            }

            Spacer(modifier = Modifier.weight(1f)) // Mendorong tombol ke bawah

            Button(
                onClick = onNavigateToAvatar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Edit Avatar")
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(
                onClick = onLogout,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Logout")
            }
        }
    }
}

@Composable
private fun ProfileInfoItem(label: String, value: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(onLogout = {}, onNavigateToAvatar = {})
}