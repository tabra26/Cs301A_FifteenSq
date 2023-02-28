package com.example.flappy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class controls the main actions of the program.
 * Many methods are exectued to make a sufficient program.
 *
 * @author Nicholas Tabra
 */
    public class MainActivity extends AppCompatActivity {

        @Override

        /*
        * onCreate
        *
        *This is the only method in this class. Oncreate is used to exectute the commands.
        *
        * @param savedInstanceState The current state of the program.
        *
         */
        protected void onCreate(Bundle savedInstanceState) {
            //view is set to the main activity.
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //model and view objects created.
            SquareModel model = new SquareModel();
            SquareView view = new SquareView(model);

            //all buttons in the 15 square puzzle game are initiated here manually.
            view.addButton(0,0, findViewById(R.id.b_11));
            view.addButton(0,1, findViewById(R.id.b_12));
            view.addButton(0,2, findViewById(R.id.b_13));
            view.addButton(0,3, findViewById(R.id.b_14));
            view.addButton(1,0, findViewById(R.id.b_21));
            view.addButton(1,1, findViewById(R.id.b_22));
            view.addButton(1,2, findViewById(R.id.b_23));
            view.addButton(1,3, findViewById(R.id.b_24));
            view.addButton(2,0, findViewById(R.id.b_31));
            view.addButton(2,1, findViewById(R.id.b_32));
            view.addButton(2,2, findViewById(R.id.b_33));
            view.addButton(2,3, findViewById(R.id.b_34));
            view.addButton(3,0, findViewById(R.id.b_41));
            view.addButton(3,1, findViewById(R.id.b_42));
            view.addButton(3,2, findViewById(R.id.b_43));
            view.addButton(3,3, findViewById(R.id.b_44));

            //reset and winning views are created
            view.addResetButton(findViewById(R.id.b__reset));
            view.addTextView(findViewById(R.id.textView));

            //square colors changed to default
            view.buttonDefaultColor();

            //buttons set up. All set visible and shuffled.
            view.displayButtons();
            view.shuffleButtons();


            //listener is created on a controller object.
            SquareController controller = new SquareController(model, view);
            view.setListener(controller);

            //text is shown when the player wins.
            view.setText(model.getPlayerWins());
        }
    }
