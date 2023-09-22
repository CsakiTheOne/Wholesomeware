package com.csakitheone.wholesomeware_brand

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.graphics.Color

class Wholesomeware {
    companion object {

        const val brandName = "Wholesomeware"
        val playStoreUri: Uri = Uri.parse("")//TODO Get Play Store page's url

        /**
         * This functions starts the branding setup process.
         */
        fun setup(context: Context) {
            context.startActivity(Intent(context, BrandingSetupActivity::class.java))
        }

        /**
         * Open the Wholesomeware Play Store page.
         */
        fun openPlayStore(context: Context) {
            context.startActivity(Intent(Intent.ACTION_VIEW, playStoreUri))
        }

    }
}