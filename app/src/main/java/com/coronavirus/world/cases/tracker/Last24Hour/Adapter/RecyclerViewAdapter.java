package com.coronavirus.world.cases.tracker.Last24Hour.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coronavirus.world.cases.tracker.Network.Country;
import com.coronavirus.world.cases.tracker.Network.Worldwide;
import com.coronavirus.world.cases.tracker.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    Context context;
    List<Country> adapterModelList;

    public RecyclerViewAdapter(Context context, List<Country> adapterModelList) {
        this.context = context;
        this.adapterModelList = adapterModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Country AdapterModel = adapterModelList.get(position);
        Worldwide worldwide = new Worldwide();
        holder.countryname.setText(String.valueOf(AdapterModel.getCountry()));
        holder.totalcountryconfirmedcases.setText(String.valueOf(AdapterModel.getTotalConfirmed()));
        holder.totalcountryrecovered.setText(String.valueOf(AdapterModel.getTotalRecovered()));
        holder.totalcountrydeaths.setText(String.valueOf(AdapterModel.getTotalDeaths()));
        holder.todaycountryconfirmedcases.setText(String.valueOf(AdapterModel.getNewConfirmed()));
        holder.todaycountryrecovered.setText(String.valueOf(AdapterModel.getNewRecovered()));
        holder.todaycountrydeaths.setText(String.valueOf(AdapterModel.getNewDeaths()));

    }

    @Override
    public int getItemCount() {
        return adapterModelList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView countryname,totalcountryconfirmedcases,totalcountryrecovered,totalcountrydeaths;
        TextView todaycountryconfirmedcases,todaycountryrecovered,todaycountrydeaths;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryname = itemView.findViewById(R.id.adapter_countryname);
            totalcountryconfirmedcases = itemView.findViewById(R.id.adapter_totalcases);
            totalcountryrecovered = itemView.findViewById(R.id.adapter_totalrecoveries);
            totalcountrydeaths = itemView.findViewById(R.id.adapter_totaldeaths);
            todaycountryconfirmedcases = itemView.findViewById(R.id.adapter_todaycases);
            todaycountryrecovered = itemView.findViewById(R.id.adater_todayrecoveries);
            todaycountrydeaths = itemView.findViewById(R.id.adapter_todaydeaths);
        }
    }
}
