package com.example.project1androidui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project1androidui.R

@Composable
fun AvatarScreen(onNavigateToProfile: () -> Unit) {
    // State untuk mengontrol visibilitas setiap komponen wajah
    var showRambut by remember { mutableStateOf(true) }
    var showAlis by remember { mutableStateOf(true) }
    var showMata by remember { mutableStateOf(true) }
    var showTelinga by remember { mutableStateOf(true) }
    var showHidung by remember { mutableStateOf(true) }
    var showMulut by remember { mutableStateOf(true) }
    var showKacamata by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            // Kolom untuk Avatar
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Buat Avatarmu!", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier.size(280.dp), // Ukuran container avatar
                    contentAlignment = Alignment.Center
                ) {
                    // Komponen wajah ditumpuk sesuai urutan layer (belakang ke depan)
                    if (showTelinga) Image(painter = painterResource(id = R.drawable.telinga), contentDescription = "Telinga")
                    Image(painter = painterResource(id = R.drawable.wajah), contentDescription = "Wajah")
                    if (showAlis) Image(painter = painterResource(id = R.drawable.alis), contentDescription = "Alis")
                    if (showMata) Image(painter = painterResource(id = R.drawable.mata), contentDescription = "Mata")
                    if (showHidung) Image(painter = painterResource(id = R.drawable.hidung), contentDescription = "Hidung")
                    if (showMulut) Image(painter = painterResource(id = R.drawable.mulut), contentDescription = "Mulut")
                    if (showRambut) Image(painter = painterResource(id = R.drawable.rambut), contentDescription = "Rambut")
                    if (showKacamata) Image(painter = painterResource(id = R.drawable.kacamata), contentDescription = "Kacamata")
                }
            }

            // Kolom untuk Checkbox
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Komponen Wajah", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))

                CheckboxItem(label = "Rambut", checked = showRambut, onCheckedChange = { showRambut = it })
                CheckboxItem(label = "Alis", checked = showAlis, onCheckedChange = { showAlis = it })
                CheckboxItem(label = "Mata", checked = showMata, onCheckedChange = { showMata = it })
                CheckboxItem(label = "Telinga", checked = showTelinga, onCheckedChange = { showTelinga = it })
                CheckboxItem(label = "Hidung", checked = showHidung, onCheckedChange = { showHidung = it })
                CheckboxItem(label = "Mulut", checked = showMulut, onCheckedChange = { showMulut = it })
                CheckboxItem(label = "Kacamata", checked = showKacamata, onCheckedChange = { showKacamata = it })

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onNavigateToProfile, // Menggunakan parameter di sini
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Simpan & Kembali")
                }
            }
        }
    }
}

@Composable
private fun CheckboxItem(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Spacer(modifier = Modifier.width(8.dp))
        Text(label)
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun AvatarScreenPreview() {
    AvatarScreen(onNavigateToProfile = {})
}
