package com.zybooks.dickman_final_practical;

import android.graphics.drawable.Drawable;

public class Band {
    private int mId;
    private String mName;
    private String mCost;
    private String mDescription;
    private String mTimes;
    private int mImage;
    private static final int[] Icons = {
            R.drawable.fall_out_boy,
            R.drawable.imagine,
            R.drawable.maroon,
            R.drawable.one_republic };
    
public Band() {}

    public Band(int id, String name, String description, String time, int num_image, String cost) {
        mId = id;
        mName = name;
        mDescription = description;
        mTimes = time;
        mImage = Icons[num_image];
        mCost = cost;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getCost() {
        return mCost;
    }

    public void setCost(String cost) {
        this.mCost = cost;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getTimes(){ return mTimes; }

    public String getDate(int begin, int end) {return mTimes.substring(begin, end);}
    
    public int getImage() {return mImage;}

    public void setTimes(String time){ this.mTimes = time; }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
