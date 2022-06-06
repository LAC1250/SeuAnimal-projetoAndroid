package com.example.seuanimal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.ktx.Firebase;

public class Listagem extends AppCompatActivity implements View.OnClickListener{
    private Button sair,dog,cat;
    private Intent intent;
    private TextView EmailUsuario;
    private FirebaseFirestore bd = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        getSupportActionBar().hide();
        IniciarComponentes();
        sair.setOnClickListener(this);
        dog.setOnClickListener(this);
        cat.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        DocumentReference documentReference = bd.collection("Email").document(email);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if(value != null){
                    EmailUsuario.setText(email);
                }
            }
        });
    }

    private void IniciarComponentes(){
        sair = findViewById(R.id.sair);
        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        EmailUsuario = findViewById(R.id.EmailUsuario);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sair:
                FirebaseAuth.getInstance().signOut();
                intent = new Intent(Listagem.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.dog:
                intent = new Intent(Listagem.this, ListagemDog.class);
                startActivity(intent);
                break;
            case R.id.cat:
                Intent i = new Intent(Listagem.this, ListagemGato.class);
                startActivity(i);
                break;
        }
    }
}