package com.luthtan.projectui.base.util

import android.content.Context
import com.google.gson.Gson
import com.luthtan.projectui.domain.entity.InputModel
import com.luthtan.projectui.domain.entity.OutputModel
import java.io.IOException


object JsonHelper {

    private fun getJsonFromAssets(context: Context, fileName: String?): String? {
        val jsonString: String = try {
            val inputStream = context.assets.open(fileName!!)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getInputModel(context: Context): InputModel {
        return Gson().fromJson(getJsonFromAssets(context, "input.json"), InputModel::class.java)
    }

    fun getOutputModel(context: Context): OutputModel {
        return Gson().fromJson(getJsonFromAssets(context, "Output.json"), OutputModel::class.java)
    }
}