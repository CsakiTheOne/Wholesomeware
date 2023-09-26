package com.csakitheone.wholesomeware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.csakitheone.wholesomeware.ui.theme.WholesomewareTheme
import com.csakitheone.wholesomeware_brand.R
import com.csakitheone.wholesomeware_brand.WholesomeWare
import com.csakitheone.wholesomeware_brand.ui.components.WholesomeWareStoreButton
import com.csakitheone.wholesomeware_brand.ui.theme.WholesomewareBrandTheme
import java.util.Timer
import kotlin.concurrent.timerTask

class MainActivity : ComponentActivity() {
    private var isKeepingSplash = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { isKeepingSplash }
        setContent {
            MainScreen()
        }
        Timer().schedule(timerTask {
            isKeepingSplash = false
        }, 3000L)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun MainScreen() {
        WholesomewareBrandTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Column {
                    Surface(
                        shadowElevation = 8.dp,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.banner),
                            contentDescription = null
                        )
                    }
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "This is an example app showing how to implement the WholesomeWare brand library.",
                    )
                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = { WholesomeWare.setup(this@MainActivity) }
                    ) {
                        Text(modifier = Modifier.padding(start = 8.dp), text = "Open brand setup screen")
                    }
                    WholesomeWareStoreButton(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}
