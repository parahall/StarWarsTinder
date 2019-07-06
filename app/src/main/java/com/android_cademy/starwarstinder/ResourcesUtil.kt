package com.android_cademy.starwarstinder

import android.content.Context
import com.android_cademy.starwarstinder.model.Profile
import com.google.gson.GsonBuilder
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringWriter
import java.util.ArrayList

class ResourcesUtil {

    companion object {
        fun loadProfiles(context: Context): List<Profile>? {
            val builder = GsonBuilder()
            val gson = builder.create()
            val array = JSONArray(loadJSONFromAsset(context))
            val profileList = ArrayList<Profile>()
            for (i in 0 until array.length()) {
                val profile = gson.fromJson(array.getString(i), Profile::class.java)
                profileList.add(profile)
            }
            return profileList

        }

        private fun loadJSONFromAsset(context: Context): String {
            val writer = StringWriter()
            val buffer = CharArray(1024)
            context.resources.openRawResource(R.raw.profiles).use { `is` ->
                val reader = BufferedReader(InputStreamReader(`is`, "UTF-8"))
                var n = reader.read(buffer)
                while (n != -1) {
                    writer.write(buffer, 0, n)
                    n = reader.read(buffer)
                }
            }
            return writer.toString()
        }
    }
}
