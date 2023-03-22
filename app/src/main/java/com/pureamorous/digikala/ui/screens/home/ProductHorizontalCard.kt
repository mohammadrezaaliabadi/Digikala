package com.pureamorous.digikala.ui.screens.home
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pureamorous.digikala.ui.theme.DarkCyan
import com.pureamorous.digikala.ui.theme.darkText
import com.pureamorous.digikala.ui.theme.extraBoldNumber
import com.pureamorous.digikala.ui.theme.spacing

@Composable
fun ProductHorizontalCard(
    name: String,
    id: String,
    imageUrl: String
) {
    Row(
        modifier = Modifier
            .width(320.dp)
            .padding(bottom = MaterialTheme.spacing.extraSmall),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "",
            modifier = Modifier
                .weight(.3f)
                .fillMaxHeight()
        )

        Text(
            text = id,
            style = MaterialTheme.typography.extraBoldNumber,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.DarkCyan,
            modifier = Modifier
                .weight(.1f)
                .padding(horizontal = MaterialTheme.spacing.small)
        )

        Column(
            modifier = Modifier
                .weight(.6f)
                .fillMaxHeight()
                .padding(vertical = MaterialTheme.spacing.small),
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.darkText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            )
        }

    }
}
