package com.pureamorous.digikala.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pureamorous.digikala.R
import com.pureamorous.digikala.data.model.basket.CartDetails
import com.pureamorous.digikala.ui.theme.DigikalaLightRed
import com.pureamorous.digikala.ui.theme.darkText
import com.pureamorous.digikala.ui.theme.spacing
import com.pureamorous.digikala.util.DigitHelper
import com.pureamorous.digikala.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun CartPriceDetailSection(
    item: CartDetails
) {

    Column(
        modifier = Modifier.padding(
            start = MaterialTheme.spacing.medium,
            end = MaterialTheme.spacing.medium,
            top = MaterialTheme.spacing.medium,
            bottom = 120.dp
        )
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.basket_summary),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.darkText
            )

            Text(
                text = "${DigitHelper.digitByLocateAndSeparator(item.totalCount.toString())} ${
                    stringResource(
                        R.string.goods
                    )
                }",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))

        PriceRow(
            stringResource(id = R.string.goods_price),
            digitByLocateAndSeparator(item.totalPrice.toString())
        )
        val discountPercent = (1 - item.payablePrice.toDouble() / item.totalPrice.toDouble()) * 100
        PriceRow(
            stringResource(id = R.string.goods_discount),
            digitByLocateAndSeparator(item.totalDiscount.toString()),
            discountPercent.toInt()
        )
        PriceRow(
            stringResource(id = R.string.goods_total_price),
            digitByLocateAndSeparator(item.payablePrice.toString())
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.dot_bullet),
                color = Color.Gray,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(MaterialTheme.spacing.extraSmall)
            )

            Text(
                text = stringResource(R.string.shipping_cost_alert),
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                modifier = Modifier.weight(1f)
            )
        }

        Divider(
            Modifier
                .padding(
                    vertical = MaterialTheme.spacing.medium,
                    horizontal = MaterialTheme.spacing.small
                )
                .alpha(0.6f),
            color = Color.LightGray
        )
        DigiClubScore(item.payablePrice)

    }


}

@Composable
private fun DigiClubScore(
    payedPrice: Long
) {

    val score = payedPrice / 100_000

    Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Image(
                painter = painterResource(id = R.drawable.digi_score),
                contentDescription = "",
                modifier = Modifier
                    .size(22.dp)
                    .padding(MaterialTheme.spacing.extraSmall)
            )
            Text(
                text = stringResource(id = R.string.digiclub_score),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
            )
        }

        Text(
            text = "${digitByLocateAndSeparator(score.toString())} ${stringResource(id = R.string.score)}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.darkText,
        )

    }

    Spacer(modifier = Modifier.height(MaterialTheme.spacing.biggerSmall))
    Text(
        text = stringResource(R.string.digiclub_description),
        style = MaterialTheme.typography.labelSmall,
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.biggerSmall)
    )


}


@Composable
private fun PriceRow(
    title: String,
    price: String,
    discount: Int = 0,
) {

    var color = MaterialTheme.colorScheme.darkText
    var ourPrice = price
    if (discount > 0) {
        color = MaterialTheme.colorScheme.DigikalaLightRed
        ourPrice = "(${digitByLocateAndSeparator(discount.toString())}%) $price"
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start,
        )

        Row {
            Text(
                text = ourPrice,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                color = color,
            )

            Icon(
                painter = painterResource(id = R.drawable.toman),
                contentDescription = "",
                tint = color,
                modifier = Modifier
                    .size(24.dp)
                    .padding(MaterialTheme.spacing.extraSmall)
            )
        }

    }
}
