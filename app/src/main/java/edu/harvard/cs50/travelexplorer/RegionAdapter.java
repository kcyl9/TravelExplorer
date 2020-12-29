package edu.harvard.cs50.travelexplorer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class RegionAdapter extends RecyclerView.Adapter {

    ArrayList regions;
    Context context;

    public RegionAdapter(ArrayList<String> regions, Context context) {
        this.regions = regions;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.region_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        String fraction;
        String percent;
        ViewHolder regionViewHolder = (ViewHolder) holder;
        regionViewHolder.region.setText((CharSequence) regions.get(position));

        fraction = MainActivity.countVisited.get(regions.get(position)) + "/" + MainActivity.total.get(regions.get(position));
        Log.d("debug", fraction);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = (String) regions.get(position);
                Intent intent = new Intent(view.getContext(), CountriesActivity.class);
                intent.putExtra("region", current);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return regions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView region;
        TextView fraction;
        TextView percent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            region = itemView.findViewById(R.id.region_row_text_view);
            fraction = itemView.findViewById(R.id.fraction);
            percent = itemView.findViewById(R.id.percent);
        }
    }
}
