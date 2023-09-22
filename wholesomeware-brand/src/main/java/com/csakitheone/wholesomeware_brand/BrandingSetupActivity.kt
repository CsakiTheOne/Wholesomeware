package com.csakitheone.wholesomeware_brand

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csakitheone.wholesomeware_brand.ui.theme.WholesomewareBrandTheme

class BrandingSetupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrandingSetupScreen()
        }
    }

    @Composable
    fun Step(
        text: String,
        onChanged: (Boolean) -> Unit,
    ) {
        var isDone by rememberSaveable { mutableStateOf(false) }

        LaunchedEffect(isDone) { onChanged(isDone) }

        Box(
            modifier = Modifier
                .clickable { isDone = !isDone }
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = isDone,
                    onCheckedChange = { isDone = it },
                )
                Text(
                    text = text,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun BrandingSetupScreen() {
        WholesomewareBrandTheme {
            val stepsCount = 5
            var steps by remember { mutableStateOf(mapOf<Int, Boolean>()) }
            val progress by animateFloatAsState(
                targetValue = steps.values.count { it } / stepsCount.toFloat(),
                label = "Progress",
            )

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                ) {
                    TopAppBar(
                        title = { Text(text = Wholesomeware.brandName) },
                        navigationIcon = {
                            Image(
                                modifier = Modifier
                                    .width(48.dp)
                                    .aspectRatio(1f),
                                painter = painterResource(id = R.drawable.ic),
                                contentDescription = null,
                            )
                        },
                    )
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth(),
                        progress = progress,
                        trackColor = MaterialTheme.colorScheme.background,
                    )
                    AnimatedVisibility(visible = progress == 1f) {
                        Card(modifier = Modifier.padding(9.dp)) {
                            Text(
                                modifier = Modifier.padding(16.dp),
                                text = "Finishing up",
                                style = MaterialTheme.typography.titleMedium,
                            )
                            Step(text = "Remove the setup function call") {}
                            Text(
                                modifier = Modifier.padding(16.dp),
                                text = "After completing these steps, please rebuild the app.",
                            )
                        }
                    }
                    Card(modifier = Modifier.padding(9.dp)) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Splash screen",
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Step(text = "Import dependency") { steps += Pair(0, it) }
                        Step(text = "Create splash screen") { steps += Pair(1, it) }
                        Step(text = "windowSplashScreenBrandingImage") { steps += Pair(2, it) }
                        Step(text = "installSplashScreen()") { steps += Pair(3, it) }
                        Button(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            onClick = {
                                Log.w(
                                    "BrandingSetup",
                                    "https://developer.android.com/develop/ui/views/launch/splash-screen"
                                )
                                Toast.makeText(
                                    this@BrandingSetupActivity,
                                    "Check logcat",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        ) {
                            Text(text = "Send documentation to debugger")
                        }
                    }
                    Card(modifier = Modifier.padding(9.dp)) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Brand placement",
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Step(text = "Place logo in the app somewhere (preferably in an about section)") {
                            steps += Pair(
                                10,
                                it
                            )
                        }
                    }
                }
            }
        }
    }
}
