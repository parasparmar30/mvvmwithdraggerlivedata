package com.example.test.paras.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class MoviesWrapper {
    @SerializedName("results")
    @Expose
    private ArrayList<MovieItemsWrapper> items;


    public ArrayList<MovieItemsWrapper> getItems() {
        return items;
    }

    public void setItems(ArrayList<MovieItemsWrapper> items) {
        this.items = items;
    }

}
