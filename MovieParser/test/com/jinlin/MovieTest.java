package com.jinlin;

import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Created by Jinlin on 1/31/17.
 * This test uses an example movie json object to test the behaviour of the methods in the Movie class.
 */
public class MovieTest {

    //create an example movie gson object by passing a json string
    public static final String exampleMovie = "{\n" +
            "\"poster_path\": \"\\/WLQN5aiQG8wc9SeKwixW7pAR8K.jpg\", \n" +
            "\"adult\": false, \n" +
            "\"overview\": \"The quiet life of a terrier named Max is upended when his owner takes in Duke, a stray whom Max instantly dislikes.\", \n" +
            "\"release_date\": \"2016-06-18\", \n" +
            "\"genre_ids\": [12, 16, 35, 10751], \n" +
            "\"id\": 328111, \n" +
            "\"original_title\": \"The Secret Life of Pets\", \n" +
            "\"original_language\": \"en\", \n" +
            "\"title\": \"The Secret Life of Pets\", \n" +
            "\"backdrop_path\": \"\\/lubzBMQLLmG88CLQ4F3TxZr2Q7N.jpg\", \n" +
            "\"popularity\": 271.747181, \n" +
            "\"vote_count\": 1960, \n" +
            "\"video\": false, \n" +
            "\"vote_average\": 5.8\n" +
            "}";

    Gson gson = new Gson();
    Movie movie;

    @Before
    public void getMovie(){
        movie = gson.fromJson(exampleMovie, Movie.class);
    }

    //test every method in the Movie class
    @Test
    public void isAdult() throws Exception {
        assertEquals(movie.isAdult(), false);
    }

    @Test
    public void getOverview() throws Exception {
        assertEquals(movie.getOverview(), "The quiet life of a terrier named Max is upended when his owner takes in Duke, a stray whom Max instantly dislikes.");
    }

    @Test
    public void getRelease_date() throws Exception {
        assertEquals(movie.getReleaseDate(), "2016-06-18");
    }

    @Test
    public void getGenre_ids() throws Exception {
        assertArrayEquals(movie.getGenreIds(), new int[]{12, 16, 35, 10751});
    }

    @Test
    public void getOriginal_title() throws Exception {
        assertEquals(movie.getOriginalTitle(), "The Secret Life of Pets");
    }

    @Test
    public void getOriginal_language() throws Exception {
        assertEquals(movie.getOriginalLanguage(), "en");
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals(movie.getTitle(), "The Secret Life of Pets");
    }

    @Test
    public void getPopularity() throws Exception {
        Assert.assertEquals(movie.getPopularity(), 271.747181, 0);
    }

    @Test
    public void getVote_count() throws Exception {
        assertEquals(movie.getVoteCount(), 1960);
    }

    @Test
    public void isVideo() throws Exception {
        assertEquals(movie.isVideo(), false);
    }

    @Test
    public void getVote_average() throws Exception {
        assertEquals(movie.getVoteAverage(), 5.8, 0);
    }
}