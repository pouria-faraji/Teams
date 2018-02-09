package com.forza.home.assignments.teams.task;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.forza.home.assignments.teams.R;
import com.forza.home.assignments.teams.activity.MainActivity;
import com.forza.home.assignments.teams.application.Global;
import com.forza.home.assignments.teams.controller.Controller;
import com.forza.home.assignments.teams.model.object.Team;
import com.forza.home.assignments.teams.view.InformationDialog;
import com.forza.home.assignments.teams.view.ProgressDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by p.faraji on 2/8/2018.
 */

public class JsonGetter extends AsyncTask<Void, Void, List<Team>> {
    private Context _context;
    private ProgressDialog progressDialog;
    private InformationDialog informationDialog;
    OkHttpClient client;
    Request request;
    Response response;
    Boolean exception = false;
    Controller controller;
    List<Team> teams;
    Team team;
    public JsonGetter(Context context, String URL) {
        this._context = context;
        controller = new Controller();
        team = new Team();
        teams = new ArrayList<>();
        client = new OkHttpClient();
        request = new Request.Builder()
                .url(URL)
                .build();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(_context, "Retrieving Data. Please wait...");
        progressDialog.show();
    }

    @Override
    protected List<Team> doInBackground(Void... voids) {
        String jsonData = "";
        try {
            teams = team.loadAll();
            if(Global.isInternetAvailable()) {
                response = client.newCall(request).execute();
                jsonData = response.body().string();
                teams = controller.extractData(jsonData);
                if(team.loadAll().size() == 0) {
                    controller.saveToDataBase(teams);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            exception = true;
        }
        return teams;
    }

    @Override
    protected void onPostExecute(List<Team> result) {
        super.onPostExecute(result);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if(exception || (teams.size()==0)){
            informationDialog = new InformationDialog(_context, _context.getResources().getString(R.string.problem));
            informationDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ((MainActivity)_context).finish();
                }
            });
            informationDialog.show();
        }else{
            ((MainActivity)_context).prepareContent(teams);
        }
    }
}