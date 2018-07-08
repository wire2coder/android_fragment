/*
 * Terry S, 2018, month: 7, date: 8
 */

package com.example.android.android_me.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private static final String TAG = BodyPartFragment.class.getSimpleName();

    private List<Integer> mImageIds; // list of either, heads, bodies, or legs
    private int mListIndex;

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


    // Fragment should have a default constructor with no arguments
    public BodyPartFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null ) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }


        // Inflate the fragment
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to the ImageView
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);


        // mImageIds is not empty
        if ( mImageIds != null ) {

            imageView.setImageResource( mImageIds.get(mListIndex) );

            // add a click listener to the ImageView
            imageView.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if ( mListIndex < mImageIds.size()-1) {
                        mListIndex++; // increment the index to show the next image
                    } else {
                        mListIndex = 0; // reset the index
                    }

                    // Set the image resource to display
                    imageView.setImageResource( mImageIds.get(mListIndex) );

                } // onClick()

            } ); // new View.OnClickListener()




        } else {

            Log.v(TAG, "This fragment has a null list of image id's");

        }

        return rootView;
    } // onCreateView()


    /*
    * Setters
    * */

    public void setImageIds( List<Integer> ImageIds ) {
        this.mImageIds = ImageIds;
    }

    public void setListIndex( int ListIndex ) {
        this.mListIndex = ListIndex;
    }


    @Override
    public void onSaveInstanceState(Bundle currentState) {
//        super.onSaveInstanceState(currentState);

        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds );
        currentState.putInt(LIST_INDEX, mListIndex);
    }


} // class BodyPartFragment
