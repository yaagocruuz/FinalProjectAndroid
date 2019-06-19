package com.example.finalproject;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IssueView extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference firebaseRef = database.getReference();

    TextView nameEdit;
    TextView userEdit;
    TextView hoursEdit;
    String issueID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_view);

        nameEdit = findViewById(R.id.tvEditName);
        userEdit = findViewById(R.id.tvEditAssignee);
        hoursEdit = findViewById(R.id.tvEditHours);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        String bIssueName = bundle.getString("issueName");
        String bIssueAssignee = bundle.getString("issueAssignee");
        Double bIssueHours = bundle.getDouble("issueHours");
        issueID = bundle.getString("issueID");


        nameEdit.setText(bIssueName);
        userEdit.setText(bIssueAssignee);
        hoursEdit.setText(bIssueHours.toString());

        Button btEdit = findViewById(R.id.btEditIssue);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IssueView.this,NewIssue.class);
                Bundle bundle = new Bundle();
                bundle.putString("issueName", nameEdit.getText().toString());
                bundle.putString("issueAssignee", userEdit.getText().toString());
                bundle.putDouble("issueHours", Double.parseDouble(hoursEdit.getText().toString()));
                bundle.putString("issueID", issueID);
                intent.putExtra("Bundle",bundle);
                startActivityForResult(intent,1);
                //finish();
            }
        });

        Button btDelete = findViewById(R.id.btDeleteIssue);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseRef.child("issues").child(issueID).removeValue();
                nameEdit.setText("");
                userEdit.setText("");
                hoursEdit.setText("");
                alert("Issue Deletada com Sucesso!!");
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        TextView nameEdit = findViewById(R.id.tvEditName);
        TextView userEdit = findViewById(R.id.tvEditAssignee);
        TextView hoursEdit = findViewById(R.id.tvEditHours);
        if(requestCode==1){
            Bundle bundle = data != null ? data.getExtras(): null;
            if(bundle != null){
                String nameEdited = bundle.getString("nameResult");
                String userEdited = bundle.getString("userResult");
                String hoursEdited = bundle.getString("hoursResult");

                nameEdit.setText(nameEdited);
                userEdit.setText(userEdited);
                hoursEdit.setText(hoursEdited);

            }
        }
    }

    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();}
}
