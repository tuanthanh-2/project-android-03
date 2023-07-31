package com.projectandroid03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.List;

public class ListProduce extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produce);


        addProductToDatabase("a.jpg", "Acetylcystein (Hộp 10 vỉ x 10 viên)", "65000");


        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the database and fetch products from SQLite
        MyDatabaseHelper databaseHelper = new MyDatabaseHelper(this);
        productList = databaseHelper.getAllProducts();

        // Initialize the Adapter
        productAdapter = new ProductAdapter(productList);

        // Set the Adapter to the RecyclerView
        recyclerView.setAdapter(productAdapter);
    }
    private void addProductToDatabase(String imageResourceName, String name, String price) {
        MyDatabaseHelper databaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_IMAGE, imageResourceName);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);


        long newRowId = db.insert(TABLE_PRODUCTS, null, values);

        db.close();
    }
}