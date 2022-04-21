package com.example.movieapp.model;

public class DataModel {
    private String name;
    private String storyline;
    private String runtime;
    private String rating;
    private String categories;
    private String director;
    private String img;

    public DataModel() {
    }

    public DataModel(String name, String storyline, String runtime, String rating, String categories, String director, String img) {
        this.name = name;
        this.storyline = storyline;
        this.runtime = runtime;
        this.rating = rating;
        this.categories = categories;
        this.director = director;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
