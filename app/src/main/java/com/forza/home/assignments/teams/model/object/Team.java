package com.forza.home.assignments.teams.model.object;

import com.forza.home.assignments.teams.model.DB.TeamDB;

/**
 * Created by p.faraji on 2/8/2018.
 */

public class Team {
    public Team() {
    }

    private String name;
    private Boolean national;
    private String countryName;

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
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void insert(){
        TeamDB teamDB = new TeamDB();
        teamDB.setCountryName(this.getCountryName());
        teamDB.setName(this.getName());
        teamDB.setNational(this.getNational());
    }
}
