package com.forza.home.assignments.teams.model.DB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by p.faraji on 2/8/2018.
 */
@Entity(nameInDb = "team")
public class TeamDB {
    @Id
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "national")
    private Boolean national;

    @Property(nameInDb = "country_name")
    private String countryName;

    @Generated(hash = 1054785713)
    public TeamDB(Long id, String name, Boolean national, String countryName) {
        this.id = id;
        this.name = name;
        this.national = national;
        this.countryName = countryName;
    }

    @Generated(hash = 61943165)
    public TeamDB() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNational() {
        return this.national;
    }

    public void setNational(Boolean national) {
        this.national = national;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
