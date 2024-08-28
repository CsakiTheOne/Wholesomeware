package com.csakitheone.wholesomeware_brand

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

class WholesomeWare {
    companion object {

        /**
         * The name of the WholesomeWare brand.
         */
        const val brandName = "WholesomeWare"

        /**
         * The URI of the WholesomeWare Play Store page.
         */
        val playStoreUri: Uri = Uri.parse("https://play.google.com/store/apps/dev?id=8177011913013516936")

        fun printSetupInstructions() {
            val urlSplashScreenDocs = "https://developer.android.com/develop/ui/views/launch/splash-screen"
            val splashScreenExampleCode = """
                <style name="SplashScreen" parent="Theme.SplashScreen">
                    <item name="postSplashScreenTheme">@style/Theme.WholesomeWare</item>
                    <item name="android:windowSplashScreenBrandingImage">@drawable/ww_logo_with_text</item>
                </style>
            """.trimIndent()

            Log.i("WholesomeWare", "--- START WHOLESOMEWARE SETUP INSTRUCTIONS ---")
            Log.i("WholesomeWare", "1. Import dependency for splash screen. See instructions here: $urlSplashScreenDocs")
            Log.i("WholesomeWare", "2. Create splash screen using the following example code:")
            Log.i("WholesomeWare", splashScreenExampleCode)
        }

        /**
         * Open the WholesomeWare Play Store page.
         */
        fun openPlayStore(context: Context) {
            context.startActivity(Intent(Intent.ACTION_VIEW, playStoreUri))
        }

    }
}