package com.tecsup.widgetslab14.fulbazo

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.darkColorScheme
import androidx.glance.*
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.*
import androidx.glance.material3.ColorProviders
import androidx.glance.text.*
import android.content.Intent
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionStartActivity

// Paleta de colores personalizada de Fulbazo.
private val FulbazoColors = ColorProviders(
    light = darkColorScheme(
        primary = Color(0xFF69E88C),
        surface = Color(0xFF101C16),
        onSurface = Color.White,
        primaryContainer = Color(0xFF203D2B),
        onPrimaryContainer = Color.White
    ),
    dark = darkColorScheme(
        primary = Color(0xFF69E88C),
        surface = Color(0xFF101C16),
        onSurface = Color.White,
        primaryContainer = Color(0xFF203D2B),
        onPrimaryContainer = Color.White
    )
)

class FulbazoWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        provideContent {
            GlanceTheme(colors = FulbazoColors) {
                FulbazoContent()
            }
        }
    }

    // Contenido principal del widget deportivo.
    @Composable
    private fun FulbazoContent() {

        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.surface)
                .padding(12.dp)
        ) {

            Text(
                text = "⚽ FULBAZO",
                style = TextStyle(
                    color = GlanceTheme.colors.primary,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Tu pasión por el fútbol",
                style = TextStyle(
                    color = GlanceTheme.colors.onSurface,
                    fontSize = 12.sp
                )
            )

            Spacer(GlanceModifier.height(10.dp))

            // Tarjeta informativa del próximo partido.
            Column(
                modifier = GlanceModifier
                    .fillMaxWidth()
                    .background(
                        GlanceTheme.colors.primaryContainer
                    )
                    .padding(10.dp)
            ) {

                Text(
                    text = "PRÓXIMO PARTIDO · DEMO",
                    style = TextStyle(
                        color = GlanceTheme.colors.primary,
                        fontSize = 10.sp
                    )
                )

                Text(
                    text = "Fútbol 7",
                    style = TextStyle(
                        color = GlanceTheme.colors.onSurface,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "📅 Sábado - 4:00 PM",
                    style = TextStyle(
                        color = GlanceTheme.colors.onSurface,
                        fontSize = 12.sp
                    )
                )

                Text(
                    text = "📍 Cancha deportiva",
                    style = TextStyle(
                        color = GlanceTheme.colors.onSurface,
                        fontSize = 12.sp
                    )
                )
            }

            Spacer(GlanceModifier.height(10.dp))

            // Primera fila de accesos.
            Row(
                modifier = GlanceModifier.fillMaxWidth()
            ) {
                Opcion(
                    "⚽",
                    "Partidos",
                    GlanceModifier.defaultWeight()
                )

                Spacer(GlanceModifier.width(6.dp))

                Opcion(
                    "📍",
                    "Canchas",
                    GlanceModifier.defaultWeight()
                )
            }

            Spacer(GlanceModifier.height(6.dp))

            // Segunda fila de accesos.
            Row(
                modifier = GlanceModifier.fillMaxWidth()
            ) {
                Opcion(
                    "👥",
                    "Invitaciones",
                    GlanceModifier.defaultWeight()
                )

                Spacer(GlanceModifier.width(6.dp))

                Opcion(
                    "📊",
                    "Estadísticas",
                    GlanceModifier.defaultWeight()
                )
            }

            Spacer(GlanceModifier.height(8.dp))

            Text(
                text = "Organiza · Juega · Comparte",
                style = TextStyle(
                    color = GlanceTheme.colors.primary,
                    fontSize = 10.sp
                )
            )
        }
    }

    // Componente reutilizable para los accesos.
    @Composable
    private fun Opcion(
        icono: String,
        nombre: String,
        modifier: GlanceModifier
    ) {
        val context = LocalContext.current

        // Abre la pantalla correspondiente al botón.
        val intent = Intent(
            context,
            FulbazoActivity::class.java
        ).apply {
            putExtra("seccion", nombre)
            data = android.net.Uri.parse(
                "fulbazo://seccion/$nombre"
            )
        }

        Column(
            modifier = modifier
                .background(Color(0xFF284534))
                .clickable(actionStartActivity(intent))
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = icono,
                style = TextStyle(
                    fontSize = 18.sp
                )
            )

            Text(
                text = nombre,
                style = TextStyle(
                    color = GlanceTheme.colors.onSurface,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}