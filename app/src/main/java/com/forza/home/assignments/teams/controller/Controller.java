package com.forza.home.assignments.teams.controller;

import com.forza.home.assignments.teams.model.object.Team;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    //This method is used to work with Gson library.
//    public List<Team> extractData(String jsonData){
//        List<Team> result = new ArrayList<>();
//        Team[] teamArray = gson.fromJson(jsonData, Team[].class);
//        for(Team team:teamArray){
//            result.add(team);
//        }
//        return result;
//    }
    public List<Team> extractData(String jsonData){
        List<Team> result = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Team team = new Team(jsonObject.getString("name"),
                        jsonObject.getBoolean("national"),
                        jsonObject.getString("country_name"));

                result.add(team);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void saveToDataBase(List<Team> teams){
        for(Team team:teams){
            team.insert();
        }
    }
}
