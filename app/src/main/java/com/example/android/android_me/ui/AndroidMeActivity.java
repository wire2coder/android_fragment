/*
 * Terry S, 2018, month: 7, date: 8
 */

package com.example.android.android_me.ui;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.LogUtil;
import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);



        // only create new fragment and stuff if you don't have anything saved in the 'Bundle'
        // you can't access Fragment's data inside fragment's 'bundle'
        if (savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            // head
            BodyPartFragment headFragment = new BodyPartFragment();

            headFragment.setImageIds( AndroidImageAssets.getHeads() );
            headFragment.setListIndex( 1 );

            fragmentManager.beginTransaction()
                    .add( R.id.head_container, headFragment )
                    .commit();

            // body
            BodyPartFragment bodyFragment = new BodyPartFragment();

            bodyFragment.setImageIds( AndroidImageAssets.getBodies() );
            bodyFragment.setListIndex( 1 );

            fragmentManager.beginTransaction()
                    .add( R.id.body_container, bodyFragment )
                    .commit();

            // feet
            BodyPartFragment legFragment = new BodyPartFragment();

            legFragment.setImageIds( AndroidImageAssets.getLegs() );
            legFragment.setListIndex( 1 );

            fragmentManager.beginTransaction()
                    .add( R.id.leg_container, legFragment )
                    .commit();

        } // if


    } // onCreate()



} // class AndroidMeActivity
