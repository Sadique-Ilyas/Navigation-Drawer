package com.example.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
        }

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_navigation_button);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigationView);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new HomeFragment(),null).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        menuItem.setChecked(true);
                        fragmentTransaction.add(R.id.fragment_container,new HomeFragment(),null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_message:
                        menuItem.setChecked(true);
                        fragmentTransaction.replace(R.id.fragment_container,new MessageFragment(),null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_image:
                        menuItem.setChecked(true);
                        fragmentTransaction.replace(R.id.fragment_container,new ImagesFragment(),null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_video:
                        menuItem.setChecked(true);
                        fragmentTransaction.replace(R.id.fragment_container,new VideosFragment(),null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_share:
                        menuItem.setChecked(true);
                        Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                    case R.id.nav_contact:
                        menuItem.setChecked(true);
                        Toast.makeText(getApplicationContext(),"Contact Us",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
       return super.onOptionsItemSelected(item);
    }
}

