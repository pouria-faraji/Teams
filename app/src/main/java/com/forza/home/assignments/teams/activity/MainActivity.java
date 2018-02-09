package com.forza.home.assignments.teams.activity;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.forza.home.assignments.teams.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.forza.home.assignments.teams.adapter.TeamsAdapter;
import com.forza.home.assignments.teams.application.Global;
import com.forza.home.assignments.teams.controller.Controller;
import com.forza.home.assignments.teams.model.object.Team;
import com.forza.home.assignments.teams.task.JsonGetter;
import com.forza.home.assignments.teams.view.InformationDialog;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_layout) RelativeLayout main_layout;
    @BindView(R.id.teams_recycler_view)
    RecyclerView teams_recycler_view;

    private TeamsAdapter teamsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Handler handler = new Handler();
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

//        team = new Team();

        new JsonGetter(this, Global.TEAMS_URL).execute();
//        if(Global.isInternetAvailable()) {
//
//        }else{
//            List<Team> offlineTeams = team.loadAll();
//            if(offlineTeams.size() > 0){
//                this.prepareContent(offlineTeams);
//            }else{
//                InformationDialog dialog = new InformationDialog(this, getResources().getString(R.string.no_internet_msg));
//                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                    @Override
//                    public void onDismiss(DialogInterface dialog) {
//                        finish();
//                    }
//                });
//                dialog.show();
//            }
//        }
    }

    public void prepareContent(List<Team> teams){
        teams_recycler_view.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        teams_recycler_view.setLayoutManager(layoutManager);

        teamsAdapter = new TeamsAdapter(teams);
        teams_recycler_view.setAdapter(teamsAdapter);
    }
}
