package com.example.test.paras.service.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.test.paras.util.Constant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CastDetailWrapper {
    @SerializedName("cast_id")
    @Expose
    private String castId;
    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("credit_id")
    @Expose
    private String creditId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_path")
    @Expose
    private String profilePath;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("order")
    @Expose
    private String order;

    public String getCastId() {
        return castId;
    }

    public void setCastId(String castId) {
        this.castId = castId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getImageUrl() {
        return profilePath;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(Constant.IMAGE_URL +imageUrl)
                .into(view);
    }
}
