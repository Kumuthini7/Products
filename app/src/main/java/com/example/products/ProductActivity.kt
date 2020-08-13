package com.example.products

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class ProductActivity : AppCompatActivity() {
    var response: Response? = null
    private var adapter: RecyclerView.Adapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        response =
            Gson().fromJson<Response>(parseJSONData(), Response::class.java)
        adapter = ProductListAdapter(response?.products)
        recyclerView.adapter = adapter
    }

    private fun parseJSONData(): String? {
        var jsonValue: String? = null
        jsonValue = try {
            val inputStream: InputStream = assets.open("raw.json")
            val sizeOfJSONFile: Int = inputStream.available()
            val bytes = ByteArray(sizeOfJSONFile)
            inputStream.read(bytes)
            inputStream.close()
            String(bytes, Charset.forName("UTF-8")
            )
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return jsonValue
    }

}