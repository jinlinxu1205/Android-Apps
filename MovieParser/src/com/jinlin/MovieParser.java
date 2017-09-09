package com.jinlin;

import java.util.ArrayList;
import java.io.*;

/**
 * Created by Jinlin on 1/28/17.
 * This program uses movie data collected from https://www.themoviedb.org. It parses movie JSON data and prints out movie titles
 * that match specified criteria, like genre id, vote average and popularity.
 * It helps users quickly find the movie they want from the database.
 */

public class MovieParser {

    public static void main(String[] args) throws IOException {

        ArrayList<String> request = new ArrayList<>();
        for (int i = 0; i < args.length; i++)
            request.add(args[i]);

        boolean checkFirstInput = (Integer.parseInt(request.get(0)) > 0) && (Integer.parseInt(request.get(0)) < 19511);
        boolean checkSecondInput = request.get(1).equals("printAll") || request.get(1).equals("genreId") || request.get(1).equals("voteAverage") || request.get(1).equals("popularity");
        boolean checkThirdInput = (Double.parseDouble(request.get(2)) > 0);

        if (args.length != 3 || !checkFirstInput || !checkSecondInput || !checkThirdInput) {
            System.out.println("Please enter the number of movies, query type and query parameter in the command line");
            return;
        }

        MovieCollection movieCollection = new MovieCollection();

        //According to user's input, print the movie title. For query types like genreId, voteAverage, and popularity,
        switch(request.get(1)){
            case "printAll":
                System.out.println(movieCollection.printAll(Integer.parseInt(request.get(0))));
                break;
            case "genreId":
                System.out.println(movieCollection.printGenreId(Integer.parseInt(request.get(0)), Integer.parseInt(request.get(2))));
                break;
            case "voteAverage":
                System.out.println(movieCollection.printVoteAverage(Integer.parseInt(request.get(0)), Double.parseDouble(request.get(2))));
                break;
            case "popularity":
                System.out.println(movieCollection.printPopularity(Integer.parseInt(request.get(0)), Double.parseDouble(request.get(2))));
                break;
        }
    }
}
