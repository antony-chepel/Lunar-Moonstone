package com.ferrero.applayduG.web

import android.annotation.SuppressLint
import android.provider.MediaStore

import android.app.Activity
import android.content.Context

import java.io.IOException
import android.widget.Toast
import android.util.Log
import android.webkit.*


import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal

import android.content.Intent

import org.koin.androidx.viewmodel.ext.android.viewModel
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import com.ferrero.applayduG.AppClass
import com.ferrero.applayduG.AppClass.Companion.instId
import com.ferrero.applayduG.AppClass.Companion.myId
import com.ferrero.applayduG.R
import com.ferrero.applayduG.databinding.ActivityMysrBinding
import com.ferrero.applayduG.viewModel.LunarViewModel
import io.michaelrocks.paranoid.Obfuscate


import org.json.JSONException

import org.json.JSONObject

import java.io.File


@Obfuscate
class Web : AppCompatActivity() {
    var riifokodf: ValueCallback<Array<Uri>>? = null
    lateinit var awposldxlmc: WebView
    private val adsoixc = 1
    lateinit var fryus: ActivityMysrBinding
    var opdlsdkoxock: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fryus = ActivityMysrBinding.inflate(layoutInflater)
        setContentView(fryus.root)

        awposldxlmc = fryus.tysux
        Snackbar.make(
            fryus.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val reopskcx = CookieManager.getInstance()
        reopskcx.setAcceptCookie(true)
        reopskcx.setAcceptThirdPartyCookies(awposldxlmc, true)
        roiws()
        val deopslx: Activity = this
        awposldxlmc.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(cdops: WebView, qwpols: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(qwpols)) {
                        return false
                    }
                    if (eosdkkmxcmk(qwpols)) {

                        val vfiod = Intent(Intent.ACTION_VIEW)
                        vfiod.data = Uri.parse(qwpols)
                        startActivity(vfiod)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                cdops.loadUrl(qwpols)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)

                vfiosdp(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(deopslx, description, Toast.LENGTH_SHORT).show()
            }


        }
        awposldxlmc.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                vfuid: WebView, apolskkkxc: ValueCallback<Array<Uri>>,
                uwhdhuw: FileChooserParams
            ): Boolean {
                riifokodf?.onReceiveValue(null)
                riifokodf = apolskkkxc
                var gytidf: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (gytidf!!.resolveActivity(packageManager) != null) {

                    var acjuduhfds: File? = null
                    try {
                        acjuduhfds = kioslkjcx()
                        gytidf.putExtra("PhotoPath", opdlsdkoxock)
                    } catch (ex: IOException) {

                    }

                    if (acjuduhfds != null) {
                        opdlsdkoxock = "file:" + acjuduhfds.absolutePath
                        gytidf.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(acjuduhfds)
                        )
                    } else {
                        gytidf = null
                    }
                }
                val gyuidkc = Intent(Intent.ACTION_GET_CONTENT)
                gyuidkc.addCategory(Intent.CATEGORY_OPENABLE)
                gyuidkc.type = "image/*"
                val qpolsdmmxc: Array<Intent?> =
                    gytidf?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val gyufkkcvmmcxidf = Intent(Intent.ACTION_CHOOSER)
                gyufkkcvmmcxidf.putExtra(Intent.EXTRA_INTENT, gyuidkc)
                gyufkkcvmmcxidf.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser))
                gyufkkcvmmcxidf.putExtra(Intent.EXTRA_INITIAL_INTENTS, qpolsdmmxc)
                startActivityForResult(
                    gyufkkcvmmcxidf, adsoixc
                )
                return true
            }

            @Throws(IOException::class)
            private fun kioslkjcx(): File {
                var vgyfkcxdo = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!vgyfkcxdo.exists()) {
                    vgyfkcxdo.mkdirs()
                }

                vgyfkcxdo =
                    File(vgyfkcxdo.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return vgyfkcxdo
            }

        }

        awposldxlmc.loadUrl(qoisjdnjxc())
    }






    override fun onActivityResult(wopsdl: Int, zopdsl: Int, wopsd: Intent?) {
        if (wopsdl != adsoixc || riifokodf == null) {
            super.onActivityResult(wopsdl, zopdsl, wopsd)
            return
        }
        var eorokskd: Array<Uri>? = null


        if (zopdsl == AppCompatActivity.RESULT_OK) {
            if (wopsd == null || wopsd.data == null) {

                eorokskd = arrayOf(Uri.parse(opdlsdkoxock))
            } else {
                val nkiofo = wopsd.dataString
                if (nkiofo != null) {
                    eorokskd = arrayOf(Uri.parse(nkiofo))
                }
            }
        }
        riifokodf?.onReceiveValue(eorokskd)
        riifokodf = null
    }

    private var apsolxmccx = false
    override fun onBackPressed() {


        if (awposldxlmc.canGoBack()) {
            if (apsolxmccx) {
                awposldxlmc.stopLoading()
                awposldxlmc.loadUrl(aewps)
            }
            this.apsolxmccx = true
            awposldxlmc.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                apsolxmccx = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun roiws() {
        val tydifasd = awposldxlmc.settings
        tydifasd.setAppCacheEnabled(true)
        tydifasd.domStorageEnabled = true
        tydifasd.useWideViewPort = true
        tydifasd.displayZoomControls = false

        tydifasd.userAgentString = tydifasd.userAgentString.replace("; wv", "")
        tydifasd.builtInZoomControls = true

        tydifasd.javaScriptCanOpenWindowsAutomatically = true
        tydifasd.javaScriptEnabled = true

        tydifasd.allowContentAccess = true
        tydifasd.pluginState = WebSettings.PluginState.ON

        tydifasd.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        tydifasd.loadWithOverviewMode = true

        tydifasd.allowFileAccess = true


        tydifasd.setSupportMultipleWindows(false)


        tydifasd.setSupportZoom(true)



    }




    private fun qoisjdnjxc(): String {

        val sharPre = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)

        val pack = "com.ferrero.applayduG"

        val intent = intent
        val str = intent.getStringExtra("WebInt")

        val sharedMainId = getSharedPreferences(AppClass.mainId, MODE_PRIVATE)
        val sharedDeep= getSharedPreferences(AppClass.deep, MODE_PRIVATE)
        val sharedNaming= getSharedPreferences(AppClass.c1s, MODE_PRIVATE)
        val sharedLink= getSharedPreferences(AppClass.link, MODE_PRIVATE)

        val myTrId = sharPre.getString(myId, null)
        val myInstId: String? = sharPre.getString(instId, null)

        val cpOne:String? = sharedNaming.getString(AppClass.c1s,"null")

        val dpOne: String? = sharedDeep.getString(AppClass.deep,"null")

        val mainId: String? = sharedMainId.getString(AppClass.mainId,"null")

        val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)


        val one = "deviceID="
        val subOne = "sub_id_1="
        val thrhtrhtrhtrht = "ad_id="
        val fofofofofofofofofo = "sub_id_4="
        val fififififififififif = "sub_id_5="
        val sisisisifsisis = "sub_id_6="


        val lololololololo = "naming"
        val trololo = "deeporg"


        val kiokjjlikjhmkij = Build.VERSION.RELEASE



        val linkAB = sharedLink.getString(AppClass.link,"null")

        var aft = ""

        when (str) {
            "MT" -> {
                aft =
                    "$linkAB$one$myTrId&$thrhtrhtrhtrht$myInstId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                friodoosdf(myTrId.toString())
                Log.d("TESTAG", "urururururururur tracker: $aft")
            }
            "deepLink" -> {
                aft ="$linkAB$subOne$dpOne&$one$afId&$thrhtrhtrhtrht$mainId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$trololo"
                friodoosdf(myTrId.toString())
                Log.d("TESTAG", "urururururururur deep: $aft")
            }
            "campaign" -> {
                aft =
                    "$linkAB$subOne$cpOne&$one$afId&$thrhtrhtrhtrht$mainId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                friodoosdf(afId.toString())
                Log.d("TESTAG", "urururururururur apps: $aft")
            }
        }
        return sharPre.getString("SAVED_URL", aft).toString()
    }


    private fun eosdkkmxcmk(ro: String): Boolean {

        val deoopsdmxck = packageManager
        try {

            deoopsdmxck.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)

            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }





    var aewps = ""
    fun vfiosdp(frosp: String?) {
        if (!frosp!!.contains("t.me")) {

            if (aewps == "") {
                aewps = getSharedPreferences(
                    "SHARED_PREF",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    frosp
                ).toString()

                val reopsd = getSharedPreferences("SHARED_PREF", AppCompatActivity.MODE_PRIVATE)
                val zxdspwpsd = reopsd.edit()
                zxdspwpsd.putString("SAVED_URL", frosp)
                zxdspwpsd.apply()
            }
        }
    }

    private fun friodoosdf(cdopsd: String) {
        OneSignal.setExternalUserId(
            cdopsd,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(swsosplxck: JSONObject) {
                    try {
                        if (swsosplxck.has("push") && swsosplxck.getJSONObject("push").has("success")) {
                            val qposldkxc = swsosplxck.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $qposldkxc"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (swsosplxck.has("email") && swsosplxck.getJSONObject("email").has("success")) {
                            val vfgyudf =
                                swsosplxck.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $vfgyudf"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (swsosplxck.has("sms") && swsosplxck.getJSONObject("sms").has("success")) {
                            val acxzloxciuuwud = swsosplxck.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $acxzloxciuuwud"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }




}