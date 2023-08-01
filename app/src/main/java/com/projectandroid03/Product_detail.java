package com.projectandroid03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Product_detail extends AppCompatActivity {

    private Product selectedProduct;
    private int selectedQuantity = 1; // Giá trị mặc định là 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Lấy dữ liệu sản phẩm từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            selectedProduct = intent.getParcelableExtra("selectedProduct");
        }

        // Kiểm tra xem sản phẩm đã được lấy thành công hay không
        if (selectedProduct != null) {
            // Hiển thị dữ liệu sản phẩm lên giao diện
            displayProductDetails();
        }

        Button btnThem = findViewById(R.id.btnThem);
        btnThem.setOnClickListener(v -> {
            // Thêm sản phẩm vào giỏ hàng
            // (Bạn có thể sử dụng Intent để chuyển thông tin sản phẩm sang Activity giỏ hàng)
        });

        ImageView iconBack = findViewById(R.id.imageView9);
        iconBack.setOnClickListener(v -> {
            // Trở về trang trước đó khi nhấn vào icon_back
            onBackPressed();
        });

        ImageView iconSellStock = findViewById(R.id.imageView7);
        iconSellStock.setOnClickListener(v -> {
            // Chuyển sang trang giỏ hàng khi nhấn vào icon_sell_stock
            Intent cartIntent = new Intent(Product_detail.this, MainActivity.class);
            startActivity(cartIntent);
        });

        // Xử lý Spinner để người dùng chọn số lượng sản phẩm
        Spinner spinnerQuantity = findViewById(R.id.spinnerSP);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.quantity_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuantity.setAdapter(adapter);
        spinnerQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Lưu số lượng được chọn vào biến selectedQuantity
                String selectedQuantityStr = parent.getItemAtPosition(position).toString();
                selectedQuantity = Integer.parseInt(selectedQuantityStr);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không làm gì nếu không có lựa chọn nào được chọn
            }
        });
    }

    private void displayProductDetails() {
        TextView tvProductName = findViewById(R.id.tensp);
        TextView tvProductPrice = findViewById(R.id.giasp);
        ImageView imgProduct = findViewById(R.id.img_detail_product);

        // Lấy thông tin sản phẩm từ biến selectedProduct
        String productName = selectedProduct.getProduct_name();
        String productPrice = selectedProduct.getProduct_price();
        Uri productImageUri = selectedProduct.getProduct_image();

        // Hiển thị thông tin sản phẩm lên giao diện
        tvProductName.setText(productName);
        tvProductPrice.setText(productPrice);
        imgProduct.setImageURI(productImageUri);
    }
}
