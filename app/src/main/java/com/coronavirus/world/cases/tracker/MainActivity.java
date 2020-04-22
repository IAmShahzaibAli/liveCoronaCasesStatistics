package com.coronavirus.world.cases.tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.coronavirus.world.cases.tracker.AllFragment.AllFragment;
import com.coronavirus.world.cases.tracker.Last24Hour.HourFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {



    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.MainBottomNavigationView);
        frameLayout = findViewById(R.id.MainFrameLayout);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.MainFrameLayout,new AllFragment()).commit();

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId())
        {
            case R.id.bottom_menu_all :
                fragment = new AllFragment();
                break;
            case R.id.bottom_menu_about :
                fragment = new About();
                break;
            case R.id.bottom_menu_24hour :
                fragment = new HourFragment();
                break;
        }
        return loadfragment(fragment);
    }
    private boolean loadfragment(Fragment fragment) {

        if (fragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainFrameLayout,fragment).commit();
            return true;
        }
        return false;
    }

}

