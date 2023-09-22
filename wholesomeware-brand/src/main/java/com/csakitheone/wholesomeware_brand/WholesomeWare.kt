package com.csakitheone.wholesomeware_brand

import android.content.Context
import android.content.Intent
import android.net.Uri

class WholesomeWare {
    companion object {

        const val brandName = "WholesomeWare"
        val playStoreUri: Uri = Uri.parse("https://play.google.com/store/apps/dev?id=8177011913013516936")

        /**
         * This function starts the branding setup process.
         */
        fun setup(context: Context) {
            context.startActivity(Intent(context, BrandingSetupActivity::class.java))
        }

        /**
         * Open the WholesomeWare Play Store page.
         */
        fun openPlayStore(context: Context) {
            context.startActivity(Intent(Intent.ACTION_VIEW, playStoreUri))
        }

    }
}