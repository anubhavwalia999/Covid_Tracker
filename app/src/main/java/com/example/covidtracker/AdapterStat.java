package com.example.covidtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterStat extends RecyclerView.Adapter<AdapterStat.HolderStat> implements Filterable {
   //view holder
    private Context context;
    public ArrayList<ModelStat> statArrayList, filterList;
    private FilterStat filter;


    public AdapterStat( Context context, ArrayList<ModelStat> statArrayList) {

        this.context = context;
        this.statArrayList = statArrayList;
    }

    @NonNull
    @Override
    public HolderStat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // inflate row stat
        View view= LayoutInflater.from( context ).inflate( R.layout.row_stat,parent,false );
        return new HolderStat( view );
    }

    @Override
    public void onBindViewHolder(@NonNull HolderStat holder, int position) {
//getdata
        ModelStat modelStat=statArrayList.get( position );

        String country=modelStat.getCountry();
        String totalConfirmed=modelStat.getTotalConfirmed();
        String totalDeaths=modelStat.getTotalDeaths();
        String totalRecovered=modelStat.getTotalRecovered();
        String newConfirmed=modelStat.getNewConfirmed();
        String newDeath=modelStat.getNewDeaths();
        String newRecovered=modelStat.getNewRecovered();

        //set data
        holder.countryTv.setText(country);
        holder.todayRecoveredtv.setText(newRecovered);
        holder.todayDeathstv.setText( newDeath );
        holder.todayCasestv.setText( newConfirmed );
        holder.recoveredtv.setText( totalRecovered );
        holder.deathtv.setText( totalDeaths );
        holder.casesTv.setText( totalConfirmed );
    }

    @Override
    public int getItemCount() {
        return statArrayList.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null){
            filter=new FilterStat( this,filterList );
        }
        return filter;
    }

    class HolderStat extends RecyclerView.ViewHolder{
        TextView countryTv,casesTv,todayCasestv,deathtv,todayDeathstv,recoveredtv,todayRecoveredtv;
        public HolderStat(@NonNull View itemView){
            super(itemView);
            //init UI Vieww
          countryTv=itemView.findViewById( R.id.country );
            casesTv=itemView.findViewById( R.id.totalcasestv );
            todayCasestv=itemView.findViewById( R.id.todayCasestv );
            deathtv=itemView.findViewById( R.id.deathtv );
            todayDeathstv=itemView.findViewById( R.id.todayDeathstv );
            recoveredtv=itemView.findViewById( R.id.recoveredtv );
            todayRecoveredtv=itemView.findViewById( R.id.todayRecoveredtv );

        }
   }
}
