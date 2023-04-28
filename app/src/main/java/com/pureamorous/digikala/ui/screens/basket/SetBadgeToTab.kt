package com.pureamorous.digikala.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.pureamorous.digikala.ui.theme.digikalaRed
import com.pureamorous.digikala.ui.theme.spacing
import com.pureamorous.digikala.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun SetBadgeToTab(selectedTabIndex: Int, index: Int, cartCounter: Int) {
    Card(modifier = Modifier.background(Color.Transparent)) {
        var color = Color.Gray
        if (selectedTabIndex == index){
            color = MaterialTheme.colorScheme.digikalaRed
        }

        Text(
            text = digitByLocateAndSeparator(cartCounter.toString()),
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .background(color = color)
                .padding(horizontal = MaterialTheme.spacing.semiSmall)
        )
    }
}