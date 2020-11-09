package com.example.covidtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
private TextView tittleTv;
private ImageButton refresh0tn;
private BottomNavigationView navigationView;
private Fragment StatsFragment,HomeFragment;
private Fragment activeFragment;
private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        tittleTv =findViewById(R.id.tittleTv);
        refresh0tn=findViewById(R.id.refresh0tn);
navigationView=findViewById( R.id.navigationView );

initFragments();


refresh0tn.setOnClickListener( new View.OnClickListener(){
    @Override
    public void onClick(View view) {
HomeFragment.onResume();
StatsFragment.onResume();
    }
    });
navigationView.setOnNavigationItemSelectedListener( this );
    }
    private void initFragments(){
      HomeFragment=new HomeFragment();
      StatsFragment=new StatsFragment();
      fragmentManager=getSupportFragmentManager();
      activeFragment=HomeFragment;
      fragmentManager.beginTransaction()
              .add(R.id.frame,HomeFragment,"homeFragment")
              .commit();
      fragmentManager.beginTransaction().add( R.id.frame,StatsFragment,"statsFragment" )
              .hide(StatsFragment)
              .commit();

    }
    private void loadHomeFragment(){
        tittleTv.setText( "Home" );
        fragmentManager.beginTransaction().hide( activeFragment ).show( HomeFragment).commit();
        activeFragment=HomeFragment;

    }
private void loadStatsFragment(){
     tittleTv.setText( "COVID19 STATS" );
     fragmentManager.beginTransaction().hide( activeFragment ).show(StatsFragment).commit();
     activeFragment=StatsFragment;
}
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_home:
                loadHomeFragment();
return true;
            case R.id.nav_stats:
                loadStatsFragment();
return true;
        }
        return false;
    }
}