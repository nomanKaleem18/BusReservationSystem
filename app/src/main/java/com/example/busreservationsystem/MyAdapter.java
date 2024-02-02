package com.example.busreservationsystem;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.busreservationsystem.CityPair;
import com.example.busreservationsystem.R;

import java.util.ArrayList;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<CityPair> cityPairs = new ArrayList<>();
    private Context mContext;

    public MyAdapter(Context mContext, ArrayList<CityPair> cityPairs) {
        this.mContext = mContext;
        this.cityPairs = cityPairs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CityPair pair = cityPairs.get(position);

        holder.t1.setText(pair.getCity1());
        holder.t2.setText(pair.getCity2());
        holder.date.setText(pair.getDate());
    }

    @Override
    public int getItemCount() {
        return cityPairs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            date = itemView.findViewById(R.id.date);
        }
    }
}
