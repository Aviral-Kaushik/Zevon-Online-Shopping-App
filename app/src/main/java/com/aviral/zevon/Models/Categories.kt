package com.aviral.zevon.Models

class Categories(var imageURL: String, var categoryName: String) {

    fun getImageURl(): String {
        return imageURL
    }

    fun getCategory(): String {
        return categoryName
    }

    fun setImageUrl(imageURL: String) {
        this.imageURL = imageURL
    }

    fun setCategory(categoryName: String) {
        this.categoryName = categoryName;
    }
}