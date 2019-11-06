package pick.com.app.base

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.livinglifetechway.k4kotlin.core.onClick
import kotlinx.android.synthetic.main.static_web_url_activity.*
import kotlinx.android.synthetic.main.toolbar.*
import pick.com.app.R
import pick.com.app.base.model.StaticWebPagesModel
import pick.com.app.base.model.ToolbarCustom
import pick.com.app.databinding.StaticWebUrlActivityBinding
import pick.com.app.webservices.Urls

class PaymentActivity : BaseActivity(){

    private lateinit var binding : StaticWebUrlActivityBinding
    private var webPageUrl : String = ""
    private lateinit var toolbarCustom: ToolbarCustom


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.static_web_url_activity)
        println("type is   "+StaticWebPagesModel.type)
        println("url is    "+StaticWebPagesModel.url)
        webPageUrl=intent.getStringExtra("url")
     var   title=intent.getStringExtra("title")


        toolbarCustom = ToolbarCustom(
            ToolbarCustom.lefticon,
            title,
            ToolbarCustom.NoIcon,
            ToolbarCustom.NoIcon
        )
        binding.toolbar = toolbarCustom

        left_Icon.onClick { onBackPressed() }
        // println("type url is   "+typeUrl)


        web_view_static.setWebViewClient(MyBrowser())
        web_view_static.getSettings().setLoadsImagesAutomatically(true)
        web_view_static.getSettings().setJavaScriptEnabled(true)
        web_view_static.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)
        web_view_static.loadUrl(webPageUrl)
    }

    private inner class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }


}