package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    //declaring widgets
    private Button changeTextColorButton;
    private TextView mainLabel;
    private EditText mainGetter;
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wiring widgets
        changeTextColorButton=findViewById(R.id.buttonChangeColor);
        mainLabel=findViewById(R.id.labelDisplay);
        mainGetter=findViewById(R.id.editTextEntry);
        constraintLayout = findViewById(R.id.layout);


        //setting the gradient background
            AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
            animationDrawable.setExitFadeDuration(3000);
            animationDrawable.setEnterFadeDuration(2000);
            animationDrawable.start();

    }


    //function that is called when a button is clicked
    public void onButtonClick(View view) {

        //randomly changes text color when the change Text color button is pressed
        if (view.getId() == R.id.buttonChangeColor) {
            int red = (int) (1+ Math.random()*255);
            int blue = (int) (1+ Math.random()*255);
            int green = (int) (1+ Math.random()*255);
            int randColor = Color.argb(255,red,green,blue);
            mainLabel.setTextColor(randColor);
        }

        //randomly changes the background color of the app when change background color is pressed
        if(view.getId()==R.id.buttonChangeBackground){
            int red = (int) (1+ Math.random()*255);
            int blue = (int) (1+ Math.random()*255);
            int green = (int) (1+ Math.random()*255);
            int randColor = Color.argb(255,red,green,blue);
            constraintLayout.setBackgroundColor(randColor);
        }

        //changes text when change string button is pressed
        if(view.getId()==R.id.buttonChangeText){
            //if EditText is empty
            if(mainGetter.getText().toString().isEmpty()) {
                String def = "Hello From Jonathan";
                mainLabel.setText(def);
            }
            //changes TextView to the text in EditText
            else{
                String textText = mainGetter.getText().toString();
                mainLabel.setText(textText);
                mainGetter.getText().clear();
            }

        }
        //checks to see if background is tapped to change everything to default settings
        if(view.getId()==R.id.layout){
            String def = "Hello From Jonathan";
            mainLabel.setText(def);
            mainLabel.setTextColor(Color.parseColor("#000000"));
            constraintLayout = findViewById(R.id.layout);
            constraintLayout.setBackgroundResource(R.drawable.gradient_list);
            AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
            animationDrawable.setExitFadeDuration(3000);
            animationDrawable.setEnterFadeDuration(2000);
            animationDrawable.start();
        }
    }




}
