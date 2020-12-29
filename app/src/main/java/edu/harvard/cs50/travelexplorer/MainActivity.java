package edu.harvard.cs50.travelexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    List<String> regionsList = Arrays.asList("Africa", "Americas", "Asia", "Europe", "Oceania", "Polar");
    List<String> regions = new ArrayList<>();
    public static ArrayList<String> visited = new ArrayList<>();
    public static HashMap<String, Integer> countVisited = new HashMap<>();
    public static HashMap<String, Integer> total = new HashMap<>();

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

        if (countVisited.isEmpty()) {
            for (int i = 0; i < regions.size(); i++) {
                countVisited.put(regions.get(i), 0);
            }
        }
        total.put("Africa", 60);
        total.put("Americas", 57);
        total.put("Asia", 50);
        total.put("Europe", 53);
        total.put("Oceania", 27);
        total.put("Polar", 1);
    }
}