package com.example.proyectofinal;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    CardView card1, card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);

        card1.setOnClickListener(v ->
                Toast.makeText(this, "Has hecho clic en Opción 1", Toast.LENGTH_SHORT).show()
        );

        card2.setOnClickListener(v ->
                Toast.makeText(this, "Has hecho clic en Opción 2", Toast.LENGTH_SHORT).show()
        );
    }    }