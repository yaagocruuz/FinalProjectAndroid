package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.applandeo.materialcalendarview.CalendarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AddNoteActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference firebaseRef = database.getReference();

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_worklog);

        final CalendarView datePicker = findViewById(R.id.datePicker);
        Button button = findViewById(R.id.addNoteButton);
        final EditText noteEditText = findViewById(R.id.noteEditText);

        addItemsOnSpinner();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();

                MyEventDay myEventDay = new MyEventDay(datePicker.getSelectedDate(),
                        R.drawable.sample_circle, noteEditText.getText().toString());

                returnIntent.putExtra(Tab1.RESULT, myEventDay);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    public void addItemsOnSpinner() {
        spinner = findViewById(R.id.spinner);
        final List<String> issueList = new ArrayList<>(); //foi pedido para usar final, nao sei por que...

        //codigo firebase para add as issues

        DatabaseReference issues = firebaseRef.child("issues");
        issues.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ListView listView = findViewById(R.id.myIssues);
                Issue issue;
                String name;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    issue = postSnapshot.getValue(Issue.class);
                    name = issue.getIssueAssignee();
                    if(name.equals("sergio")) {
                        issueList.add(issue.getIssueName());
                    }
                }
                //codigo para colocar as issues dentro do spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(AddNoteActivity.this,
                        android.R.layout.simple_spinner_item, issueList);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
                //fim
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //fim codigo firebase
    }

}
