package com.example.hellocamera

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

object ImageUtils {
    // Faz o resize da imagem
    fun resize(file: File, reqWidth: Int, reqHeight: Int): Bitmap {
        // Get the dimensions of the View
        // Get the dimensions of the View
        val targetW: Int = reqWidth
        val targetH: Int = reqHeight

        // Get the dimensions of the bitmap

        // Get the dimensions of the bitmap
        val bmOptions = BitmapFactory.Options()
        bmOptions.inJustDecodeBounds = true

        BitmapFactory.decodeFile(file.absolutePath, bmOptions)

        val photoW = bmOptions.outWidth
        val photoH = bmOptions.outHeight

        // Determine how much to scale down the image

        // Determine how much to scale down the image
        val scaleFactor =
            Math.max(1, Math.min(photoW / targetW, photoH / targetH))

        // Decode the image file into a Bitmap sized to fill the View

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false
        bmOptions.inSampleSize = scaleFactor
        bmOptions.inPurgeable = true

        val bitmap = BitmapFactory.decodeFile(file.absolutePath, bmOptions)
        return bitmap
    }
}
