package com.ferrero.applayduG

import android.app.Application
import android.content.Context
import com.ferrero.applayduG.di.mainViewModel
import com.ferrero.applayduG.di.userDB
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import io.michaelrocks.paranoid.Obfuscate
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.*

@Obfuscate
class AppClass : Application() {
    companion object {

        const val oneSignal = "1a161082-8069-4b38-b978-e9c3afbbf233"
        var deep: String? = "d11"
        val appsID = "fqYv8KFwxqDFezfoyeoHMA"
        var c1s: String? = "c11"
        var link = "link"
        var mainId: String? = "mainid"
        val myId: String = "myID"
        var instId: String? = "instID"

    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppClass)
            modules(
                userDB,
                mainViewModel,

                )
        }
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(oneSignal)

        val oicjicjxd = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val tifjjdfijidf = getSharedPreferences("PREFS_NAME", 0)

        val oxkjicjxiz = MyTracker.getTrackerParams()
        val psosloxkczjixjiz = MyTracker.getTrackerConfig()
        val tiuhdsjifijsdfji = MyTracker.getInstanceId(this)
        psosloxkczjixjiz.isTrackingLaunchEnabled = true
        val siajddiasj = UUID.randomUUID().toString()

        if (tifjjdfijidf.getBoolean("my_first_time", true)) {
            oxkjicjxiz.setCustomUserId(siajddiasj)
            oicjicjxd.edit().putString(myId, siajddiasj).apply()
            oicjicjxd.edit().putString(instId, tiuhdsjifijsdfji).apply()
            tifjjdfijidf.edit().putBoolean("my_first_time", false).apply()
        } else {
            val mcxivjivjxcjixcv = oicjicjxd.getString(myId, siajddiasj)
            oxkjicjxiz.setCustomUserId(mcxivjivjxcjixcv)
        }
        MyTracker.initTracker("68730396266309548180", this)
    }
}