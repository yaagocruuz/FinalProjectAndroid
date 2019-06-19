package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Tab3 extends Fragment {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference firebaseRef = database.getReference();

    private List<Issue> issueList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);

        DatabaseReference issues = firebaseRef.child("issues");
        issues.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ListView listView = getView().findViewById(R.id.myIssues);
                issueList = new ArrayList<Issue>();
                List<String> issueName = new ArrayList<String>();
                Issue issue;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    issue = postSnapshot.getValue(Issue.class);
                    issue.setIssueId(postSnapshot.getKey());
                    String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                    if(issue.getIssueAssignee().equals(userEmail)) {
                        issueList.add(issue);
                        issueName.add(issue.getIssueName());
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_list_item_1, issueName);
                listView.setAdapter(adapter);
                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        alert("onLongClick Ativado!! "+ issueList.get(position).getIssueId()+" --- "+issueList.get(position).getIssueName());
                        Intent intent = new Intent(Tab3.super.getContext(),IssueView.class);
                        Issue bundleIssue = issueList.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putString("issueID", bundleIssue.getIssueId());
                        bundle.putString("issueName", bundleIssue.getIssueName());
                        bundle.putString("issueAssignee", bundleIssue.getIssueAssignee());
                        bundle.putDouble("issueHours", bundleIssue.getIssueTotalHours());
                        intent.putExtra("Bundle",bundle);
                        startActivity(intent);
                        return true;
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return rootView;
    }
    private void alert(String s){
        Toast.makeText(super.getContext(),s,Toast.LENGTH_LONG).show();}
}
