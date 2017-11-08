package com.example.android.miwok;

import android.app.Activity;;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abdulfattah Hamzah on 7/11/2017.
 */

/*
* {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link Word} objects.
* */
public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    private int mColorResourceId;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;

    }



    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Find the Text Linear Layout in the list_item.xml layout with the ID text_layout
        RelativeLayout textLayout = (RelativeLayout) listItemView.findViewById(R.id.text_layout);

        // set this text linear layout background resource to mColorId
        textLayout.setBackgroundResource(mColorResourceId);

        // Get the {@link Word} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the miwok Translation from the current word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the id default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Get the default Translation from the current word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the id image_view
        ImageView imageResource = (ImageView) listItemView.findViewById(R.id.image_view);

        // Check if image resource id exist
        if(currentWord.hasImage()){

            // Get the image Resource id from the current word object and
            //  and set this Resource id on the  imageResource
            imageResource.setImageResource(currentWord.getImageResourceId());

            // Set image resource view to visible
            imageResource.setVisibility(View.VISIBLE);
        }else {

            // else set image resource view to GONE
            imageResource.setVisibility(View.GONE);
        }



        // Return the whole list item layout (containing 1 ImageVies and 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;

    }


}
