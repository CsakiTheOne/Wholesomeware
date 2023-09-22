package com.csakitheone.wholesomeware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csakitheone.wholesomeware.ui.theme.WholesomewareTheme
import com.csakitheone.wholesomeware_brand.Wholesomeware
import com.csakitheone.wholesomeware_brand.WwColors
import com.csakitheone.wholesomeware_brand.components.WwIconAndText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun IconAndTextRow(isDarkTheme: Boolean, lightColor: Color, darkColor: Color) {
        WwIconAndText(
            modifier = Modifier.padding(8.dp),
            textColor = if (isDarkTheme) lightColor
            else darkColor,
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun MainScreen() {
        var isDarkTheme by rememberSaveable { mutableStateOf(false) }

        WholesomewareTheme(
            darkTheme = isDarkTheme,
            dynamicColor = false,
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    IconAndTextRow(
                        isDarkTheme = isDarkTheme,
                        lightColor = WwColors.LightPink,
                        darkColor = WwColors.DarkPink,
                    )
                    IconAndTextRow(
                        isDarkTheme = isDarkTheme,
                        lightColor = WwColors.LightBlue,
                        darkColor = WwColors.DarkBlue,
                    )
                    IconAndTextRow(
                        isDarkTheme = isDarkTheme,
                        lightColor = WwColors.LightYellow,
                        darkColor = WwColors.DarkYellow,
                    )
                    Card {
                        IconAndTextRow(
                            isDarkTheme = isDarkTheme,
                            lightColor = WwColors.LightPink,
                            darkColor = WwColors.DarkPink,
                        )
                    }
                    Card {
                        IconAndTextRow(
                            isDarkTheme = isDarkTheme,
                            lightColor = WwColors.LightBlue,
                            darkColor = WwColors.DarkBlue,
                        )
                    }
                    Card {
                        IconAndTextRow(
                            isDarkTheme = isDarkTheme,
                            lightColor = WwColors.LightYellow,
                            darkColor = WwColors.DarkYellow,
                        )
                    }
                    Button(onClick = { Wholesomeware.setup(this@MainActivity) }) {
                        Text(text = "BrandingSetup")
                    }
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        onClick = { isDarkTheme = !isDarkTheme },
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Switch(
                                modifier = Modifier.padding(8.dp),
                                checked = isDarkTheme,
                                onCheckedChange = { isDarkTheme = it },
                            )
                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = "Dark theme",
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        }
                    }
                }
            }
        }
    }
}
