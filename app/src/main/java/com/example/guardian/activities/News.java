package com.example.guardian.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.guardian.R;
import com.example.guardian.adapter.RvAdapter;
import com.example.guardian.model.Updates;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity {
    private List<Updates> lstUpdates = new ArrayList<>();
    private RecyclerView myrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        myrv = findViewById(R.id.rv);
        jsoncall();
    }

    private void jsoncall() {

        String URL_JSON = "https://script.google.com/macros/s/AKfycbz3te0zi2fokOHsKg5bFA1nuFUMpnOQDL9LGMkjONHXaQBb8f66/exec";
        JsonArrayRequest arrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;
                for (int i = 0; i < response.length(); i++) {

                    try {

                        jsonObject = response.getJSONObject(i);
                        Updates updates = new Updates();

                        updates.setHeadline(jsonObject.getString("headlines"));
                        updates.setLink(jsonObject.getString("links"));

                        lstUpdates.add(updates);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                setRvadapter(lstUpdates);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(News.this);

        requestQueue.add(arrayRequest);


    }

    private void setRvadapter(List<Updates> lst) {

        RvAdapter myAdapter = new RvAdapter(this,lst);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
    }

}
