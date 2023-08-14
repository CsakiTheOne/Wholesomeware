package com.csakitheone.wholesomeware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.csakitheone.wholesomeware.ui.theme.WholesomewareTheme
import com.csakitheone.wholesomeware_brand.Wholesomeware

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Preview
    @Composable
    fun MainScreen() {
        WholesomewareTheme {
            Icon(
                painter = painterResource(id = com.csakitheone.wholesomeware_brand.R.drawable.ic_android_black_24dp),
                contentDescription = null,
                tint = Wholesomeware.Colors.Pink,
            )
        }
    }
}
