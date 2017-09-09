package com.jinlin;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

/**
 * Created by Jinlin on 1/28/17.
 * This test use the json object in the webpage to test the behaviour of the methods in the MovieCollection class
 */
public class MovieCollectionTest {

    MovieCollection movieCollection = new MovieCollection();

    //test printAll(), printGenreIds(), printVoteAverage() and printPopularity() methods.
    @Test
    public void printAll() throws Exception {
        assertEquals(movieCollection.printAll(10), "The Secret Life of Pets\n" + "Suicide Squad\n" + "Finding Dory\n" +
                "Arrival\n" + "Jurassic World\n" + "Miss Peregrine's Home for Peculiar Children\n" + "Split\n" +
                "xXx: Return of Xander Cage\n" + "Rings\n" + "La La Land\n");
    }

    @Test
    public void printGenreId() throws Exception {
        assertEquals(movieCollection.printGenreId(20, 28), "Suicide Squad\n" + "Jurassic World\n" +
                "xXx: Return of Xander Cage\n" + "Mad Max: Fury Road\n" + "Captain America: Civil War\n" + "Assassin's Creed\n" +
                "Rogue One: A Star Wars Story\n" + "Inferno\n" + "Underworld: Blood Wars\n" + "Jack Reacher: Never Go Back\n" +
                "Doctor Strange\n" + "Guardians of the Galaxy\n" + "John Wick\n" + "Deadpool\n" + "The Dark Knight\n" +
                "Star Wars: The Force Awakens\n" + "Inception\n" + "Batman v Superman: Dawn of Justice\n" + "Star Wars\n" +
                "Pirates of the Caribbean: The Curse of the Black Pearl\n");
    }

    @Test
    public void printVoteAverage() throws Exception {
        assertEquals(movieCollection.printVoteAverage(25, 5), "The Secret Life of Pets\n" + "Suicide Squad\n" +
                "Finding Dory\n" + "Arrival\n" + "Jurassic World\n" + "Miss Peregrine's Home for Peculiar Children\n" + "Split\n" +
                "xXx: Return of Xander Cage\n" + "Rings\n" + "La La Land\n" + "Interstellar\n" + "Fantastic Beasts and Where to Find Them\n" +
                "Mad Max: Fury Road\n" + "Captain America: Civil War\n" + "Passengers\n" + "Assassin's Creed\n" + "The Girl on the Train\n" +
                "Rogue One: A Star Wars Story\n" + "Inferno\n" + "Hacksaw Ridge\n" + "Doctor Strange\n" + "Guardians of the Galaxy\n" +
                "John Wick\n" + "Deadpool\n" + "The Dark Knight\n");
    }

    @Test
    public void printPopularity() throws Exception {
        assertEquals(movieCollection.printPopularity(15, 10), "The Secret Life of Pets\n" + "Suicide Squad\n" +
                "Finding Dory\n" + "Arrival\n" + "Jurassic World\n" + "Miss Peregrine's Home for Peculiar Children\n" + "Split\n" +
                "xXx: Return of Xander Cage\n" + "Rings\n" + "La La Land\n" + "Interstellar\n" + "Fantastic Beasts and Where to Find Them\n" +
                "Mad Max: Fury Road\n" + "Captain America: Civil War\n" + "Passengers\n");
        assertEquals(movieCollection.printPopularity(5,150), "Sorry, no movie matches");
    }
}