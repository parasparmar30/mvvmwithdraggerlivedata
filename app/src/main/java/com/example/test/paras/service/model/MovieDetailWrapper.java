package com.example.test.paras.service.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDetailWrapper {
    @SerializedName("original_language")
    @Expose
    private String originalLlanguage;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("revenue")
    @Expose
    private String revenue;
    @SerializedName("genres")
    @Expose
    private ArrayList<GenresWrapper> genres;
    @SerializedName("popularity")
    @Expose
    private String popularity;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("vote_count")
    @Expose
    private String voteCount;
    @SerializedName("budget")
    @Expose
    private String budget;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("runtime")
    @Expose
    private String runtime;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("spoken_languages")
    @Expose
    private ArrayList<LanguageWrapper> spokenLanguages;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("vote_average")
    @Expose
    private String voteAverage;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("adult")
    @Expose
    private String adult;
    @SerializedName("status")
    @Expose
    private String status;

    public String getOriginalLlanguage() {
        return originalLlanguage;
    }

    public void setOriginalLlanguage(String originalLlanguage) {
        this.originalLlanguage = originalLlanguage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public ArrayList<GenresWrapper> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<GenresWrapper> genres) {
        this.genres = genres;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public ArrayList<LanguageWrapper> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(ArrayList<LanguageWrapper> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        // The URL will usually come from a model (i.e Profile)
        return posterPath;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load("https://image.tmdb.org/t/p/w500/"+imageUrl)
                .into(view);
    }
}
