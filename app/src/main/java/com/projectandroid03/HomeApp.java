package com.projectandroid03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);
        List<Category> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridViewCategory);
        gridView.setAdapter(new CustomCategoryAdapter(this, image_details));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                Category category = (Category) o;
                Toast.makeText((Context) HomeApp.this, (CharSequence) category, Toast.LENGTH_LONG).show();
            }
        });

    }

    private List<Category> getListData(){
        List<Category> list = new ArrayList<Category>();
        Category vietnam = new Category("Vietnam", "duocpham");

        list.add(vietnam);

        return  list;
    }

}