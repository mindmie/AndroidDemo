package com.example.mindmie.androiddemo;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Mindmie on 8/12/2560.
 */
@IgnoreExtraProperties

public class Meat {
    public String firstMeat;
    public String secondMeat;
    public String thirdMeat;

    public Meat(String firstMeat, String secondMeat, String thirdMeat) {
        this.firstMeat = firstMeat;
        this.secondMeat = secondMeat;
        this.thirdMeat = thirdMeat;
    }


}
