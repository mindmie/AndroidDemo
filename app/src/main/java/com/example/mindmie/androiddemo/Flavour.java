package com.example.mindmie.androiddemo;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Mindmie on 8/12/2560.
 */
@IgnoreExtraProperties
public class Flavour {
    public String firstFlavour;
    public String secondFlavour;
    public String thirdFlavour;

    public Flavour(String firstMeat, String secondMeat, String thirdMeat) {
        this.firstFlavour = firstFlavour;
        this.secondFlavour = secondFlavour;
        this.thirdFlavour = thirdFlavour;
    }
}
