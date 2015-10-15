package com.h3s.photodrive.providers;

import java.util.ArrayList;

public class ImagesUrls {

    private ArrayList<String> imageUrls_left;
    private ArrayList<String> imageUrls_right;

    public ImagesUrls(){
        imageUrls_left = new ArrayList<String>();
        imageUrls_right = new ArrayList<String>();
        imageUrls_left.add("https://farm6.staticflickr.com/5775/21487047801_ee83213f8c_k.jpg");
        imageUrls_right.add("https://farm6.staticflickr.com/5775/21487047801_ee83213f8c_k.jpg");
    }

    public void addToLeftUrls(String url){ imageUrls_left.add(url); }

    public void addToRightUrls(String url){
        imageUrls_right.add(url);
    }

    public ArrayList<String> getImageUrls_right() {
        return imageUrls_right;
    }

    public void setImageUrls_right(ArrayList<String> imageUrls_right) {
        this.imageUrls_right = imageUrls_right;
    }

    public ArrayList<String> getImageUrls_left() {
        return imageUrls_left;
    }

    public void setImageUrls_left(ArrayList<String> imageUrls_left) {
        this.imageUrls_left = imageUrls_left;
    }


    public String[] imageUrls_left1 = new String[]{
            "https://farm6.staticflickr.com/5775/21487047801_ee83213f8c_k.jpg"/*,
            "https://farm6.staticflickr.com/5753/21467415062_e0d4909084_k.jpg",
            "https://farm6.staticflickr.com/5812/21291537529_e735f5c748_k.jpg",
            "https://farm1.staticflickr.com/660/21487047371_03da5bfeb2_k.jpg",
            "https://farm6.staticflickr.com/5715/21478440625_016c3b0404_k.jpg",
            "https://farm6.staticflickr.com/5628/21291537359_aa69fd8505_k.jpg",
            "https://farm1.staticflickr.com/588/20855727194_c5edb2c79f_k.jpg",
            "https://farm6.staticflickr.com/5769/21290624368_6df5ae5509_k.jpg"*/
    };

    public String[] imageUrls_right2 = new String[]{
            "https://farm1.staticflickr.com/744/21290401250_31e41d1c0e_k.jpg"/*,
            "https://farm6.staticflickr.com/5717/20857350263_9b204c8e8d_k.jpg",
            "https://farm1.staticflickr.com/777/21291536849_8ffd1412d7_k.jpg",
            "https://farm6.staticflickr.com/5755/21291536599_fd7b673075_k.jpg",
            "https://farm1.staticflickr.com/579/20857349903_4542140085_k.jpg",
            "https://farm1.staticflickr.com/567/21452213716_f3dfafd252_k.jpg",
            "https://farm1.staticflickr.com/583/21290623698_fe4010b1b3_k.jpg",
            "https://farm6.staticflickr.com/5632/21478439705_021d18e298_k.jpg"*/
    };
}
