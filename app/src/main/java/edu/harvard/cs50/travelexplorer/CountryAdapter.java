package edu.harvard.cs50.travelexplorer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder2> {

    private List<Country> countries;
    public String chosenRegion;
    private Context context;

    public CountryAdapter(Context context, List<Country> countries, String chosenRegion) {
        this.context = context;
        this.countries = countries;
        this.chosenRegion = chosenRegion;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row, parent, false);
        return new ViewHolder2(view2);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 countryViewHolder, int position) {
        countryViewHolder.country_name.setText(countries.get(position).getName());
        if ((countries.get(position).getName()).equals("")) {
            countryViewHolder.country_name.setText("Unknown");
        }
        countryViewHolder.country_code.setText(countries.get(position).getCode());
        if ((countries.get(position).getCode()).equals("")) {
            countryViewHolder.country_code.setText("N/A");
        }
        countryViewHolder.country_capital.setText(countries.get(position).getCapital());
        if ((countries.get(position).getCapital()).equals("Capital: ")) {
            countryViewHolder.country_capital.setText("Capital: N/A");
        }
        countryViewHolder.country_population.setText(countries.get(position).getPopulation());
        if ((countries.get(position).getPopulation()).equals("Population: ")) {
            countryViewHolder.country_population.setText("Population: N/A");
        }

        GlideApp.with(context).load(countries.get(position).getFlag_url()).apply(RequestOptions.centerCropTransform()).into(countryViewHolder.country_flag);
    }

    @Override
    public int getItemCount() {
        Log.d("size", String.valueOf(countries.size()));
        return countries.size();
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView country_name;
        TextView country_code;
        TextView country_capital;
        TextView country_population;
        ImageView country_flag;

        public ViewHolder2(@NonNull View itemView2) {
            super(itemView2);
            country_name = itemView2.findViewById(R.id.country_name);
            country_code = itemView2.findViewById(R.id.code);
            country_capital = itemView2.findViewById(R.id.capital);
            country_population = itemView2.findViewById(R.id.population);
            country_flag = itemView2.findViewById(R.id.flag);
        }
    }
}
