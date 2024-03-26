package com.donhat.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    private final Context _context;
    private final ArrayList<Planet> _planets;

    public PlanetAdapter(Context context, ArrayList<Planet> planets) {
        super(context, R.layout.item_planet, planets);
        _context = context;
        _planets = planets;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);

        PlanetViewHolder planetViewHolder;
        final View result;

        if (convertView == null) {
            planetViewHolder = new PlanetViewHolder();
            convertView = LayoutInflater
                    .from(_context)
                    .inflate(R.layout.item_planet, parent, false);

            planetViewHolder.planetImageView = convertView.findViewById(R.id.planet_image_view);
            planetViewHolder.planetNameTextView = convertView.findViewById(R.id.planet_name_text_view);
            planetViewHolder.moonCountTextView = convertView.findViewById(R.id.moon_count_text_view);

            result = convertView;

            convertView.setTag(planetViewHolder);
        } else {
            planetViewHolder = (PlanetViewHolder) convertView.getTag();
            result = convertView;
        }

        planetViewHolder.planetImageView.setImageResource(Objects.requireNonNull(planet).getImage());
        planetViewHolder.planetNameTextView.setText(planet.getName());
        planetViewHolder.moonCountTextView.setText(planet.getMoonCount());

        return result;
    }

    private static class PlanetViewHolder {
        TextView planetNameTextView;
        TextView moonCountTextView;
        ImageView planetImageView;
    }
}
