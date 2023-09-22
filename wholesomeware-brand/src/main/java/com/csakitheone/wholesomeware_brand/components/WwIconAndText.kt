package com.csakitheone.wholesomeware_brand.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csakitheone.wholesomeware_brand.R
import com.csakitheone.wholesomeware_brand.Wholesomeware

@Preview
@Composable
fun WwIconAndText(
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .padding(8.dp)
                .width(48.dp)
                .aspectRatio(1f),
            painter = painterResource(id = R.drawable.ic),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = Wholesomeware.brandName,
            fontFamily = FontFamily(
                Font(R.font.capriola_regular),
            ),
            color = textColor,
        )
    }
}