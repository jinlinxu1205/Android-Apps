package com.jinlin;

/**
 * Created by Jinlin on 2/4/17.
 * This class contains the web address of the json movie database.
 */
public class APIKey {
    private static String APIKEY = "https://api.themoviedb.org/3/movie/popular?api_key=e1e813f739e7685305015aeddc11f123&page=";

    public static String getApiKey() {
        return APIKEY;
    }

}
