package com.example.test.paras.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CastWrapper {
    @SerializedName("cast")
    @Expose
    private ArrayList<CastDetailWrapper> cast;

    public ArrayList<CastDetailWrapper> getCast() {
        return cast;
    }

    public void setCast(ArrayList<CastDetailWrapper> cast) {
        this.cast = cast;
    }
}
