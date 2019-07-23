package com.nafidinara.twosubmission;

import android.os.Parcel;
import android.os.Parcelable;

public class Items implements Parcelable {
    private int image;
    private String title;
    private String release;
    private String director;
    private String runtime;
    private String language;
    private String score;
    private String genre;
    private String storyline;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeString(this.title);
        dest.writeString(this.release);
        dest.writeString(this.director);
        dest.writeString(this.runtime);
        dest.writeString(this.language);
        dest.writeString(this.score);
        dest.writeString(this.genre);
        dest.writeString(this.storyline);
    }

    public Items() {
    }

    protected Items(Parcel in) {
        this.image = in.readInt();
        this.title = in.readString();
        this.release = in.readString();
        this.director = in.readString();
        this.runtime = in.readString();
        this.language = in.readString();
        this.score = in.readString();
        this.genre = in.readString();
        this.storyline = in.readString();
    }

    public static final Parcelable.Creator<Items> CREATOR = new Parcelable.Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel source) {
            return new Items(source);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };
}
