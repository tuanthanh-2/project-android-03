package com.projectandroid03;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarHome;
    ViewFlipper viewFlipperhome;
    RecyclerView recyclerViewhome;
    ListView listViewhome;
    NavigationView navigationViewhome;
    DrawerLayout drawerHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_app);
        addControls();
        ActionBar();
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        List<String> quangcao = new ArrayList<>();
        quangcao.add("https://data-service.pharmacity.io/pmc-ecm-landingpage-api/production/landing-page/c0807f0f-4f57-4fc4-92ea-d94eb2651b5e.png");
        quangcao.add("https://data-service.pharmacity.io/pmc-ecm-webapp-config-api/production/banner/913x280%20(x1.5)%20(11)-1688600897275.png");
        quangcao.add("https://data-service.pharmacity.io/pmc-ecm-webapp-config-api/production/banner/BANNER%20CALCIUM_913(x1.5)-280%20(x1.5)-1687401452955.jpg");
        for( int i = 0; i < quangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());

        }
    }

    private void ActionBar(){
        setSupportActionBar(toolbarHome);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarHome.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbarHome.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerHome.openDrawer(GravityCompat.START);
            }
        });
    }
    private void addControls(){
        toolbarHome = (Toolbar) findViewById(R.id.toolbarhome);
        viewFlipperhome = (ViewFlipper) findViewById(R.id.viewfipperhome);
        recyclerViewhome = (RecyclerView) findViewById(R.id.recycleviewhome);
        listViewhome = (ListView) findViewById(R.id.listviewhome);
        navigationViewhome = (NavigationView) findViewById(R.id.navigationviewhome);
        drawerHome = (DrawerLayout) findViewById(R.id.drawerhome);
    }
}