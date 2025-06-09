package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario, etClave;
    Button btnLogin;
    String URL = "http://192.168.12.67/api.php"; // Cambia por tu IP local

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString();
            String clave = etClave.getText().toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                    response -> {
                        try {
                            JSONObject json = new JSONObject(response);
                            if (json.getString("estado").equals("ok")) {

            Intent intento=new Intent(MainActivity.this,DashboardActivity.class);
            startActivity(intento);
                       //   startActivity(new Intent(MainActivity.this, DashboardActivity.class));

                            } else {
                                Toast.makeText(this, json.getString("mensaje"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    },
                    error -> Toast.makeText(this, "Error en conexión", Toast.LENGTH_SHORT).show()) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> parametros = new HashMap<>();
                    parametros.put("usuario", usuario);
                    parametros.put("clave", clave);
                    return parametros;
                }
            };

            Volley.newRequestQueue(this).add(stringRequest);
        });
    }
}