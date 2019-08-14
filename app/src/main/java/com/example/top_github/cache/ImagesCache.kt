package com.example.top_github.cache

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.collection.LruCache
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class ImagesCache {

    private var mMemoryCache: LruCache<String, Bitmap>? = null

    val memoryCache: LruCache<String, Bitmap>
        get() {
            if (mMemoryCache == null) {
                val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()

                val cacheSize = maxMemory / 8
                mMemoryCache = object : LruCache<String, Bitmap>(cacheSize) {
                    override fun sizeOf(key: String, bitmap: Bitmap): Int {
                        return bitmap.byteCount / 1024
                    }
                }
            }
            return mMemoryCache as LruCache<String, Bitmap>
        }

    fun setImage(activity: Activity, url: String?, imageView: ImageView) {
        GlobalScope.launch {
            var bitmap: Bitmap? = null

            if (getImageFromMemCache(url!!) == null) {
                bitmap = getBitmapFromURL(url)
                memoryCache.put(url, bitmap!!)
                activity.runOnUiThread(Runnable { imageView.setImageBitmap(bitmap) })
            } else
                activity.runOnUiThread(Runnable { imageView.setImageBitmap(getImageFromMemCache(url)) })
        }
    }

    private fun addImageToMemoryCache(url: String, key: String) {

        if (getImageFromMemCache(key) == null) {
            GlobalScope.launch {
                val bitmap = getBitmapFromURL(url)
                memoryCache.put(key, bitmap!!)
            }

        }

    }

    private fun getImageFromMemCache(key: String): Bitmap? {
        return memoryCache.get(key)
    }

    private fun getBitmapFromURL(src: String): Bitmap? {
        try {
            val url = URL(src)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            return BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            // Log exception
            return null
        }

    }

    companion object {
        private var instance: ImagesCache? = null

        fun getInstance(): ImagesCache {
            if (instance == null) {
                instance = ImagesCache()
            }
            return instance as ImagesCache
        }
    }
}