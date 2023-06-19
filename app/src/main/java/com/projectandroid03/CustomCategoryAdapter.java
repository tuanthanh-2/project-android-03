package com.projectandroid03;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class CustomCategoryAdapter extends BaseAdapter {

    private List<Category> categoryList;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomCategoryAdapter(Context aContext, List<Category> categoryList){
        this.context = aContext;
        this.categoryList = categoryList;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_category_home, null);
            holder = new ViewHolder();
            holder.imageName = (ImageView) convertView.findViewById(R.id.imageViewCategory);
            holder.categoryName = (TextView) convertView.findViewById(R.id.tvNameCategory);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Category category = this.categoryList.get(position);
        holder.categoryName.setText(category.getCategoryName());

        int imageId = this.getMipmapResIdByName(category.getImageName());
        holder.imageName.setImageResource(imageId);
        return convertView;
    }

    static class ViewHolder{
        ImageView imageName;
        TextView categoryName;
    }

    private  int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("CustomCategoryAdapter", "ResName" + resName + "===> ResID = " + resID);
        return resID;
    }
}
