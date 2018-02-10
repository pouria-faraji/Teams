package com.forza.home.assignments.teams;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.forza.home.assignments.teams.application.App;
import com.forza.home.assignments.teams.application.Global;
import com.forza.home.assignments.teams.controller.Controller;
import com.forza.home.assignments.teams.model.object.Team;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public static final String  ASSET_BASE_PATH = "../app/src/main/assets/";
    public Controller controller;
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.forza.home.assignments.teams", appContext.getPackageName());

        controller = new Controller();
        Team team1 = new Team("Arsenal FC", false, "England");
        Team team2 = new Team("FC Barcelona", false, "Spain");
        Team team3 = new Team("Sweden", true, "Sweden");
        Team team4 = new Team("Inter Milan", false, "Italy");
        List<Team> expectedList = new ArrayList<>(Arrays.asList(team1, team2, team3, team4));
        List<Team> actualList = controller.extractData(readJsonFile("teams.json"));

        //Check actual vs expected list size
        assertEquals(expectedList.size(), actualList.size());

        //Check equality of each elements of both actual and expected list
        for(int i=0;i<expectedList.size();i++){
            assertTrue(expectedList.get(i).equals(actualList.get(i)));
            assertEquals(expectedList.get(i).getName(), actualList.get(i).getName());
            assertEquals(expectedList.get(i).getCountryName(), actualList.get(i).getCountryName());
            assertEquals(expectedList.get(i).getNational(), actualList.get(i).getNational());
        }
    }

    public String readJsonFile (String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(App.getAppContext().getAssets().open(filename)));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }
        return sb.toString();
    }
}
