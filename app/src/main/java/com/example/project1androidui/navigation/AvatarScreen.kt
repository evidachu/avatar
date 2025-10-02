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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project1androidui.R

@Composable
fun AvatarScreen(onNavigateToProfile: () -> Unit) {
    // State untuk mengontrol visibilitas komponen wajah baru
    var showAlis by remember { mutableStateOf(true) }
    var showMata by remember { mutableStateOf(true) }
    var showHidung by remember { mutableStateOf(true) }
    var showMulut by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. Bagian Avatar (Atas)
            Text("Buat Avatarmu!", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier.size(280.dp), // Ukuran container avatar
                contentAlignment = Alignment.Center
            ) {
                // Lapis Paling Belakang
                Image(painter = painterResource(id = R.drawable.facebase_0004), contentDescription = "Wajah Dasar")

                // Komponen dengan pemetaan aset dan modifier yang sudah benar
                if (showAlis) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0001),
                        contentDescription = "Alis",
                        modifier = Modifier
                            .offset(x = 0.dp, y = (-20).dp)
                            .scale(0.3f)
                    )
                }
                if (showMata) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0003),
                        contentDescription = "Mata",
                        modifier = Modifier
                            .offset(x = 0.dp, y = 5.dp)
                            .scale(0.3f) // Ukuran mata dikecilkan 20%
                    )
                }
                if (showHidung) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0002),
                        contentDescription = "Hidung",
                        modifier = Modifier
                            .offset(x = 0.dp, y = 30.dp)
                            .scale(0.3f)
                    )
                }
                if (showMulut) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0000),
                        contentDescription = "Mulut",
                        modifier = Modifier
                            .offset(x = 0.dp, y = 60.dp)
                            .scale(0.4f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // 2. Bagian Checkbox (Tengah)
            // Grid 2x2 untuk Checkbox
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CheckboxItem(label = "Alis", checked = showAlis, onCheckedChange = { showAlis = it })
                CheckboxItem(label = "Mata", checked = showMata, onCheckedChange = { showMata = it })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CheckboxItem(label = "Hidung", checked = showHidung, onCheckedChange = { showHidung = it })
                CheckboxItem(label = "Mulut", checked = showMulut, onCheckedChange = { showMulut = it })
            }

            Spacer(modifier = Modifier.weight(1f)) // Mendorong tombol ke bawah

            // 3. Bagian Tombol (Bawah)
            Button(
                onClick = onNavigateToProfile,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Simpan & Kembali")
            }
        }
    }
}

@Composable
private fun CheckboxItem(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 4.dp)) {
        Text(label)
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Preview(showBackground = true)
@Composable
fun AvatarScreenPreview() {
    AvatarScreen(onNavigateToProfile = {})
}
