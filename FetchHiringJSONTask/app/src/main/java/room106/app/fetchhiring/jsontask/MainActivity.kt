package room106.app.fetchhiring.jsontask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONException
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var listLinearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listLinearLayout = findViewById(R.id.listLinearLayout)

        fetchJSON("https://fetch-hiring.s3.amazonaws.com/hiring.json")
    }

    private fun fetchJSON (url: String) {
        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                parseJSONData(response)
            },
            { error ->
                showErrorToast()
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun parseJSONData(jsonArray: JSONArray) {
        val gson = Gson()
        val itemsList = ArrayList<Item>()

        try {
            // Parse all items and gather it in array
            for (i in 0 until jsonArray.length()) {
                // I'm using GSON to parse from json to Item object
                val item = gson.fromJson(jsonArray.getString(i), Item::class.java)

                // Filter out any items where "name" is blank or null.
                if (item.isNotNull()) {
                    itemsList.add(item)
                }
            }

            // Sort the results first by "listId" then by "name" when displaying.
            itemsList.sortWith(compareBy(Item::listId, Item::name))

            displayList(itemsList)
        } catch (e: JSONException) {
            showErrorToast()
        }
    }

    private fun displayList(itemsList: ArrayList<Item>) {
        itemsList.forEach {
            val itemView = ItemView(this, it)
            listLinearLayout.addView(itemView)
        }
    }

    private fun showErrorToast() {
        Toast.makeText(this, "Something went wrong..", Toast.LENGTH_LONG).show()
    }
}