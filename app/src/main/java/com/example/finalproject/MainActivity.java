package com.example.finalproject;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference firebaseRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tPassword = (TextView) findViewById(R.id.tPassword);
                String login = tLogin.getText().toString();
                String password = tPassword.getText().toString();
                if(login.equals("yago") && password.equals("123")){
                    alert("Login realizado");
                    setContentView(R.layout.activity_main);
                    createTabs();

                    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent newIssueActivity = new Intent(MainActivity.this, NewIssue.class);
                            startActivity(newIssueActivity);
                        }
                    });
                }else{
                    alert("Login ou senha incorretos");
                }
            }
        });

        Button btNovouser = findViewById(R.id.btNovoUser);
        btNovouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoUserActivity = new Intent(MainActivity.this, NewUser.class);
                startActivity(novoUserActivity);
            }
        });

    }

    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }


    public void createTabs () {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);
        return;
    }

}
