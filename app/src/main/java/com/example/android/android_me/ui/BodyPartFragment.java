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

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class BodyPartFragment extends Fragment {

    private static final String TAG = BodyPartFragment.class.getSimpleName();

    private List<Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the fragment
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to the ImageView
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        // Set the image resource to display
//        imageView.setImageResource(AndroidImageAssets.getHeads(). get(1) );

        // mImageIds is not empty
        if ( mImageIds != null ) {

            imageView.setImageResource( mImageIds.get(mListIndex) );

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


} // class BodyPartFragment
