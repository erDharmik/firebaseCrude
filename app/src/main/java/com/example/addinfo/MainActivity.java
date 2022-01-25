package com.example.addinfo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {


    private final String addApi="http://172.23.189.249/Log_In/info.php";


    EditText t1,t2,t3;
    Button add,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Student Details");

        add= (Button) findViewById(R.id.btn);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertdata();

            }
        });

        view = (Button) findViewById(R.id.view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewdata();
            }
        });
    }
        public void insertdata(){
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.er);
        t3 = findViewById(R.id.mail);

        final String name  = t1.getText().toString();
        final String erNumber  = t2.getText().toString();
        final String Email = t3.getText().toString();


        StringRequest request = new StringRequest(Request.Method.POST, addApi , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();


            }
        }){
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> param = new HashMap<String , String>();
                param.put("t1",name);
                param.put("t2" , erNumber);
                param.put("t3" , Email);
                return param;
            }
        };

            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            queue.add(request);


    }

    public void viewdata(){
        Intent intent = new Intent(this , view.class);
        startActivity(intent);

    }


}