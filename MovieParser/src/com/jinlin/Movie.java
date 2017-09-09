package com.jinlin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jinlin on 1/28/17.
 * This class contains movie information like title, popularity, and vote average.
 */
public class Movie {

    //information about the movies
    private boolean adult;
    private String overview;
    private String release_date;
    private int[] genre_ids;
    private String original_title;
    private String original_language;
    private String title;
    private double popularity;
    private int vote_count;
    private boolean video;
    private double vote_average;

    //set the variables as private and use getter method to have read-only access
    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {

        return overview;
    }

    public String getReleaseDate() {

        return release_date;
    }

    public int[] getGenreIds() {

        return genre_ids;
    }

    public String getOriginalTitle() {

        return original_title;
    }

    public String getOriginalLanguage() {

        return original_language;
    }

    public String getTitle() {

        return title;
    }

    public double getPopularity() {

        return popularity;
    }

    public int getVoteCount() {

        return vote_count;
    }

    public boolean isVideo() {

        return video;
    }

    public double getVoteAverage() {

        return vote_average;
    }
}
