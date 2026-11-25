package com.tecsup.widgetslab14

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

// Proveedor encargado de conectar el widget con su contenido.
class SimpleWidget : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget =
        SimpleWidgetContent()
}