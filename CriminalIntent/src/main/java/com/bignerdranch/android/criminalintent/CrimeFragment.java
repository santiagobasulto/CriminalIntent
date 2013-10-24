package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by santiago on 22/10/13.
 */
public class CrimeFragment extends Fragment {

    private static final String LOG_TAG = "LoggingCriminalIntent";

    private Crime mCrime;

    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
        Log.d(LOG_TAG, "Fragment onCreate called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText) v.findViewById(R.id.crime_title);

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        DateFormat df = new SimpleDateFormat("E, MMM d, y");
        mDateButton.setText(df.format(mCrime.getDate()));
        mDateButton.setEnabled(false);

        mSolvedCheckbox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                // blank
                Log.d(LOG_TAG, "beforeTextChanged called");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                mCrime.setTitle(charSequence.toString());
                Log.d(LOG_TAG, "onTextChanged called with text: " + charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(LOG_TAG, "afterTextChanged called");
            }
        });
        return v;
    }
}
