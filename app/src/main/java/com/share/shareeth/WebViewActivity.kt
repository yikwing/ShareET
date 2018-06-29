package com.share.shareeth

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.widget.LinearLayout
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_webview.*


/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/26
 */
class WebViewActivity : AppCompatActivity() {

    lateinit var mAgentWeb: AgentWeb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val urlAddress = intent.getStringExtra("url")

//        toolbar.title = "webview"
//        setSupportActionBar(toolbar)

//        val settings = mWebview.settings
//        //开启缩放
//        settings.setSupportZoom(true)
//        //使用js
//        settings.javaScriptEnabled = true
//
//        mWebview.webChromeClient = object : WebChromeClient() {
//            override fun onProgressChanged(view: WebView?, newProgress: Int) {
//
//                if (newProgress == 100) {
//                    myProgressBar.visibility = View.INVISIBLE;
//                } else {
//                    if (View.INVISIBLE == myProgressBar.visibility) {
//                        myProgressBar.visibility = View.VISIBLE;
//                    }
//                    myProgressBar.progress = newProgress;
//                }
//            }
//
//        }
//
//        mWebview.webViewClient = WebViewClient()
//
//        //加载本地网页
//        mWebview.loadUrl(urlAddress)


        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(container, LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(urlAddress)


    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()) {
//            mWebview.goBack()// 返回前一个页面
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            true
        } else super.onKeyDown(keyCode, event)
    }

    override fun onPause() {
        mAgentWeb.webLifeCycle.onPause()
        super.onPause()

    }

    override fun onResume() {
        mAgentWeb.webLifeCycle.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb.webLifeCycle.onDestroy()
        super.onDestroy()
    }

}