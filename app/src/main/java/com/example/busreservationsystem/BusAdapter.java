package com.example.busreservationsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.BusViewHolder> {

    private Context context;
    private List<Bus> busList;

    public BusAdapter(Context context) {
        this.context = context;
        this.busList = busList;
    }

    @NonNull
    @Override
    public BusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bus_item, parent, false);
        return new BusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusViewHolder holder, int position) {
        Bus bus = busList.get(position);

        // Bind data to ViewHolder
        holder.departureTextView.setText("Departure: " + bus.getDeparture());
        holder.arrivalTextView.setText("Arrival: " + bus.getArrival());
        holder.travelDateTextView.setText("Travel Date: " + bus.getTravelDate());
        holder.priceTextView.setText("Price: $" + bus.getPrice());
    }

    @Override
    public int getItemCount() {
        return busList.size();
    }

    static class BusViewHolder extends RecyclerView.ViewHolder {
        TextView departureTextView, arrivalTextView, travelDateTextView, priceTextView;

        public BusViewHolder(@NonNull View itemView) {
            super(itemView);
            departureTextView = itemView.findViewById(R.id.departureTextView);
            arrivalTextView = itemView.findViewById(R.id.arrivalTextView);
            travelDateTextView = itemView.findViewById(R.id.travelDateTextView);
            priceTextView = itemView.findViewById(R.id.price);
        }
    }
}
