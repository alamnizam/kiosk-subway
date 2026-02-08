package com.codeturtle.eloviewsdk

import android.content.Context
import android.os.Handler

/**
 * Wrapper interface for EloView SDK to enable unit testing.
 *
 * This interface abstracts the EloView SDK calls so they can be mocked in tests.
 * The real implementation delegates to the actual SDK, while test implementations
 * can provide controlled behavior.
 */
interface EloViewSDKWrapper {

    /**
     * Check if the EloView SDK is supported on this device.
     */
    fun isSDKSupported(context: Context): Boolean

    /**
     * Verify an EloView token with the SDK.
     */
    fun verifyEloToken(context: Context, accessToken: String, handler: Handler)

    /**
     * Enable or disable BCR (Barcode Reader) functionality.
     */
    fun enableBCR(context: Context, accessToken: String, enabled: Boolean, handler: Handler)

    /**
     * Get device information from the EloView SDK.
     */
    fun getDeviceInfo(context: Context, accessToken: String, handler: Handler)

    /**
     * Set accessibility service with specific service name.
     */
    fun setAccessibilityService(context: Context, accessToken: String, serviceName: String, enabled: Boolean, handler: Handler)
}
