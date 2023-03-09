package com.pureamorous.digikala.util

import com.pureamorous.digikala.BuildConfig

object Constants {
    const val ENGLISH_LANG = "en"
    const val PERSIAN_LANG = "fa"
    const val DATASTORE_NAME = "DIGIKALA_DATA_STORE"

    const val BASE_URL = "https://dig-za0p.onrender.com/api/"
    const val API_KEY = BuildConfig.X_API_KEY
    const val TIMEOUT_IN_SECOND: Long = 60
    var USER_LANGUAGE = "USER_LANGUAGE"
}