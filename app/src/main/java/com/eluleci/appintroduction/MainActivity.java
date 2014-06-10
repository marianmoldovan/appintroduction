package com.eluleci.appintroduction;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.eluleci.appintroduction.listeners.StepActionListener;


public class MainActivity extends Activity {

    private AppIntroduction appIntroduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        appIntroduction.reset();
    }

    @Override
    protected void onResume() {
        super.onResume();
        appIntroduction = new AppIntroduction(this);
        appIntroduction.rememberPast(true);
        appIntroduction.addStep(new Step(R.id.textView, "Hi, this is a sample for App Introduction library\n\nOriginaly created by github:eluleci", AppIntroduction.SIDE_NONE));
        appIntroduction.addStep(new Step(R.id.textView, "This is Vertical", AppIntroduction.SIDE_VERTICAL));
        appIntroduction.addStep(new Step(R.id.textView, "This is Horizontal", AppIntroduction.SIDE_HORIZONTAL));
        appIntroduction.start();
    }
}