package com.pureamorous.digikala.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pureamorous.digikala.R
import com.pureamorous.digikala.ui.theme.DigikalaLightRed
import com.pureamorous.digikala.ui.theme.darkText
import com.pureamorous.digikala.ui.theme.roundedShape
import com.pureamorous.digikala.ui.theme.spacing

@Composable
fun AmazingShowMoreItem() {
    Card(
        modifier = Modifier
            .size(180.dp, 375.dp)
            .padding(
                end = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.semiSmall,
                top = MaterialTheme.spacing.semiLarge
            ),
        shape = MaterialTheme.roundedShape.small,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Icon(
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.DigikalaLightRed,
                modifier = Modifier.size(40.dp, 40.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.darkText,
            )


        }


    }
}

