/*
 * Terry S, 2018, month: 7, date: 8
 */

package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class MasterListFragment extends Fragment {

    OnImageClickListener asdf1;

    public interface OnImageClickListener {
        void onImageSelected(int position);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {

            asdf1 = (OnImageClickListener) context;

        } catch ( ClassCastException e ) {
            throw new ClassCastException( context.toString() +
                    " must implement OnImageClickListener" );
        }
    }

    public MasterListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        MasterListAdapter mAdapter = new MasterListAdapter( getContext(), AndroidImageAssets.getAll() );
        gridView.setAdapter( mAdapter );


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                asdf1.onImageSelected( position );

            }

        });

        return rootView;
    }



} // MasterListFragment
