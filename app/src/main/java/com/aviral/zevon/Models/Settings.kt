package com.aviral.zevon.Models

import android.graphics.drawable.Drawable

class Settings(var imageName: Int, var settingName: String) {

    fun getImageNames(): Int {
        return imageName
    }

    fun getSettingsName(): String {
        return settingName
    }

}