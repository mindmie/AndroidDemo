package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;
import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {


    //private ValueEventListener mPostListener;




    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();
   // DatabaseReference mPostRef;

    // user key
    //Bundle bundle = getIntent().getExtras();
   // String text = bundle.getString("key");
//     Intent intent = getIntent();
  //  String mPostKey = intent.getStringExtra("email");

        String text = "-L-mjlvjpKTG6hlG3EWJ";

//    private static  final String EXTRA_POST_KEY = "post_key";
//    private String mPostKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        mPostKey = getIntent().getStringExtra(EXTRA_POST_KEY);
//        if (mPostKey == null){
//            throw new IllegalArgumentException("Must pass EXTRA_POST_KEY");
//
//        }
//        mPostRef = FirebaseDatabase.getInstance().getReference()
//                .child("username").child(mPostKey);
//        Toast.makeText(ProfileActivity.this, mPostKey, Toast.LENGTH_SHORT).show();

        displayView();


    }

    private void displayView() {
        final TextView displayGoal = (TextView) findViewById(R.id.tv_your_goal);
        final TextView displayGoalUnit = (TextView) findViewById(R.id.tv_your_goal_unit);
        final TextView displayWeight = (TextView) findViewById(R.id.tv_weight);
        final TextView displayHeight = (TextView) findViewById(R.id.tv_height);
        final TextView displayActivityLevel = (TextView) findViewById(R.id.tv_activity_level);

        final TextView display1stMeat = (TextView) findViewById(R.id.tv_first_meat);
        final TextView display2ndMeat = (TextView) findViewById(R.id.tv_second_meat);
        final TextView display3rdMeat = (TextView) findViewById(R.id.tv_third_meat);

        final TextView display1stFlavour = (TextView) findViewById(R.id.tv_first_flavour);
        final TextView display2ndFlavour = (TextView) findViewById(R.id.tv_second_flavour);
        final TextView display3rdFlavour = (TextView) findViewById(R.id.tv_third_flavour);

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String strGoal = dataSnapshot.child("username").child(text).child("YourGoal").getValue().toString();
                displayGoal.setText(strGoal);

                String strGoalUnit = dataSnapshot.child("username").child(text).child("WeightLose").getValue().toString();
                if ( strGoalUnit.toString().length() == 3){
                    displayGoalUnit.setText("kg");
                }
                else {
                    displayGoalUnit.setText("days");
                }
                String strWeight = dataSnapshot.child("username").child(text).child("Weight").getValue().toString();
                displayWeight.setText(strWeight);

                String strHeight = dataSnapshot.child("username").child(text).child("Height").getValue().toString();
                displayHeight.setText(strHeight);

                String strActivityLevel = dataSnapshot.child("username").child(text).child("ActivityLevel").getValue().toString();
                displayActivityLevel.setText(strActivityLevel);

                //display meat

                String str1Meat = dataSnapshot.child("username").child(text).child("Meat").child("1st").getValue().toString();
                display1stMeat.setText(str1Meat);

                String str2Meat = dataSnapshot.child("username").child(text).child("Meat").child("2nd").getValue().toString();
                display2ndMeat.setText(str2Meat);

                String str3Meat = dataSnapshot.child("username").child(text).child("Meat").child("3rd").getValue().toString();
                display3rdMeat.setText(str3Meat);


                //display flavour

                String str1Flavour = dataSnapshot.child("username").child(text).child("Flavour").child("1st").getValue().toString();
                display1stFlavour.setText(str1Flavour);

                String str2Flavour = dataSnapshot.child("username").child(text).child("Flavour").child("2nd").getValue().toString();
                display2ndFlavour.setText(str2Flavour);

                String str3Flavour = dataSnapshot.child("username").child(text).child("Flavour").child("3rd").getValue().toString();
                display3rdFlavour.setText(str3Flavour);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

//
//    @Override
//    public  void onStart(){
//        super.onStart();
//
//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                User post = dataSnapshot.getValue(User.class);
//                Meat meat = dataSnapshot.getValue(Meat.class);
//                Flavour flavour = dataSnapshot.getValue(Flavour.class);
//
//                displayGoal.setText(post.userYourGoal);
//
//                if (post.toString().length() == 3){
//                    displayGoalUnit.setText("kg");
//                }
//                else{
//                    displayGoalUnit.setText("days");
//                }
//
//                displayWeight.setText(post.userWeight);
//                displayHeight.setText(post.userHeight);
//                displayActivityLevel.setText(post.userActivityLevel);
//
//                display1stMeat.setText(meat.firstMeat);
//                display2ndMeat.setText(meat.secondMeat);
//                display3rdMeat.setText(meat.thirdMeat);
//
//                display1stFlavour.setText(flavour.firstFlavour);
//                display2ndFlavour.setText(flavour.secondFlavour);
//                display3rdFlavour.setText(flavour.thirdFlavour);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.w("ProfileActivity","loadPost:onCancleld", databaseError.toException());
//                Toast.makeText(ProfileActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        mPostRef.addValueEventListener(postListener);
//        //end of post values event listener
//        mPostListener = postListener;
//    }
//
//
//    @Override
//    public void onStop(){
//        super.onStop();
//
//        if (mPostListener!= null){
//            mPostRef.removeEventListener(mPostListener);
//        }
//
//    }






}












