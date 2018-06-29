package com.share.shareeth

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.share.shareeth.utils.Density


/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/26
 */


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initJar()

    }

    private fun initJar() {
//        val designWidth = 750
//        RudenessScreenHelper(this, designWidth.toFloat()).activate()

        Density.setDensity(this, 375f)

        initLogger()
        initUtils()
    }

    private fun initUtils() {
        Utils.init(this)
    }

    private fun initLogger() {
        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
}