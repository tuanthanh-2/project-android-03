package com.projectandroid03;

public class Category {
    private String categoryName;
    private String imageName;

    public Category(String categoryName, String imageName) {
        this.categoryName = categoryName;
        this.imageName = imageName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


}
