package com.kasra.marine.ui

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.bilerplatemvvm.R
import com.kasra.marine.ui.marine.MarineWebView
import com.kasra.marine.ui.marine.MyClient
import com.yariksoffice.lingver.Lingver
import java.util.*

class MarineActivity : AppCompatActivity() {
    private lateinit var webView: MarineWebView
    private var webSettings: WebSettings? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLocale(Locale("fa"))
        setContentView(R.layout.activity_marine)
        initView()
    }

    private fun setLocale(locale: Locale?) {
        var context: Context = applicationContext
        val resources: Resources = context.resources
        val configuration: Configuration = resources.configuration
        Locale.setDefault(locale)
        configuration.setLocale(locale)
        if (Build.VERSION.SDK_INT >= 25) {
            context = context.applicationContext.createConfigurationContext(configuration)
            context = context.createConfigurationContext(configuration)
        }
        context.resources.updateConfiguration(
            /* config = */ configuration,
            /* metrics = */ resources.getDisplayMetrics()
        )
    }

    private fun initView() {
        webView = findViewById(R.id.web_view)
        val button = findViewById<AppCompatButton>(R.id.submit).apply {
            setOnClickListener {
                run {

                    Toast.makeText(context, Locale.getDefault().toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        webView.initWebView(
            this,
            "http://192.168.50.122:3000/lego.web/Marine/FormMobile/Home?module=Avid",
            onError = {
                when(it){
                    is MyClient.WebViewClientError.GeneralError -> {
                        Toast.makeText(this, it.error.toString(), Toast.LENGTH_SHORT).show()
                    }
                    is MyClient.WebViewClientError.HttpError -> {
                        Toast.makeText(this, it.errorResponse.toString(), Toast.LENGTH_SHORT).show()
                    }
                    is MyClient.WebViewClientError.SslError -> {
                        Toast.makeText(this, it.error.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            })
        webView.onPageFinish = { _, s ->
            webView.callJsFunction(
                "setAuthorization",
                arrayListOf("'bearer SU7lHYwIRU14jaKQgW9T2A71CHl1YZuo1laxZ_iUxTgmjFsae9KD2wMbgLd2HU8BOehHRM1OZfGuTRC7uceBayxEwzBirtt2QEQujQ8Xpqm2jbnlmmx6ISkyG3F9mptBeCMyVKxtfV7EqrSJndEm9_OBMnpE9kiszOwW2KE2okNgeO1aoFtrjegXrFeeEgVRhmszxFUKPXPwyzfkJ2mesW-oHioOUEKS5jt_ihSnwZrHnmhGHaGni7A8vyY3aNZLrkwCU_MO0NU4_WZLVu0Nb92JS8IaVdTe5-C0zmzVIYvrFnIPtdqPSm9gSAyq9XSRit3y-kmomWSdXWptcxEFNaw0TRJ3ewh1q7FJagw-GyaZXswL6j34NNEjR2lnIcSmRFVl3H44XyULixksK2gmCJx-oPSUizNBUdQNXr_jCilhMOBjjlsfmKSzhVX_sJDGy8dx_vV4FjB8hMIoSLIbjQoEnVY5ubX8Cb0rUWyKtbayn320fcpEK8nSNOClU2oY'")
            )
            webView.callJsFunction(
                "setFormSchema_mobile", arrayListOf(
                    "{\n" +
                            "  \"form\": {\n" +
                            "    \"labelCol\": 6,\n" +
                            "    \"wrapperCol\": 12,\n" +
                            "    \"style\": {\n" +
                            "      \"margin\": \"20px 0px 0px 0px\"\n" +
                            "    },\n" +
                            "    \"bordered\": true\n" +
                            "  },\n" +
                            "  \"schema\": {\n" +
                            "    \"type\": \"object\",\n" +
                            "    \"properties\": {\n" +
                            "      \"name\": {\n" +
                            "        \"type\": \"string\",\n" +
                            "        \"title\": \"موضوع\",\n" +
                            "        \"x-decorator\": \"FormItem\",\n" +
                            "        \"x-component\": \"Input\",\n" +
                            "        \"x-validator\": [],\n" +
                            "        \"x-component-props\": {\n" +
                            "          \"style\": {\n" +
                            "            \"boxShadow\": \"0px 1px 5px 1px rgba(200,200,217,0.2)\",\n" +
                            "            \"fontWeight\": 600,\n" +
                            "            \"color\": \"rgba(32,19,96,1)\"\n" +
                            "          },\n" +
                            "          \"bordered\": false\n" +
                            "        },\n" +
                            "        \"x-decorator-props\": {\n" +
                            "          \"colon\": false,\n" +
                            "          \"labelCol\": 4,\n" +
                            "          \"wrapperCol\": 18\n" +
                            "        },\n" +
                            "        \"name\": \"name\",\n" +
                            "        \"x-designable-id\": \"ilk2r2xz50g\",\n" +
                            "        \"x-index\": 0\n" +
                            "      },\n" +
                            "      \"type\": {\n" +
                            "        \"title\": \"اپلیکیشن\",\n" +
                            "        \"x-decorator\": \"FormItem\",\n" +
                            "        \"x-component\": \"Select\",\n" +
                            "        \"x-validator\": [],\n" +
                            "        \"x-component-props\": {\n" +
                            "          \"style\": {\n" +
                            "            \"boxShadow\": \"0px 1px 5px 1px rgba(200,200,217,0.2)\",\n" +
                            "            \"fontWeight\": 600,\n" +
                            "            \"color\": \"rgba(2,22,48,1)\"\n" +
                            "          },\n" +
                            "          \"bordered\": false,\n" +
                            "          \"mode\": \"multiple\"\n" +
                            "        },\n" +
                            "        \"x-decorator-props\": {\n" +
                            "          \"labelWidth\": \"auto\",\n" +
                            "          \"labelCol\": 4,\n" +
                            "          \"wrapperCol\": 18,\n" +
                            "          \"colon\": false\n" +
                            "        },\n" +
                            "        \"enum\": [],\n" +
                            "        \"name\": \"type\",\n" +
                            "        \"x-designable-id\": \"oo0nz7macum\",\n" +
                            "        \"x-index\": 1,\n" +
                            "        \"x-reactions\": {\n" +
                            "          \"dependencies\": [\n" +
                            "            {\n" +
                            "              \"property\": \"value\",\n" +
                            "              \"type\": \"any\"\n" +
                            "            }\n" +
                            "          ],\n" +
                            "          \"fulfill\": {\n" +
                            "            \"run\": \"\$effect(() => {\\r\\n  callAPI(\\r\\n    \$self,\\r\\n    \\\"http://192.168.50.141/lego.web/api/Marine/ExternalObject/target/Data?CategoryId=1\\\"\\r\\n  )\\r\\n}, [])\"\n" +
                            "          }\n" +
                            "        }\n" +
                            "      },\n" +
                            "      \"select\": {\n" +
                            "        \"title\": \"نوع\",\n" +
                            "        \"x-decorator\": \"FormItem\",\n" +
                            "        \"x-component\": \"Select\",\n" +
                            "        \"x-validator\": [],\n" +
                            "        \"x-component-props\": {\n" +
                            "          \"style\": {\n" +
                            "            \"boxShadow\": \"0px 1px 5px 1px rgba(200,200,217,0.2)\",\n" +
                            "            \"fontWeight\": 600,\n" +
                            "            \"color\": \"rgba(32,19,96,1)\"\n" +
                            "          }\n" +
                            "        },\n" +
                            "        \"x-decorator-props\": {\n" +
                            "          \"labelCol\": 4,\n" +
                            "          \"wrapperCol\": 18,\n" +
                            "          \"colon\": false,\n" +
                            "          \"bordered\": false\n" +
                            "        },\n" +
                            "        \"name\": \"select\",\n" +
                            "        \"x-designable-id\": \"1ziz8m3jikx\",\n" +
                            "        \"x-index\": 2,\n" +
                            "        \"x-reactions\": {\n" +
                            "          \"dependencies\": [\n" +
                            "            {\n" +
                            "              \"property\": \"value\",\n" +
                            "              \"type\": \"any\"\n" +
                            "            }\n" +
                            "          ],\n" +
                            "          \"fulfill\": {\n" +
                            "            \"state\": {},\n" +
                            "            \"run\": \"\$effect(() => {\\n  callAPI(\\n    \$self,\\n    \\\"http://192.168.50.141/lego.web/api/Marine/ExternalObject/MarineLookup/Data?CategoryId=2\\\"\\n  )\\n}, [])\\n\"\n" +
                            "          }\n" +
                            "        }\n" +
                            "      },\n" +
                            "      \"jbf0ostt64t\": {\n" +
                            "        \"type\": \"string\",\n" +
                            "        \"title\": \"متن پیام\",\n" +
                            "        \"x-decorator\": \"FormItem\",\n" +
                            "        \"x-component\": \"Input.TextArea\",\n" +
                            "        \"x-validator\": [],\n" +
                            "        \"x-component-props\": {\n" +
                            "          \"style\": {\n" +
                            "            \"boxShadow\": \"0px 1px 5px 1px rgba(200,200,217,0.2)\",\n" +
                            "            \"fontWeight\": 600,\n" +
                            "            \"color\": \"rgba(3,18,97,1)\"\n" +
                            "          },\n" +
                            "          \"bordered\": false\n" +
                            "        },\n" +
                            "        \"x-decorator-props\": {\n" +
                            "          \"colon\": false,\n" +
                            "          \"labelCol\": 4,\n" +
                            "          \"wrapperCol\": 18,\n" +
                            "          \"bordered\": true\n" +
                            "        },\n" +
                            "        \"required\": false,\n" +
                            "        \"default\": \"\",\n" +
                            "        \"x-designable-id\": \"jbf0ostt64t\",\n" +
                            "        \"x-index\": 3\n" +
                            "      },\n" +
                            "       \"j3wuw3q79y6\": {\n" +
                            "\n" +
                            "        \"type\": \"Array<object>\",\n" +
                            "\n" +
                            "        \"title\": \"Upload\",\n" +
                            "\n" +
                            "        \"x-decorator\": \"FormItem\",\n" +
                            "\n" +
                            "        \"x-component\": \"Upload\",\n" +
                            "\n" +
                            "        \"x-component-props\": {\n" +
                            "\n" +
                            "          \"textContent\": \"Upload\"\n" +
                            "\n" +
                            "        },\n" +
                            "\n" +
                            "        \"x-validator\": [],\n" +
                            "\n" +
                            "        \"x-decorator-props\": {},\n" +
                            "\n" +
                            "        \"x-designable-id\": \"j3wuw3q79y6\",\n" +
                            "\n" +
                            "        \"x-index\": 4\n" +
                            "\n" +
                            "      }\n" +
                            "    },\n" +
                            "    \"x-designable-id\": \"yb2wmlubksy\"\n" +
                            "  }\n" +
                            "}"
                )
            )
        }
    }

}