package com.example.addinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class view extends AppCompatActivity {

    private static final String viewApi = "http://172.23.189.249/Log_In/fatching.php";
    RecyclerView rcl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        setTitle("Student Information");

        rcl = (RecyclerView) findViewById(R.id.rcl);
        rcl.setLayoutManager(new LinearLayoutManager(this));

        processdata();

    }

    public void processdata(){

        StringRequest request = new StringRequest(viewApi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                GsonBuilder builder = new GsonBuilder();
                Gson gson =builder.create();
                model data[] = gson.fromJson(response,model[].class);

                myAdapter adapter = new myAdapter(data);
                rcl.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}