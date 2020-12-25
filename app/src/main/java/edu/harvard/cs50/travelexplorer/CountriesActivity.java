package edu.harvard.cs50.travelexplorer;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView2;
    private LinearLayoutManager linearLayoutManager2;
    private String chosenRegion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        chosenRegion = getIntent().getStringExtra("region");

        recyclerView2 = findViewById(R.id.recycler_view2);
        linearLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(linearLayoutManager2);
        CountryAdapter countryAdapter = new CountryAdapter(CountriesActivity.this, chosenRegion);
        recyclerView2.setAdapter(countryAdapter);
    }
}
