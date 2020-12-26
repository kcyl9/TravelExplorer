package edu.harvard.cs50.travelexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    List<String> regionsList = Arrays.asList("Africa", "Americas", "Asia", "Europe", "Oceania", "Polar");
    List<String> regions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        regions.addAll(regionsList);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        RegionAdapter regionAdapter = new RegionAdapter((ArrayList<String>) regions, MainActivity.this);
        recyclerView.setAdapter(regionAdapter);
    }
}