package com.example.covidtracker;

import android.graphics.ColorSpace;
import android.widget.Filter;

import java.util.ArrayList;

class FilterStat extends Filter {
    private AdapterStat adapter;
    private ArrayList<ModelStat> filterList;
    public FilterStat(AdapterStat adapter,ArrayList<ModelStat> filterList){
        this.adapter=adapter;
        this.filterList=filterList;

    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults(  );
        //check constraint validity
        if(constraint !=null && constraint.length()>0){
            constraint=constraint.toString().toUpperCase();
            //store our filteredModel
            ArrayList<ModelStat> filteredModels=new ArrayList<>();
            for(int i=0;i< filterList.size();i++){
                if(filterList.get(i).getCountry().toUpperCase().contains( constraint )){
                    filteredModels.add(filterList.get( i ));
                }
            }
            results.count=filteredModels.size();
            results.values=filteredModels;

        }else{
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults results) {
adapter.statArrayList=(ArrayList<ModelStat>) results.values;
adapter.notifyDataSetChanged();
    }
}
