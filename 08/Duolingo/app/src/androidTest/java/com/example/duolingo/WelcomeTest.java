package com.example.duolingo;

import android.widget.ImageView;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class WelcomeTest {
    @Rule
    public ActivityTestRule<Welcome> welcomeTestRule = new ActivityTestRule<Welcome>(Welcome.class);
    private Welcome wActivity = null;



    @Before
    public void setUp() throws Exception {

        wActivity = welcomeTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        ImageView imgV = wActivity.findViewById(R.id.linhvat);
        assertNotNull(imgV);
    }

    @After
    public void tearDown() throws Exception {
        wActivity = null;
    }
}