package com.example.covidtracker;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONObject;


public class HomeFragment extends Fragment {
    private static final String STATS_URL="https://api.covid19api.com/summary";
Context context;
private ProgressBar progressBar;
private TextView totalCases,newCases,totalDeath,newDeath,totalRecovere,newRecovere;
    public HomeFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach( context );
        this.context=context;
    }

        // Required empty public constructor



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view=inflater.inflate( R.layout.fragment_home,container,false );
progressBar=view.findViewById( R.id.progrssBar );
        totalCases=view.findViewById( R.id.totalCases );
        newCases=view.findViewById( R.id.newCases );
        totalDeath=view.findViewById( R.id.totalDeaths );
        newDeath=view.findViewById( R.id.newDeaths );
        totalRecovere=view.findViewById( R.id.totalRecovered );
        newRecovere=view.findViewById( R.id.newRecovered );

        loadhomeData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadhomeData();
    }

    private void loadhomeData(){
        progressBar.setVisibility( View.VISIBLE );
        StringRequest stringRequest=new StringRequest( Request.Method.GET, STATS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
handelResponse( response );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //to display error message
                progressBar.setVisibility( View.GONE );
                Toast.makeText( context, ""+error.getMessage(), Toast.LENGTH_SHORT ).show();

            }
        } );
        //Add request to queue
        RequestQueue requestQueue= Volley.newRequestQueue( context );
        requestQueue.add( stringRequest );
    }
    private void handelResponse(String response){
        try{
            //to convert JSON data
            JSONObject jsonObject=new JSONObject(response);
            JSONObject global=jsonObject.getJSONObject("Global");
            String newConfirmed=global.getString( "NewConfirmed" );
            String totalConfirmed=global.getString( "TotalConfirmed" );
            String newDeaths=global.getString( "NewDeaths" );
            String totalDeaths=global.getString( "TotalDeaths" );
            String newRecovered=global.getString( "NewRecovered" );
            String totalRecovered=global.getString( "TotalRecovered" );

            totalCases.setText( totalConfirmed );
            newCases.setText( newConfirmed );
            totalDeath.setText( totalDeaths );
            newDeath.setText(  newDeaths);
            newRecovere.setText( newRecovered );
            totalRecovere.setText( totalRecovered );

            progressBar.setVisibility( View.GONE );
        }catch (Exception e){
            progressBar.setVisibility( View.GONE );
            Toast.makeText( context, ""+e.getMessage(), Toast.LENGTH_SHORT ).show();
        }
    }
}