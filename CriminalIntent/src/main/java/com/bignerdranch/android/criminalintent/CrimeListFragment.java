package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by santiago on 23/10/13.
 */
public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);

        mCrimes = CrimeLab.getInstance(getActivity()).getCrimes();

        Log.d("CRIMES", "Setting up adapter. First crime: " + mCrimes.get(0).toString());
        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = (Crime) getListAdapter().getItem(position);
        Log.d("DEBUG-FRAGMENT", "Clicked crime: "+ c);
    }
}
