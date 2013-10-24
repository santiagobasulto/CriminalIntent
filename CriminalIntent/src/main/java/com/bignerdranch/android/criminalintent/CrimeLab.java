package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by santiago on 23/10/13.
 */
public class CrimeLab {
    private static CrimeLab instance;

    private ArrayList<Crime> crimesList;
    private Context mAppContext;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        crimesList = new ArrayList<Crime>();

        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0); // every other one
            crimesList.add(c);
        }
    }

    public static CrimeLab getInstance(Context c){
        if(instance == null)
           instance = new CrimeLab(c.getApplicationContext());

        return instance;
    }

    public ArrayList<Crime> getCrimes(){
        return this.crimesList;
    }

    public Crime getCrime(UUID id){
        for(Crime c: crimesList){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
}
