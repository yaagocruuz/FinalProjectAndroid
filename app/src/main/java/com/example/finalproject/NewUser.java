package com.example.finalproject;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewUser extends AppCompatActivity {

    private AlertDialog dialog;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference firebaseRef = database.getReference();
    //private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        Button btCadastrar = findViewById(R.id.btNovoCadastro);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = findViewById(R.id.txNovoNome);
                EditText sobrenome = findViewById(R.id.txNovoSobrenome);
                EditText email = findViewById(R.id.txNovoEmail);
                EditText senha = findViewById(R.id.txNovoPass);
                User user = new User(nome.getText().toString(), email.getText().toString(), senha.getText().toString(), sobrenome.getText().toString());
                DatabaseReference newUser = firebaseRef.child("usuarios").push();
                newUser.setValue(user);
                Log.i("Create User", "Usuário Cadastrado com Sucesso");
                nome.setText("");
                email.setText("");
                sobrenome.setText("");
                senha.setText("");
                alert("Usuário Criado com Sucesso");



//                auth.createUserWithEmailAndPassword(email.getText().toString(),senha.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(NewUser.this);
//                        if(task.isSuccessful()){
//                            builder.setMessage("Cadastro Realizado com Sucesso");
//                            dialog = builder.create();
//                            dialog.show();
//                        }else{
//                            builder.setMessage("Cadastro Incompleto");
//                            dialog = builder.create();
//                            dialog.show();
//                            Log.i("Exception",task.getException().toString());
//                        }
//                    }
//                });
            }

        });

    }
    private void alert(String s){Toast.makeText(this,s,Toast.LENGTH_LONG).show();}
}
