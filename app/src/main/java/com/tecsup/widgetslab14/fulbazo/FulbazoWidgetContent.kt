package com.tecsup.widgetslab14.fulbazo

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.*
import androidx.glance.text.*

class FulbazoWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        provideContent {
            GlanceTheme {
                FulbazoContent()
            }
        }
    }

    // Contenido visual del widget deportivo.
    @Composable
    private fun FulbazoContent() {

        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.surface)
                .padding(16.dp)
        ) {

            Text(
                text = "⚽ FULBAZO",
                style = TextStyle(
                    color = GlanceTheme.colors.primary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = GlanceModifier.height(6.dp))

            Text(
                text = "¡Tu próximo partido te espera!",
                style = TextStyle(
                    color = GlanceTheme.colors.onSurface,
                    fontSize = 12.sp
                )
            )

            Spacer(modifier = GlanceModifier.height(12.dp))

            // Tarjeta con datos de demostración.
            Column(
                modifier = GlanceModifier
                    .fillMaxWidth()
                    .background(GlanceTheme.colors.primaryContainer)
                    .padding(12.dp)
            ) {

                Text(
                    text = "PRÓXIMO PARTIDO · DEMO",
                    style = TextStyle(
                        color = GlanceTheme.colors.onPrimaryContainer,
                        fontSize = 11.sp
                    )
                )

                Spacer(modifier = GlanceModifier.height(6.dp))

                Text(
                    text = "Fútbol 7",
                    style = TextStyle(
                        color = GlanceTheme.colors.onPrimaryContainer,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "📅 Sábado - 4:00 PM",
                    style = TextStyle(
                        color = GlanceTheme.colors.onPrimaryContainer,
                        fontSize = 14.sp
                    )
                )

                Text(
                    text = "📍 Cancha deportiva",
                    style = TextStyle(
                        color = GlanceTheme.colors.onPrimaryContainer,
                        fontSize = 14.sp
                    )
                )
            }

            Spacer(modifier = GlanceModifier.height(12.dp))

            Text(
                text = "Organiza · Juega · Comparte",
                style = TextStyle(
                    color = GlanceTheme.colors.primary,
                    fontSize = 12.sp
                )
            )
        }
    }
}