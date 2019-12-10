package com.wang.firstcode.materialdesign;

/**
 * Created by wangchangshu on 2019-12-01.
 * Describe:
 */
public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
