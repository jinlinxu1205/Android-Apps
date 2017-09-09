package com.jinlin;

import java.util.ArrayList;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.*;

/**
 * Created by Jinlin on 1/28/17.
 * This class contains the results in the web page and return the required movies to the MovieParser.
 */
public class MovieCollection {

    private Movie[] results;

    public Movie[] getResults() {
        return results;
    }

    public String printAll(int need) throws IOException {

        ArrayList<MovieCollection> movieCollections = new ArrayList<>();

        //there are 20 movie objects in a page
        int pageNum = need/20 + 1;

        //the jsonreader reads the url and gets json object from the webpage until the required number is met
        //if the pageNum hits 15, call requestLimit() to see whether need to limit the amount of time requesting the response
        for (int i = 1; i < pageNum + 1; i ++){
            if (i > 15) {
                requestLimit(i);
            }

            URL url = new URL(APIKey.getApiKey() + Integer.toString(i));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            JsonReader reader = new JsonReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            movieCollections.add(gson.fromJson(reader, MovieCollection.class));
        }

        int count = 0;
        String allTitle = "";

        //add the movie title to allTitle until the required number of movies is met
        for (int i = 0; i < movieCollections.size(); i ++) {
            for (int j = 0; j < movieCollections.get(i).getResults().length; j++) {
                if (count < need) {
                    allTitle += movieCollections.get(i).getResults()[j].getTitle() + "\n";
                    count++;
                }
            }
        }
        return allTitle;
    }

    public String printGenreId(int need, int genreId) throws IOException {

        ArrayList<MovieCollection> movieCollections = new ArrayList<>();

        //assume the user's requirement is hard to meet that among 10 movies, only one satisfies the requirement,
        //so instead of dividing the need by 20(number of movie objects in a page), dividing it by 2
        int pageNum = need/2 + 1;

        //the jsonreader reads the url and gets json object from the webpage until the required number is met,
        //if the pageNum hits 15, call requestLimit() to to see whether need to limit the amount of time requesting the response
        for (int i = 1; i < pageNum + 1; i ++){
            if (i > 15) {
                requestLimit(i);
            }

            URL url = new URL(APIKey.getApiKey() + Integer.toString(i));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            JsonReader reader = new JsonReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            movieCollections.add(gson.fromJson(reader, MovieCollection.class));
        }

        int count = 0;
        String genreIdTitle = "";

        //compare every movie's genre id until find the required number of movies that have the same genre id
        for (int i = 0; i < movieCollections.size(); i ++) {
            for (int j = 0; j < movieCollections.get(i).getResults().length; j++) {
                for ( int k = 0; k < movieCollections.get(i).getResults()[j].getGenreIds().length; k ++) {
                    if ((count < need) && (genreId == movieCollections.get(i).getResults()[j].getGenreIds()[k])) {
                        count++;
                        genreIdTitle += movieCollections.get(i).getResults()[j].getTitle() + "\n";
                    }
                }
            }
        }

        if (count == 0)
            genreIdTitle = "Sorry, no movie matches";

        return genreIdTitle;
    }

    public String printVoteAverage(int need, double voteAverage) throws IOException {

        ArrayList<MovieCollection> movieCollections = new ArrayList<>();

        //assume the user's requirement is hard to meet that among 10 movies, only one satisfies the requirement,
        //so instead of dividing the need by 20(number of movie objects in a page), dividing it by 2
        int pageNum = need/2 + 1;

        //the jsonreader reads the url and gets json object from the webpage until the required number is met,
        //if the pageNum hits 15, call requestLimit() to to see whether need to limit the amount of time requesting the response
        for (int i = 1; i < pageNum + 1; i ++){
            if (i > 15) {
            requestLimit(i);
        }

            URL url = new URL(APIKey.getApiKey() + Integer.toString(i));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            JsonReader reader = new JsonReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            movieCollections.add(gson.fromJson(reader, MovieCollection.class));
        }

        int count = 0;
        String voteAveTitle = "";

        //compare every movie's vote average until find the required number of movies that have higher vote average than the requirement
        for (int i = 0; i < movieCollections.size(); i ++) {
            for (int j = 0; j < movieCollections.get(i).getResults().length; j++) {
                if ((count < need) && (voteAverage < movieCollections.get(i).getResults()[j].getVoteAverage())) {
                        count ++;
                        voteAveTitle += movieCollections.get(i).getResults()[j].getTitle() + "\n";
                }
            }
        }

        if (count == 0)
            voteAveTitle = "Sorry, no movie matches";

        return voteAveTitle;
    }

    public String printPopularity(int need, double popularity) throws IOException {

        ArrayList<MovieCollection> movieCollections = new ArrayList<>();

        //assume the user's requirement is hard to meet that among 10 movies, only one satisfies the requirement,
        //so instead of dividing the need by 20(number of movie objects in a page), dividing it by 2
        int pageNum = need/2 + 1;

        //the jsonreader reads the url and gets json object from the webpage until the required number is met,
        //call requestLimit() to to see whether need to limit the amount of time requesting the response
        for (int i = 1; i < pageNum + 1 ; i ++){
            requestLimit(i);

            URL url = new URL(APIKey.getApiKey() + Integer.toString(i));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            JsonReader reader = new JsonReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            movieCollections.add(gson.fromJson(reader, MovieCollection.class));
        }

        int count = 0;
        String popularityTitle = "";

        //compare every movie's popularity until find the required number of movies that have higher popularity than the requirement
        for (int i = 0; i < movieCollections.size(); i ++) {
            for (int j = 0; j < movieCollections.get(i).getResults().length; j++) {
                if ((count < need) && (popularity < movieCollections.get(i).getResults()[j].getPopularity())) {
                    count ++;
                    popularityTitle += movieCollections.get(i).getResults()[j].getTitle() + "\n";
                }
            }
        }

        if (count == 0)
            popularityTitle = "Sorry, no movie matches";

        return popularityTitle;
    }

    //This method solves the problem of HTTP 429. The code author is Drake Eidukas, the source is piazza post @492.
    public void requestLimit(int pageNum) throws IOException {
        URL site = new URL(APIKey.getApiKey() + Integer.toString(pageNum));
        HttpURLConnection conn = (HttpURLConnection) site.openConnection();
        if (conn.getResponseCode() != 200) {
            //In a more expansive project, error handling would be added in.
            System.out.println("HTTP ERROR CODE: " + conn.getResponseCode());
        }
        if (Integer.parseInt(conn.getHeaderField("X-RateLimit-Remaining")) <= 1) {
            System.out.println("Rate limit reached: waiting 8 seconds.");
            try {
                Thread.sleep(8000);
            } catch (Exception e) {
            }
        }
    }
}
