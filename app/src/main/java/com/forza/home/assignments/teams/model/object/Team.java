package com.forza.home.assignments.teams.model.object;

import com.forza.home.assignments.teams.application.App;
import com.forza.home.assignments.teams.application.Global;
import com.forza.home.assignments.teams.model.DB.TeamDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.faraji on 2/8/2018.
 */

public class Team {
    public Team() {
    }

    public Team(String name, Boolean national, String country_name) {
        this.name = name;
        this.national = national;
        this.country_name = country_name;
    }

    private String name;
    private Boolean national;
    private String country_name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNational() {
        return national;
    }

    public void setNational(Boolean national) {
        this.national = national;
    }

    public String getCountryName() {
        return country_name;
    }

    public void setCountryName(String countryName) {
        this.country_name = countryName;
    }

    public void insert(){
        TeamDB teamDB = new TeamDB();
        teamDB.setCountryName(this.getCountryName());
        teamDB.setName(this.getName());
        teamDB.setNational(this.getNational());

        App.getDaoSession().getTeamDBDao().insert(teamDB);
    }
    public List<Team> loadAll(){
        List<Team> result = new ArrayList<>();
        List<TeamDB> teamDBList = App.getDaoSession().getTeamDBDao().loadAll();
        for(TeamDB temp:teamDBList){
            Team team = new Team(temp.getName(),temp.getNational(), temp.getCountryName());
            result.add(team);
        }
        return result;
    }

    @Override
    public String toString() {
        return this.getName()+","+this.getCountryName()+","+(this.getNational()?"National":"Club");
    }

    public Boolean equals(Team team){
        if(this.getName().equals(team.getName()) &&
                this.getNational() == team.getNational()&&
                this.getCountryName().equals(team.country_name)){
            return true;
        }else{
            return false;
        }
    }
}
