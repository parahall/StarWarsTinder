package com.android_cademy.starwarstinder

import android.content.Context

import com.android_cademy.starwarstinder.model.Profile
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import org.json.JSONArray

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringWriter
import java.io.UnsupportedEncodingException
import java.io.Writer
import java.util.ArrayList

class ResourcesUtil {

    companion object {
        fun loadProfiles(context: Context): List<Profile>? {
            try {
                val builder = GsonBuilder()
                val gson = builder.create()
                val array = JSONArray(loadJSONFromAsset(context))
                val profileList = ArrayList<Profile>()
                for (i in 0 until array.length()) {
                    val profile = gson.fromJson(array.getString(i), Profile::class.java)
                    profileList.add(profile)
                }
                return profileList
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }

        }

        private fun loadJSONFromAsset(context: Context): String {
            var jsonString: String? = null
            val writer = StringWriter()
            val buffer = CharArray(1024)
            try {
                try {
                    context.resources.openRawResource(R.raw.profiles).use { `is` ->
                        val reader = BufferedReader(InputStreamReader(`is`, "UTF-8"))
                        var n = reader.read(buffer)
                        while (n != -1) {
                            writer.write(buffer, 0, n)
                            n = reader.read(buffer)
                        }
                    }
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                } finally {
                    jsonString = writer.toString()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return jsonString ?: ""
        }
    }
}
