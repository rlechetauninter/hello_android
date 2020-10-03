package com.example.helloligacao

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

object PermissionUtils {
    /*fun request(activity: Activity) {
        if (!
            checkGpsPermissionsGranted(activity)) {
            ActivityCompat.requestPermissions(
                activity,
                gpsPermissions,
                1
            )
        }
    }

    val gpsPermissions: Array<String>
        get() {
            val permissions: MutableList<String> =
                ArrayList()
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION)
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                permissions.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
            }
            val array = arrayOfNulls<String>(permissions.size)
            return permissions.toArray<String>(array)
        }

    fun validatePermissions(context: Context?): Boolean {

        for (permission in permissions) {
            val result = ContextCompat.checkSelfPermission(
                context!!,
                permission
            )
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    fun validateRequestResults(grantResults: IntArray): Boolean {
        for (result in grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }*/
}