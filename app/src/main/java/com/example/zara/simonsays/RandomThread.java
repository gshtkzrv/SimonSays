package com.example.zara.simonsays;

import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import java.util.Random;

/**
 * Created by ZaRa on 01/01/2016.
 */
public class RandomThread extends Thread
{
    private Button[] allButtons;
    private Animation animation;

    public RandomThread(Button[] allButtons, Animation animation)
    {
        this.allButtons = allButtons;
        this.animation = animation;
    }

    public void run()
    {
        Random buttonNumber = new Random();
        this.allButtons[buttonNumber.nextInt(4)].startAnimation(animation);
    }
}
