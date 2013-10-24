package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by santiago on 23/10/13.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
