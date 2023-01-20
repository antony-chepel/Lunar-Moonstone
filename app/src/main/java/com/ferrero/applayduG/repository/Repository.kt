package com.ferrero.applayduG.repository

import com.ferrero.applayduG.api.KtorClient
import com.ferrero.applayduG.data.CountryJs
import com.ferrero.applayduG.data.GeoDev
import io.ktor.client.request.*


object Repository {
     suspend fun getData() : CountryJs {
         return KtorClient.httpClient.get("http://pro.ip-api.com/json/?key=ZSSz86ONagSoYRv")


     }

    suspend fun getDataDev() : GeoDev {
        return KtorClient.httpClient.get("http://lunarmnstone.fun/const.json")
        }

}