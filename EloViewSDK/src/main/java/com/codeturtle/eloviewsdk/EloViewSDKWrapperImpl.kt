package com.codeturtle.eloviewsdk

import android.content.Context
import android.os.Handler
import com.eloview.homesdk.accountManager.AccountManager
import com.eloview.homesdk.infoManager.Info
import com.eloview.homesdk.systemManager.System

/**
 * Real implementation of EloViewSDKWrapper that delegates to the actual EloView SDK.
 *
 * This implementation is used in production and calls the real EloView SDK methods.
 */
class EloViewSDKWrapperImpl : EloViewSDKWrapper {

    override fun isSDKSupported(context: Context): Boolean {
        return try {
            Info.instance.isSDKSupported(context)
        } catch (e: Exception) {
            // Log the error and return false if SDK is not available
            e.printStackTrace()
            false
        }
    }

    override fun verifyEloToken(context: Context, accessToken: String, handler: Handler) {
        try {
            AccountManager.instance.verifyEloToken(context, accessToken, handler)
        } catch (e: Exception) {
            // Handle SDK errors gracefully
            e.printStackTrace()
        }
    }

    override fun enableBCR(context: Context, accessToken: String, enabled: Boolean, handler: Handler) {
        try {
            System.instance.enableBCR(context, accessToken, enabled, handler)
        } catch (e: Exception) {
            // Handle SDK errors gracefully
            e.printStackTrace()
        }
    }

    override fun getDeviceInfo(context: Context, accessToken: String, handler: Handler) {
        try {
            Info.instance.getDeviceInfo(context, accessToken, handler)
        } catch (e: Exception) {
            // Handle SDK errors gracefully
            e.printStackTrace()
        }
    }

    override fun setAccessibilityService(context: Context, accessToken: String, serviceName: String, enabled: Boolean, handler: Handler) {
        try {
            System.instance.setAccessibilityService(context, accessToken, serviceName, enabled, handler)
        } catch (e: Exception) {
            // Handle SDK errors gracefully
            e.printStackTrace()
        }
    }
}