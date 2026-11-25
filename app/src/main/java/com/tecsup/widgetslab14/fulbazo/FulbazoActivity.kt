package com.tecsup.widgetslab14.fulbazo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FulbazoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recibe la sección seleccionada desde el widget.
        val seccion = intent.getStringExtra("seccion") ?: "Partidos"

        setContent {
            PantallaFulbazo(seccion) {
                finish()
            }
        }
    }
}

@Composable
fun PantallaFulbazo(
    seccion: String,
    regresar: () -> Unit
) {
    val fondo = Color(0xFF101C16)
    val verde = Color(0xFF69E88C)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        TextButton(onClick = regresar) {
            Text("← Regresar", color = verde)
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "⚽ FULBAZO",
            color = verde,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = seccion,
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Vista de demostración",
            color = Color.LightGray,
            fontSize = 13.sp
        )

        Spacer(Modifier.height(24.dp))

        // Muestra contenido según el botón seleccionado.
        when (seccion) {

            "Partidos" -> {
                TarjetaFulbazo(
                    "⚽ Fútbol 7",
                    "Sábado - 4:00 PM",
                    "8 de 14 jugadores confirmados"
                )

                TarjetaFulbazo(
                    "⚽ Fútbol 5",
                    "Domingo - 10:00 AM",
                    "6 de 10 jugadores confirmados"
                )
            }

            "Canchas" -> {
                TarjetaFulbazo(
                    "📍 Cancha Los Campeones",
                    "Arequipa",
                    "Disponible · S/ 60 por hora"
                )

                TarjetaFulbazo(
                    "📍 Complejo Deportivo",
                    "José Luis Bustamante y Rivero",
                    "Disponible · S/ 80 por hora"
                )
            }

            "Invitaciones" -> {
                TarjetaFulbazo(
                    "👥 Equipo Los Tigres",
                    "Invitación a Fútbol 7",
                    "Estado: Pendiente"
                )

                TarjetaFulbazo(
                    "👥 Equipo Los Halcones",
                    "Invitación a partido amistoso",
                    "Estado: Pendiente"
                )
            }

            "Estadísticas" -> {
                TarjetaFulbazo(
                    "🏆 Partidos jugados",
                    "12 partidos",
                    "8 victorias"
                )

                TarjetaFulbazo(
                    "⚽ Rendimiento",
                    "15 goles",
                    "7 asistencias"
                )
            }
        }
    }
}

// Componente reutilizable para mostrar información.
@Composable
fun TarjetaFulbazo(
    titulo: String,
    descripcion: String,
    detalle: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF203D2B)
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = titulo,
                color = Color(0xFF69E88C),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = descripcion,
                color = Color.White,
                fontSize = 16.sp
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = detalle,
                color = Color.LightGray,
                fontSize = 14.sp
            )
        }
    }
}