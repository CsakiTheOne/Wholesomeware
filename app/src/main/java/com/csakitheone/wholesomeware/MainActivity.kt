package com.csakitheone.wholesomeware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.csakitheone.wholesomeware_brand.R
import com.csakitheone.wholesomeware_brand.WholesomeWare
import com.csakitheone.wholesomeware_brand.ui.components.WholesomeWareStoreButton
import com.csakitheone.wholesomeware_brand.ui.components.WholesomeWareStoreDropdownMenuItem
import com.csakitheone.wholesomeware_brand.ui.theme.WholesomewareBrandTheme
import java.util.Timer
import kotlin.concurrent.timerTask

class MainActivity : ComponentActivity() {
    private var isKeepingSplash = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { isKeepingSplash }
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
        Timer().schedule(timerTask {
            isKeepingSplash = false
        }, 3000L)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(device = "spec:parent=pixel_5,orientation=landscape")
    @Composable
    fun MainScreen() {
        WholesomewareBrandTheme {
            var isMenuOpen by remember { mutableStateOf(false) }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Column {
                    TopAppBar(
                        title = { Text(text = WholesomeWare.brandName) },
                        navigationIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_wholesomeware),
                                contentDescription = null,
                                modifier = Modifier.padding(8.dp),
                            )
                        },
                        actions = {
                            IconButton(onClick = { isMenuOpen = true }) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = null,
                                )
                                DropdownMenu(expanded = isMenuOpen, onDismissRequest = { isMenuOpen = false }) {
                                    WholesomeWareStoreDropdownMenuItem()
                                }
                            }
                        },
                    )
                    WholesomeWareStoreButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    )
                }
            }
        }
    }
}
