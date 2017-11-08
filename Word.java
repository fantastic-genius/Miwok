package com.example.android.miwok;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Abdulfattah Hamzah on 7/8/2017.
 */

public class Word {
    /** Default Translation for the word */
    private String mDefaultTranslation;

    /** Miwok Translation for the word */
    private String mMiwokTranslation;

    /** Image Resource Id  */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** has no image used to test for image presence in word constructor */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio Resource Id  */
    private int mAudioResourceId = NO_AUDIO_PROVIDED;

    /** has no audio used to test for audio presence in word constructor */
    private static final int NO_AUDIO_PROVIDED = -1;

    /**
     * Create new word object
     * @param defaultTranslation is the word in the language that the user knows
     *                                      (such as English)
     * @param miwokTranslation is thw word in the miwok language
     *
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }




    /**
     * Create new word object
     * @param defaultTranslation is the word in the language that the user is familiar with
     *                                      (such as English)
     * @param miwokTranslation is thw word in the miwok language
     *
     * @param imageResourceId is the image Resource Id of the image associated with the word
     *
     * @param audioResourceId is the Resource ID of the Audio associated with the word
     */

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }



    /** Get the default translation of the word */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }


    /** Get the miwok translation of the word */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /** Get the Image  Resource Id */
    public int getImageResourceId(){ return mImageResourceId;}


    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED ;
    }

    /** Get the Audio  Resource Id */
    public int getAudioResourceId() { return  mAudioResourceId; }

}


