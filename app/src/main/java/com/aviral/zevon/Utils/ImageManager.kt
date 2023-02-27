package com.aviral.zevon.Utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.*


class ImageManager {

    companion object {

        fun getBitmap(imgUrl: String): Bitmap? {

            val imageFile = File(imgUrl)

            var fis: FileInputStream? = null
            var bitmap: Bitmap? = null

            try {

                fis = FileInputStream(imageFile)
                bitmap = BitmapFactory.decodeStream(fis)

            } catch (e: FileNotFoundException) {
                Log.d("AviralKaushik", "getBitmap: FileNotFoundException ${e.message}")
            } finally {

                try {
                    fis?.close()
                } catch (ae: IOException) {
                    Log.d("AviralKaushik", "getBitmap: IOException ${ae.message}")
                }

            }

            return bitmap
        }

        fun getByteFromBitmap(bm: Bitmap?, quality: Int): ByteArray {
            val stream = ByteArrayOutputStream()
            bm?.compress(Bitmap.CompressFormat.JPEG, quality, stream)
            return stream.toByteArray()
        }

    }

}