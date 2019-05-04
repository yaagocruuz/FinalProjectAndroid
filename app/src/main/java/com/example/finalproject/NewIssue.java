package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        EditText nameEdit = findViewById(R.id.txNIssueName);
        EditText userEdit = findViewById(R.id.txIssueUser);
        EditText hoursEdit = findViewById(R.id.txIssueHours);

        Intent intent = getIntent();
        Log.i("BUNDLE",intent.hasExtra("Bundle") +"");
        if(intent.hasExtra("Bundle")) {
            Log.i("BUNDLE","Inside IF");
            Bundle bundle = intent.getBundleExtra("Bundle");
            String bIssueName = bundle.getString("issueName");
            String bIssueAssignee = bundle.getString("issueAssignee");
            Double bIssueHours = bundle.getDouble("issueHours");

            nameEdit.setText(bIssueName);
            userEdit.setText(bIssueAssignee);
            hoursEdit.setText(bIssueHours.toString());
        }

        btNewIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String bIssueID;
                EditText name = findViewById(R.id.txNIssueName);
                EditText user = findViewById(R.id.txIssueUser);
                EditText hours = findViewById(R.id.txIssueHours);
                if(!intent.hasExtra("Bundle")) {
                //if(name.getText().toString().equals("")||user.getText().toString().equals("")||hours.getText().toString().equals(""))
                //{
                    Issue issue = new Issue(name.getText().toString(),user.getText().toString(),Double.parseDouble(hours.getText().toString()));
                    DatabaseReference newIssue = firebaseRef.child("issues").push();
                    newIssue.setValue(issue);
                    name.setText("");
                    user.setText("");
                    hours.setText("");
                    alert("Issue Cadastrada");
                }

                else{
                    Bundle bundle = intent.getBundleExtra("Bundle");
                    bIssueID = bundle.getString("issueID");
                    Issue issue = new Issue(name.getText().toString(),user.getText().toString(),Double.parseDouble(hours.getText().toString()));
                    DatabaseReference newIssue = firebaseRef.child("issues").child(bIssueID);
                    newIssue.setValue(issue);
                    Intent intentResult = new Intent();
                    intentResult.putExtra("nameResult",name.getText().toString());
                    intentResult.putExtra("userResult",user.getText().toString());
                    intentResult.putExtra("hoursResult",hours.getText().toString());
                    setResult(1,intentResult);
                    name.setText("");
                    user.setText("");
                    hours.setText("");
                    alert("Issue Editada com Sucesso");
                    finish();
                }


            }
        });
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();}
}
