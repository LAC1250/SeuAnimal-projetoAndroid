package com.example.seuanimal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edit_email,edit_senha;
    private Button entrar;
    private TextView tv_login;
    private TextView tv_senha;
    private ProgressBar progressBar;
    private Intent intent;
    private String [] mensagens = {"preencha todos os campos","login efetuado com sucesso"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        iniciarComponentes();
        tv_login.setOnClickListener(this);
        tv_senha.setOnClickListener(this);
        entrar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cadastro:
                intent = new Intent(MainActivity.this, CadastroUser.class);
                startActivity(intent);
                break;
            case R.id.senha:
                intent = new Intent(MainActivity.this, RecuperarSenha.class);
                startActivity(intent);
                break;
            case R.id.entrar:
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();
                if(email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    AutenticarUsuario(view);
                }
                break;
        }
    }
    private void AutenticarUsuario(View view){
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TelaOpcoes();
                        }
                    },3000);
                }else{
                    String erro;
                    try {
                        throw  task.getException();
                    }catch (Exception e){
                        erro = "erro ao efetuar o login";
                        Snackbar snackbar = Snackbar.make(view,erro,Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.WHITE);
                        snackbar.setTextColor(Color.BLACK);
                        snackbar.show();
                    }
                }
            }
        });
    }
    //ciclo de vida pro app carregar o que ta lá
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuario = FirebaseAuth.getInstance().getCurrentUser();
        if(usuario != null){
            TelaOpcoes();
        }
    }

    private void TelaOpcoes(){
        Intent intent = new Intent(MainActivity.this,Listagem.class);
        startActivity(intent);
        finish();
    }
    private void iniciarComponentes(){
        tv_login = findViewById(R.id.cadastro);
        tv_senha = findViewById(R.id.senha);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        entrar = findViewById(R.id.entrar);
        progressBar = findViewById(R.id.progressbar);
    }


}