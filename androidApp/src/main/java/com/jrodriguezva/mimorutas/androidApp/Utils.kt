package com.jrodriguezva.mimorutas.androidApp

import android.util.Size
import com.google.android.gms.maps.model.LatLngBounds
import kotlin.math.ln
import kotlin.math.sin

fun LatLngBounds.getBoundsZoomLevel(mapDim: Size = Size(256,256)): Double {
    val worldDim = Size(256, 256)
    val zoomMax = 21.toDouble();

    fun latRad(lat: Double): Double {
        val sin = sin(lat * Math.PI / 180);
        val radX2 = ln((1 + sin) / (1 - sin)) / 2;
        return radX2.coerceAtMost(Math.PI).coerceAtLeast(-Math.PI) / 2
    }

    fun zoom(mapPx: Int, worldPx: Int, fraction: Double): Double {
        return kotlin.math.floor(ln(mapPx / worldPx / fraction) / ln(2.0))
    }

    val ne = northeast;
    val sw = southwest;

    val latFraction = (latRad(ne.latitude) - latRad(sw.latitude)) / Math.PI;

    val lngDiff = ne.longitude - sw.longitude;
    val lngFraction = if (lngDiff < 0) {
        (lngDiff + 360) / 360
    } else {
        (lngDiff / 360)
    }

    val latZoom = zoom(mapDim.height, worldDim.height, latFraction);
    val lngZoom = zoom(mapDim.width, worldDim.width, lngFraction);

    return minOf(latZoom, lngZoom, zoomMax)
}