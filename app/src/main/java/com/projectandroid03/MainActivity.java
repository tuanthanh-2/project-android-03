package com.projectandroid03;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
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
            Glide.with(getApplicationContext()).load(quangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperhome.addView(imageView);
        }
        viewFlipperhome.setFlipInterval(3000);
        viewFlipperhome.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipperhome.setInAnimation(slide_in);
        viewFlipperhome.setOutAnimation(slide_out);
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