package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by santiago on 22/10/13.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date date;
    private boolean solved = false;

    public Crime(){
        mId = UUID.randomUUID();
        date = new Date();
    }
    public Crime(String title){
        this();
        mTitle = title;
    }

    public boolean isSolved() {
        return solved;
    }

    public Date getDate() {
        return date;
    }

    public UUID getId() {
        return mId;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
