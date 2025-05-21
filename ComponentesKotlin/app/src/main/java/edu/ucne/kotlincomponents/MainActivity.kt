package edu.ucne.kotlincomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.ucne.kotlincomponents.ui.theme.KotlinComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Hello $name!")
        Spacer(modifier = Modifier.height(8.dp))
        MyButton()
        MyTextButton()
        Spacer(modifier = Modifier.height(8.dp))
        MyDialog()
        Spacer(modifier = Modifier.height(8.dp))
        MyDropdown()
        Spacer(modifier = Modifier.height(8.dp))
        MyBox()
        Spacer(modifier = Modifier.height(8.dp))
        ProgressIndicators()
    }
}

@Composable
fun MyButton() {
    Button(onClick = { }) {
        Text("My Button")
    }
}

@Composable
fun MyTextButton() {
    TextButton(onClick = { }) {
        Text("Cancelar")
    }
}

@Composable
fun MyDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { showDialog = true }) {
            Text("Mostrar diálogo")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Título del diálogo") },
                text = { Text("Este es un mensaje dentro del diálogo.") },
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
}

@Composable
fun MyDropdown() {
    var selectedCity by remember { mutableStateOf("Seleccionar ciudad") }
    var expanded by remember { mutableStateOf(false) }

    val cities = listOf("Santo Domingo", "Santiago", "La Vega", "Puerto Plata")

    Column {
        OutlinedTextField(
            value = selectedCity,
            onValueChange = {},
            label = { Text("Ciudad") },
            trailingIcon = {
                Icon(
                    Icons.Filled.ArrowDropDown,
                    contentDescription = "Abrir menú desplegable",
                    modifier = Modifier.clickable { expanded = true }
                )
            },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            cities.forEach { city ->
                DropdownMenuItem(
                    text = { Text(city) },
                    onClick = {
                        selectedCity = city
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("Box")
    }
}

@Composable
fun ProgressIndicators() {
    Column {
        CircularProgressIndicator(modifier = Modifier.size(48.dp))
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinComponentsTheme {
        Greeting("Preview")
    }
}
