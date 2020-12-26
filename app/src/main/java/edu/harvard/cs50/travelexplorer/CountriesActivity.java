package edu.harvard.cs50.travelexplorer;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView2;
    private CountryAdapter countryAdapter;
    private LinearLayoutManager linearLayoutManager2;
    private String chosenRegion;
    private List<Country> countries;
    private JsonArrayRequest request;
    private RequestQueue requestQueue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        chosenRegion = getIntent().getStringExtra("region");
        countries = new ArrayList<>();

        recyclerView2 = findViewById(R.id.recycler_view2);
        loadCountries();
    }

    public void loadCountries() {
        String uri = "https://restcountries.eu/rest/v2/region/" + chosenRegion;
        request = new JsonArrayRequest(Request.Method.GET, uri, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Country country = new Country();
                        country.setName(jsonObject.getString("name"));
                        country.setCode(jsonObject.getString("alpha3Code"));
                        country.setCapital("Capital: " + jsonObject.getString("capital"));
                        country.setPopulation("Population: " + jsonObject.getString("population"));
                        country.setFlag_url(jsonObject.getString("flag"));
                        countries.add(country);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setupRecyclerView(countries);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(CountriesActivity.this);
        requestQueue.add(request);
    }

    private void setupRecyclerView(List<Country> countries) {
        linearLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(linearLayoutManager2);
        countryAdapter = new CountryAdapter(CountriesActivity.this, countries, chosenRegion);
        recyclerView2.setAdapter(countryAdapter);
    }
}

