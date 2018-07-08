/*
 * Terry S, 2018, month: 7, date: 8
 */

package com.example.android.android_me.ui;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);


        // head
        BodyPartFragment headFragment = new BodyPartFragment();

        // body
        BodyPartFragment bodyFragment = new BodyPartFragment();

        // feet
        BodyPartFragment legFragment = new BodyPartFragment();

        headFragment.setImageIds( AndroidImageAssets.getHeads() );
        headFragment.setListIndex( 2 );

        bodyFragment.setImageIds( AndroidImageAssets.getBodies() );
        bodyFragment.setListIndex( 2 );

        legFragment.setImageIds( AndroidImageAssets.getLegs() );
        legFragment.setListIndex( 2 );


        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add( R.id.head_container, headFragment )
                .add( R.id.body_container, bodyFragment)
                .add( R.id.leg_container, legFragment )
                .commit();

    } // onCreate()



} // class AndroidMeActivity
