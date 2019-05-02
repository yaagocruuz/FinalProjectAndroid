package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewIssue extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference firebaseRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_issue);

        Button btNewIssue = findViewById(R.id.btNIssue);
        btNewIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.txNIssueName);
                EditText user = findViewById(R.id.txIssueUser);
                EditText hours = findViewById(R.id.txIssueHours);
                Issue issue = new Issue(name.getText().toString(),user.getText().toString(),Double.parseDouble(hours.getText().toString()));
                DatabaseReference newIssue = firebaseRef.child("issues").push();
                newIssue.setValue(issue);
                name.setText("");
                user.setText("");
                hours.setText("");
                alert("Issue Cadastrada");


            }
        });
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();}
}
