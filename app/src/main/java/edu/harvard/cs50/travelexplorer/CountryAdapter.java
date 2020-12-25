package edu.harvard.cs50.travelexplorer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter {

    String chosenRegion;
    Context context;

    public CountryAdapter(Context context, String chosenRegion) {
        this.context = context;
        this.chosenRegion = chosenRegion;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row, parent, false);
        return new ViewHolder2(view2);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder2, int position) {
        ViewHolder2 countryViewHolder = (ViewHolder2) holder2;
        countryViewHolder.country.setText(chosenRegion); //TODO change this to the list of countries, not region placeholder
        Log.d("region", chosenRegion);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView country;

        public ViewHolder2(@NonNull View itemView2) {
            super(itemView2);
            country = itemView2.findViewById(R.id.country_row_text_view);
        }
    }
}
