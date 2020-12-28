package edu.harvard.cs50.travelexplorer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder2> {

    public List<Country> countries;
    public String chosenRegion;
    public Context context;

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
        countryViewHolder.position = position;

        countryViewHolder.country_name.setText(countries.get(position).getName());
        countryViewHolder.name = countries.get(position).getName();
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

        if(countries.get(position).getCheckVisit()) {
            countryViewHolder.visitButton.setText("Explored!");
            countryViewHolder.visitButton.setBackgroundTintList(ColorStateList.valueOf(0xFF66FF66));
        }
        else {
            countryViewHolder.visitButton.setText("Never Explored");
            countryViewHolder.visitButton.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));
        }
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView country_name;
        TextView country_code;
        TextView country_capital;
        TextView country_population;
        ImageView country_flag;
        int position;
        String name;
        Button visitButton;
        boolean checkVisit;

        public ViewHolder2(@NonNull View itemView2) {
            super(itemView2);
            country_name = itemView2.findViewById(R.id.country_name);
            country_code = itemView2.findViewById(R.id.code);
            country_capital = itemView2.findViewById(R.id.capital);
            country_population = itemView2.findViewById(R.id.population);
            country_flag = itemView2.findViewById(R.id.flag);
            visitButton = itemView2.findViewById(R.id.visited_button);

            visitButton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    checkVisit = !checkVisit;
                    if (checkVisit) {
                        visitButton.setText("Explored!");
                        visitButton.setBackgroundTintList(ColorStateList.valueOf(0xFF66FF66));
                    }
                    else {
                        visitButton.setText("Never Explored");
                        visitButton.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));
                    }
                    countries.get(position).setCheckVisit(checkVisit);
                }
            });

        }
    }
}
