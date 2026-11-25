package com.tecsup.widgetslab14.fulbazo

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

// Proveedor encargado de conectar el widget
// de Fulbazo con su contenido visual.
class FulbazoWidget : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget =
        FulbazoWidgetContent()
}