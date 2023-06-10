package com.example.simon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Request;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class RegisterManager extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName, editTextUsername, editTextEmail, editTextPassword, editTextNomor;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_register_manager);


        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextNomor = (EditText) findViewById(R.id.editTextNomor);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);

    }

    private void registerUser() {
        final String email = editTextEmail.getText().toString().trim();
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String name = editTextName.getText().toString().trim();
        final String nomor_telp = editTextNomor.getText().toString().trim();


        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER_MANAGER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        Toast.makeText(getApplicationContext(), "Register success", Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("username", username);
                params.put("email", email);
                params.put("password", password);
                params.put("nomor_telp", nomor_telp);

                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }
    @Override
    public void onClick(View view) {
        if (view == buttonRegister)
            registerUser();
    }
}