package com.pureamorous.digikala.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.pureamorous.digikala.data.model.home.Slider
import com.pureamorous.digikala.data.remote.NetworkResult
import com.pureamorous.digikala.ui.theme.roundedShape
import com.pureamorous.digikala.ui.theme.spacing
import com.pureamorous.digikala.viewmodel.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProposalCardSection(viewModel: HomeViewModel = hiltViewModel()) {
    var bannersList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val bannersResult by viewModel.banners.collectAsState()

    when (bannersResult) {
        is NetworkResult.Success -> {
            bannersList = bannersResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

    FlowRow(
        maxItemsInEachRow = 2, modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .padding(MaterialTheme.spacing.small)
    ) {
        for(item in bannersList){
            ProposalCardItem(imgLink = item)
        }
    }

}

@Composable
fun ProposalCardItem(imgLink: Slider) {
    Card(
        shape = MaterialTheme.roundedShape.semiMedium,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(140.dp)
            .padding(
                horizontal = MaterialTheme.spacing.small,
                vertical = MaterialTheme.spacing.small
            )
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imgLink.image),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

    }
}