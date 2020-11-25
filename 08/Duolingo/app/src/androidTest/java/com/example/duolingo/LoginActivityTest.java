package com.example.duolingo;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class LoginActivityTest {

    public ActivityTestRule<LoginActivity> loginActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private Welcome loinActivity = null;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}