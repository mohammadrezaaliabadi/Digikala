package com.pureamorous.digikala.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.pureamorous.digikala.data.model.basket.CartItem
import com.pureamorous.digikala.data.model.basket.CartStatus
import com.pureamorous.digikala.viewmodel.BasketViewModel
import com.pureamorous.digikala.R
import com.pureamorous.digikala.ui.theme.*
import com.pureamorous.digikala.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun CartItemCard(
    item: CartItem,
    mode: CartStatus,
    viewModel: BasketViewModel = hiltViewModel()
) {
    val count = remember{
        mutableStateOf(item.count)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.spacing.extraSmall)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.medium)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text(
                        text = stringResource(R.string.your_shopping_list),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.darkText
                    )
                    Text(
                        text = "${digitByLocateAndSeparator(count.value.toString())} ${
                            stringResource(
                                R.string.goods
                            )
                        }",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Gray
                    )

                }

                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More Options",
                    tint = MaterialTheme.colorScheme.darkText
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = "cart item Photo",
                    modifier = Modifier
                        .width(130.dp)
                        .height(90.dp)
                        .weight(.3f),
                )

                Column(
                    modifier = Modifier
                        .weight(.7f)
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.darkText,
                        maxLines = 2,
                        modifier = Modifier
                            .padding(vertical = MaterialTheme.spacing.extraSmall)
                    )


                    DetailRow(
                        painterResource(id = R.drawable.warranty),
                        stringResource(id = R.string.warranty),
                        color = MaterialTheme.colorScheme.darkText,
                        fontStyle = MaterialTheme.typography.extraSmall
                    )

                    DetailRow(
                        painterResource(id = R.drawable.store),
                        stringResource(id = R.string.digikala),
                        color = MaterialTheme.colorScheme.darkText,
                        fontStyle = MaterialTheme.typography.extraSmall
                    )



                    Row {
                        Column(
                            modifier = Modifier
                                .width(16.dp)
                                .fillMaxHeight()
                                .padding(
                                    vertical = MaterialTheme.spacing.extraSmall,
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.in_stock),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(16.dp),
                                tint = MaterialTheme.colorScheme.DarkCyan
                            )

                            Divider(
                                Modifier
                                    .width(2.dp)
                                    .height(16.dp)
                                    .alpha(0.6f),
                                color = Color.LightGray
                            )

                            Icon(
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(10.dp)
                                    .padding(1.dp),
                                tint = MaterialTheme.colorScheme.DarkCyan,
                            )

                            Divider(
                                Modifier
                                    .width(2.dp)
                                    .height(16.dp)
                                    .alpha(0.6f),
                                color = Color.LightGray
                            )

                            Icon(
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(10.dp)
                                    .padding(1.dp),
                                tint = MaterialTheme.colorScheme.DarkCyan,
                            )


                        }

                        Column(Modifier.padding(horizontal = 8.dp)) {

                            Text(
                                text = item.seller,
                                style = MaterialTheme.typography.extraSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.semiDarkText,
                                modifier = Modifier
                                    .padding(vertical = MaterialTheme.spacing.extraSmall),
                            )

                            DetailRow(
                                painterResource(id = R.drawable.k1),
                                stringResource(id = R.string.digikala_send),
                                color = MaterialTheme.colorScheme.DigikalaLightRed,
                                fontStyle = MaterialTheme.typography.veryExtraSmall
                            )

                            DetailRow(
                                painterResource(id = R.drawable.k2),
                                stringResource(id = R.string.fast_send),
                                color = MaterialTheme.colorScheme.DigikalaLightGreen,
                                fontStyle = MaterialTheme.typography.veryExtraSmall
                            )

                        }
                    }


                }
            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))
            Row(
                modifier = Modifier
                    .align(Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier
                        .clip(MaterialTheme.roundedShape.semiSmall)
                        .border(
                            1.dp,
                            Color.LightGray.copy(0.6f),
                            MaterialTheme.roundedShape.semiSmall
                        )

                ) {

                    if (mode == CartStatus.CURRENT_CART) {
                        Row(
                            modifier = Modifier
                                .padding(
                                    horizontal = MaterialTheme.spacing.small,
                                    vertical = MaterialTheme.spacing.extraSmall
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                painterResource(id = R.drawable.ic_increase_24),
                                contentDescription = "increase icon",
                                tint = MaterialTheme.colorScheme.digikalaRed,
                                modifier = Modifier.clickable {
                                    count.value++
                                    viewModel.changeCartItemCount(item.itemId, count.value)
                                }
                            )

                            Text(
                                text = digitByLocateAndSeparator(count.value.toString()),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.digikalaRed,
                                modifier = Modifier
                                    .padding(horizontal = MaterialTheme.spacing.medium)
                            )


                            if (count.value == 1) {
                                Icon(
                                    painterResource(id = R.drawable.digi_trash),
                                    contentDescription = "increase icon",
                                    tint = MaterialTheme.colorScheme.digikalaRed,
                                    modifier = Modifier.clickable {
                                        viewModel.removeCartItem(item)
                                    }
                                )
                            } else {
                                Icon(
                                    painterResource(id = R.drawable.ic_decrease_24),
                                    contentDescription = "increase icon",
                                    tint = MaterialTheme.colorScheme.digikalaRed,
                                    modifier = Modifier.clickable {
                                        count.value--
                                        viewModel.changeCartItemCount(item.itemId, count.value)
                                    }
                                )
                            }


                        }
                    } else {
                        Row(
                            modifier = Modifier
                                .padding(
                                    horizontal = 48.dp,
                                    vertical = MaterialTheme.spacing.small
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_baseline_shopping_cart_checkout),
                                contentDescription = "increase icon",
                                tint = MaterialTheme.colorScheme.digikalaRed,
                                modifier = Modifier
                                    .size(28.dp)
                                    .clickable {
                                        viewModel.changeCartItemStatus(item.itemId, CartStatus.CURRENT_CART

                                        )

                                    }
                            )
                        }

                    }


                }


                Spacer(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.semiMedium)
                )
                val discountAmount = (item.price * item.discountPercent) / 100

                Column {
                    Text(
                        text = "${digitByLocateAndSeparator(discountAmount.toString())} ${stringResource(id = R.string.discount)}",
                        style = MaterialTheme.typography.extraSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.DigikalaLightRed,
                    )
                    Row {
                        Text(
                            text = digitByLocateAndSeparator(item.price.toString()),
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.darkText,
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(MaterialTheme.spacing.extraSmall)
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))


            if (mode == CartStatus.CURRENT_CART) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.changeCartItemStatus(item.itemId, CartStatus.NEXT_CART)
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = stringResource(R.string.save_to_next_list),
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.DarkCyan
                    )

                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.DarkCyan
                    )
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.removeCartItem(item)
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = stringResource(R.string.delete_from_list),
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.DigikalaLightRed
                    )

                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.DigikalaLightRed
                    )
                }
            }



        }
    }
}

@Composable
private fun DetailRow(icon: Painter, text: String, color: Color, fontStyle: TextStyle) {
    Row(
        modifier = Modifier.padding(vertical = MaterialTheme.spacing.extraSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier
                .size(16.dp),
            tint = color,
        )

        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

        Text(
            text = text,
            style = fontStyle,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.semiDarkText,
            )


    }
}