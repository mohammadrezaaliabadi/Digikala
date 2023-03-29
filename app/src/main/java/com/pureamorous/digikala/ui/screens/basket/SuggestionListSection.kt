package com.pureamorous.digikala.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.pureamorous.digikala.data.model.home.StoreProduct
import com.pureamorous.digikala.data.remote.NetworkResult
import com.pureamorous.digikala.ui.screens.home.MostDiscountedCard
import com.pureamorous.digikala.ui.theme.darkText
import com.pureamorous.digikala.ui.theme.searchBarBg
import com.pureamorous.digikala.ui.theme.spacing
import com.pureamorous.digikala.viewmodel.BasketViewModel
import com.pureamorous.digikala.R
import com.pureamorous.digikala.data.model.basket.CartItem
import com.pureamorous.digikala.data.model.basket.CartStatus

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuggestListSection(
    viewModel: BasketViewModel = hiltViewModel()
) {


    viewModel.getSuggestedItems()

    var suggestedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val suggestedItemResult by viewModel.suggestedList.collectAsState()
    when (suggestedItemResult) {
        is NetworkResult.Success -> {
            suggestedList = suggestedItemResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "SuggestListSection error : ${suggestedItemResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }


    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .background(MaterialTheme.colorScheme.searchBarBg)
    )

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.medium),
        text = stringResource(id = R.string.suggestion_for_you),
        textAlign = TextAlign.Right,
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.darkText,
    )

    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Start
    ) {

        for (item in suggestedList) {
            SuggestionItemCard(item = item){
                CartItem(
                    it._id,
                    it.name,
                    it.seller,
                    it.price,
                    it.discountPercent,
                    it.image,
                    1,
                    CartStatus.CURRENT_CART
                )
            }
        }

    }

}
