package com.forza.home.assignments.teams.task;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.forza.home.assignments.teams.view.ProgressDialog;

/**
 * Created by p.faraji on 2/8/2018.
 */

public class JsonGetter extends AsyncTask<Void, Void, Void> {
    private Context _context;
    private ProgressDialog progressDialog;
    public JsonGetter(Context context) {
        this._context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(_context, "Retrieving Data. Please wait...");
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
