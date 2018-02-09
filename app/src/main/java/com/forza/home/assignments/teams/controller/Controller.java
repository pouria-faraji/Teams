package com.forza.home.assignments.teams.controller;

import com.forza.home.assignments.teams.model.object.Team;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pouria on 2/9/2018.
 */

public class Controller {
    private Gson gson;

    public Controller() {
        gson = new Gson();
    }
    public List<Team> extractData(String jsonData){
        List<Team> result = new ArrayList<>();
        Team[] teamArray = gson.fromJson(jsonData, Team[].class);
        for(Team team:teamArray){
            result.add(team);
        }
        return result;
    }
    public void saveToDataBase(List<Team> teams){
        for(Team team:teams){
            team.insert();
        }
    }
}
