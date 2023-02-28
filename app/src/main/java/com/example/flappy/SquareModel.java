package com.example.flappy;

import java.util.Random;

/**
 * This class hold methods that relate to information stored on all squares on the screen.
 *
 * @author Nicholas Tabra
 */
public class SquareModel {

    //instance variables created for later use.
    private int row;
    private int col;

    private Random rng;

    private int firstNum;

    private String playerWins;

    /*
    * SquareModel
    *
     * This method is a constructor used to initiate important values such as randoms and winning text.
     *
     */
    public SquareModel()
    {
        rng = new Random();
        firstNum = 0;
        playerWins = "YOU WON";
    }

    /*
    * getPlayerWins
    *
    * This method is used to get the player wins string.
    *
     */
    public String getPlayerWins(){
        return playerWins;
    }


}
