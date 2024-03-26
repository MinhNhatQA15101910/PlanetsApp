package com.donhat.planetsapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize list view
        ListView planetsListView = findViewById(R.id.planets_list_view);

        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Earth", "1 Moon", R.drawable.earth));
        planets.add(new Planet("Mercury", "0 Moon", R.drawable.mercury));
        planets.add(new Planet("Venus", "0 Moon", R.drawable.venus));
        planets.add(new Planet("Mars", "2 Moons", R.drawable.mars));
        planets.add(new Planet("Jupiter", "79 Moons", R.drawable.jupiter));
        planets.add(new Planet("Saturn", "83 Moons", R.drawable.saturn));
        planets.add(new Planet("Uranus", "27 Moons", R.drawable.uranus));
        planets.add(new Planet("Neptune", "14 Moons", R.drawable.neptune));

        PlanetAdapter planetAdapter = new PlanetAdapter(this, planets);

        planetsListView.setAdapter(planetAdapter);

        // Handle planets list view click event
        planetsListView.setOnItemClickListener(
                (parent, view, position, id) -> Toast
                        .makeText(
                                this,
                                "Planet Name: " + Objects.requireNonNull(
                                        planetAdapter.getItem(position))
                                        .getName(),
                                Toast.LENGTH_SHORT)
                        .show());
    }
}