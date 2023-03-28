package com.pureamorous.digikala.ui.screens.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.pureamorous.digikala.R
import com.pureamorous.digikala.data.model.category.Sub
import com.pureamorous.digikala.ui.theme.LightCyan
import com.pureamorous.digikala.ui.theme.spacing

@Composable
fun CategoryItem(title: String, subList: List<Sub>) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small
            ), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.see_all),
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
            color = MaterialTheme.colorScheme.LightCyan
        )
    }
    LazyRow() {
        items(subList) { sub ->
            SubCategoryItem(item = sub)
        }
    }
}