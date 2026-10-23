package com.example.pantalla_bienvenida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.pantalla_bienvenida.ui.theme.Pantalla_BienvenidaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WelcomeScreen()
            }
        }
    }
}

@Composable
fun WelcomeScreen() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la App",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(24.dp))



        // titulo
        Text(
            text = "Mi app",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // text descriptivo
        Text(
            text = "Bienvenido tu nueva experiencia movil. " +
                    "Descubre todo lo que tenemos preparado para ti. ",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // boton de accion
        Button(
            onClick = {showDialog = true},
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Comenzar")
        }
    }

    //dialogo de confirmacion
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {showDialog = false}, //nunca dejar vacio, nota importante
            title = { Text("Confirmacion") },
            text = { Text("¿Deseas comenzar con la experiencia?") },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                        Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}