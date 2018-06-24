package com.esi.tdm.apetito.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.widget.ListView
import com.braintreepayments.api.dropin.DropInActivity
import com.braintreepayments.api.dropin.DropInRequest
import com.braintreepayments.api.dropin.DropInResult
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.config.baseUrl
import com.esi.tdm.apetito.models.CartItem
import com.esi.tdm.apetito.models.CartItems
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_order.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class OrderActivity : AppCompatActivity() {

    var token: String = ""
    val REQUEST_CODE = 1
    var paramHash: HashMap<String, String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        get_token()
        orderNow.setOnClickListener(View.OnClickListener {
            onBraintreeSubmit()


        })



    }

    var result: DropInResult? = null;
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === REQUEST_CODE) {
            if (resultCode === Activity.RESULT_OK) {
                val result = data!!.getParcelableExtra<DropInResult>(DropInResult.EXTRA_DROP_IN_RESULT)
                // use the result to update your UI and send the payment method nonce to your server
                val nonce = result.getPaymentMethodNonce()
                val stringNonce = nonce!!.getNonce()
                Log.i("mylog", "Result: " + stringNonce)
                    val amount="1000"

                    paramHash = java.util.HashMap()
                    paramHash!!.put("amount",amount)
                    paramHash!!.put("payment_method_nonce",stringNonce)
                    sendPaymentDetails(amount,stringNonce,params = RequestParams())

            } else if (resultCode === Activity.RESULT_CANCELED) {
                // the user canceled
            } else {
                // handle errors here, an exception may be available in
                val error = data!!.getSerializableExtra(DropInActivity.EXTRA_ERROR) as Exception
            }
        }
    }


    fun get_token() {
        val client = AsyncHttpClient()
        client.get(baseUrl+"client_token", object : TextHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                Log.d("mLog", responseString)
                token = responseString!!
                toast("Successfully got token")

            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseString: String?, throwable: Throwable?) {
                toast("Error in getting token")
            }

        })
    }

    fun onBraintreeSubmit() {
        val dropInRequest = DropInRequest()
                .clientToken(token)
        startActivityForResult(dropInRequest.getIntent(this), REQUEST_CODE)
    }
    fun sendPaymentDetails(amount:String,nonce:String,params:RequestParams){
        val client = AsyncHttpClient()

        client.post(baseUrl+"checkout/"+amount+"/"+nonce,object: AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?) {
                toast("Commander avec succes , Merci !")
                CartItems.list = mutableListOf<CartItem>()
                startActivity(intentFor<MainActivity>())
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                toast("Transaction failed")
            }

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
