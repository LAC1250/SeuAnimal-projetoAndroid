package com.example.seuanimal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity {
    private TextView tv_login;
    private TextView tv_senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        iniciarComponentes();
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroUser.class);
                startActivity(intent);
            }
        });
        tv_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecuperarSenha.class);
                startActivity(intent);
            }
        });
    }
    private void iniciarComponentes(){
        tv_login = findViewById(R.id.cadastro);
        tv_senha = findViewById(R.id.senha);
    }
}