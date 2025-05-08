package edu.ucne.demoap2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.ucne.demoap2.ui.theme.DemoAp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(text="Hello", modifier = Modifier.padding(innerPadding))


                }
            }
        }
    }
}



@Composable
fun Bandera(modifier:Modifier = Modifier) {
    Column {
        Row {
            Column {
                Cuadrado(Color.Blue)
                Cuadrado(Color.Red)

            }

        }
        Row {
            Column {
                Cuadrado(Color.Red)
                Cuadrado(Color.Blue)
            }

        }

    }
}


@Composable

fun Cuadrado(Color:Int){
    ElevatedCard(
        shape= RoundedCornerShape(8.dp)
        modifier = Modificar
         .padding()
         .size(width = 200.dp height = 100.dp)
        .backgroundColor(Color=Color.Red)
    ) {

    }

}


fun BanderaPreview() {
    DemoAp2Theme {

    }
}



