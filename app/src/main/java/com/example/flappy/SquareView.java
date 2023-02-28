package com.example.flappy;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

/**
 * This class hold methods that relate to how all squares are viewed on the screen.
 *
 * @author Nicholas Tabra
 */
public class SquareView {
    //instance variables are created for later use.

    public Button[][] buttons;

    public TextView playerWins;

    private SquareModel model;

    private Random rand;

    private Button resetButton;


    /*
    *  SquareView
    *
     * This method is a constructor used to initiate important values such as all squares on the screen.
     *
     * @param m  The model or information passed in.
     *
     */
    public SquareView(SquareModel m)
    {
        //private instance variables initiated with the parameters.
        model = m;
        buttons = new Button[4][4];
    }

    /*
    * addButton
    *
     * This method is one for adding buttons to the screen. It is used 16 times,
     * the extra being an invisible button on the screen used for other
     * squares to move into.
     *
     * @param row  The model or information passed in.
     *
     * @param col  The column of the button passed in.
     *
     * @param b  The button object passed in.
     *
     */
    public void addButton(int row, int col, Button b)
    {
        buttons[row][col] = b;
    }

    /*
    * addResetButton
    *
     * This method is used for adding the reset button to the srceen.
     *
     * @param button  The button object passed in to be set as a reset button.
     *
     */
    public void addResetButton(Button button){
        //reset button initiated to parameter and set to black as background color.
        resetButton = button;
        button.setBackgroundColor(Color.BLACK);
    }

    /*
    * addTextView
    *
     * This method is used for adding a textview to the screen.
     *
     * @param t  The textview passed in to be represented.
     *
     */
    public void addTextView(TextView t) {playerWins = t;}

    /*
    * setText
    *
     * This method used for setting the text on the screen to a message for when the player wins.
     *
     * @param winPlays The winPlays string used to set playerWins to.
     *
     */
    public void setText(String winPlays) {playerWins.setText(winPlays);}

    /*
    * displayButtons
    *
     * This method is used for setting all buttons to visible.
     *
     */
    public void displayButtons(){
        //double for loop used to set all 16 instances of a button to visible.
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                buttons[i][j].setVisibility(View.VISIBLE);

                if(i == 3 && j == 3){
                    //if the last button is at reference, it is set to invisible.
                   buttons[i][j].setVisibility(View.INVISIBLE);
                }
            }
        }
    }


    /*
    * shuffleButtons
    *
     * This method is used for shuffling the buttons on the screen.
     *
     */
    public void shuffleButtons(){
        //ints are created with a random for later use.
        rand = new Random();
        int randIndex1;
        int randIndex2;

        //double for loop used to go through all buttons.
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                //random numbers initiated.
                randIndex1 = rand.nextInt(4);
                randIndex2 = rand.nextInt(4);

                //special case for when both random indexes are equal to the highest value (bottom right corner).
                if(randIndex1 == 3 && randIndex2 == 3){
                    randIndex1 -= rand.nextInt(2) + 1;
                    randIndex2 -= rand.nextInt(2) + 1;
                }

                //string gotten from randomly selected button
                String one = (String) buttons[randIndex1][randIndex2].getText();
                //string gotten from current button in loop
                String two = (String) buttons[i][j].getText();

                if(i != 3 && j != 3){ //if not in bottom right, strings are swapped.
                    //if
                    buttons[randIndex1][randIndex2].setText(two);
                    buttons[i][j].setText(one);
                }
                else if(i == 3 && j == 3){
                    //if at bottom right square, set text to random button
                    buttons[randIndex1][randIndex2].setText(one);
                }


            }
        }
    }


    /*
    * findResult
    *
     * This method is used to see if the user won.
     *
     */
    public boolean findResult() {
        //an array of the winning combination
        String[] winArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};

        //ints created to help keep track of what is happening in the double for loop below.
        int result = 0;
        int increment = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                //if the current setup is equal to the position of a number in winArray, the result int is added to.
                //This leads to a winning array if the combination of buttons is right.
                if(!(i == 3 && j == 3) && buttons[i][j].getText().equals(winArray[increment])){
                    result++;
                }
                increment++;

            }
        }

        if(result == 15){
            return true;
        }
        else{
            return false;
        }
    }

    /*
    * winnerIndication
    *
     * indicates if the player has won on the screen.
     *
     */
    public void winnerIndication(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                //sets the background color to dark gray.
                buttons[i][j].setBackgroundColor(Color.DKGRAY);
            }
        }
    }

    /*
    * buttonDefaultColor
    *
     * sets the default color of the buttons on the screen.
     *
     */
    public void buttonDefaultColor(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                buttons[i][j].setBackgroundColor(Color.GREEN);
                buttons[i][j].setTextColor(Color.BLACK);
            }
        }
    }

    /*
    * setListener
    *
     * This method sets onClickListeners for all buttons, including the reset button.
     *
     */
    public void setListener(View.OnClickListener ocl)
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                // all buttons have an onclicklistener assigned.
                buttons[i][j].setOnClickListener(ocl);
            }
        }
        //onclicklistener set on reset button.
        resetButton.setOnClickListener(ocl);
    }


}
