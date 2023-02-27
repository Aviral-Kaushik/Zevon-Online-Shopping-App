package com.aviral.zevon.Utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat

class PermissionManager {

    companion object {

        private const val TAG = "AviralKaushik"

        private const val VERIFY_PERMISSION_REQUEST = 1

        val PERMISSIONS = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )

        val READ_STORAGE_PERMISSION = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        val WRITE_STORAGE_PERMISSION = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        val CAMERA_PERMISSION = arrayOf(
            Manifest.permission.CAMERA
        )

        private fun checkPermission(permission: String, context: Context): Boolean {

            val permissionRequest = ActivityCompat.checkSelfPermission(context, permission)

            return if (permissionRequest != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Permission Not Granted for: $permission")
                false
            } else {
                Log.d(TAG, "Permission Granted for: $permission")
                true
            }

        }

        fun requestPermission(permissions: Array<String>, activity: Activity) {
            ActivityCompat.requestPermissions(
                activity,
                permissions,
                VERIFY_PERMISSION_REQUEST
            )
        }

        fun checkAndVerifyPermission(permissions: Array<String>, context: Context): Boolean {

            permissions.forEach {
                if (checkPermission(it, context)) {
                    return false
                }
            }

            return true

        }

    }

}