package com.pureamorous.digikala.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.pureamorous.digikala.R
import com.pureamorous.digikala.navigation.Screen
import com.pureamorous.digikala.ui.components.RoundedIconBox
import com.pureamorous.digikala.ui.theme.LocalSpacing
import com.pureamorous.digikala.ui.theme.amber
import com.pureamorous.digikala.ui.theme.grayCategory
import com.pureamorous.digikala.util.Constants.AUCTION_URL
import com.pureamorous.digikala.util.Constants.DIGIJET_URL
import com.pureamorous.digikala.util.Constants.DIGIPAY_URL
import com.pureamorous.digikala.util.Constants.DIGIPLUS_URL
import com.pureamorous.digikala.util.Constants.GIFT_CARD_URL
import com.pureamorous.digikala.util.Constants.MORE_URL
import com.pureamorous.digikala.util.Constants.PINDO_URL
import com.pureamorous.digikala.util.Constants.SHOPPING_URL

@Composable
fun ShowCaseSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = LocalSpacing.current.semiMedium,
                vertical = LocalSpacing.current.biggerSmall
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                image = painterResource(id = R.drawable.digijet),
                title = stringResource(id = R.string.digikala_jet),
                onClick = onBoxClick(
                    navController = navController,
                    url = DIGIJET_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.auction),
                title = stringResource(id = R.string.digi_style),
                onClick = onBoxClick(
                    navController = navController,
                    url = AUCTION_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digipay),
                title = stringResource(id = R.string.digi_pay),
                onClick = onBoxClick(
                    navController,
                    url = DIGIPAY_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.pindo),
                title = stringResource(id = R.string.pindo),
                bgColor = MaterialTheme.colorScheme.amber,
                onClick = onBoxClick(
                    navController,
                    url = PINDO_URL
                ),
            )

        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                image = painterResource(id = R.drawable.shopping),
                title = stringResource(id = R.string.digi_shopping),
                onClick = onBoxClick(
                    navController,
                    url = SHOPPING_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.giftcard),
                title = stringResource(id = R.string.gift_card),
                onClick = onBoxClick(
                    navController,
                    url = GIFT_CARD_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digiplus),
                title = stringResource(id = R.string.digi_plus),
                onClick = onBoxClick(
                    navController,
                    url = DIGIPLUS_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.more),
                title = stringResource(id = R.string.more),
                bgColor = MaterialTheme.colorScheme.grayCategory,
                onClick = onBoxClick(
                    navController,
                    url = MORE_URL
                ),
            )

        }

    }
}


@Composable
fun onBoxClick(navController: NavController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=${url}") }