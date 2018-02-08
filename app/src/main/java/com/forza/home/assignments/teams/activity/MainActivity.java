package com.forza.home.assignments.teams.activity;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.forza.home.assignments.teams.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.forza.home.assignments.teams.R;
import com.forza.home.assignments.teams.task.JsonGetter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_layout)
    RelativeLayout main_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        new JsonGetter(this).execute();
    }
}
