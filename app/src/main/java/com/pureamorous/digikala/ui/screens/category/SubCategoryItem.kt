package com.pureamorous.digikala.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pureamorous.digikala.data.model.category.Sub
import com.pureamorous.digikala.ui.theme.darkText
import com.pureamorous.digikala.ui.theme.grayCategory
import com.pureamorous.digikala.ui.theme.roundedShape
import com.pureamorous.digikala.ui.theme.spacing
import com.pureamorous.digikala.util.DigitHelper.digitByLocate
import com.pureamorous.digikala.R

@Composable
fun SubCategoryItem(item: Sub) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .padding(
                vertical = MaterialTheme.spacing.medium,
                horizontal = MaterialTheme.spacing.extraSmall
            ), shape = MaterialTheme.roundedShape.small
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.grayCategory)
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.semiMedium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = "product image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = item.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.darkText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.labelSmall,
                text = "+${digitByLocate(item.count.toString())} ${stringResource(id = R.string.commodity)}"
            )
        }

    }
}