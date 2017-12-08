package com.example.mindmie.androiddemo;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Mindmie on 8/12/2560.
 */
@IgnoreExtraProperties
public class User {

    public String userEmail;
    public String userPwad;
    public String userBirthday;
    public String usergender;
    public String userWeight;
    public String userHeight;
    public String userActivityLevel;
    public String userYourGoal;
    public String userWeightLose;



    //Constructor


    public User(String userEmail, String userPwad, String userBirthday, String usergender, String userWeight, String userHeight, String userActivityLevel, String userYourGoal, String userWeightLose) {
        this.userEmail = userEmail;
        this.userPwad = userPwad;
        this.userBirthday = userBirthday;
        this.usergender = usergender;
        this.userWeight = userWeight;
        this.userHeight = userHeight;
        this.userActivityLevel = userActivityLevel;
        this.userYourGoal = userYourGoal;
        this.userWeightLose = userWeightLose;
    }

}


