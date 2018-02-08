package com.forza.home.assignments.teams.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by pouria on 1/12/2017.
 */
public class MuseoTextView extends TextView {

    public MuseoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Museo Sans W01 Rounded 300.ttf"));
    }

    public MuseoTextView(Context context) {
        super(context);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Museo Sans W01 Rounded 300.ttf"));
    }
}