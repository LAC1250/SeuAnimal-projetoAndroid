package com.example.seuanimal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroUser extends AppCompatActivity implements View.OnClickListener{
    private EditText edit_email_cad,edit_senha_cad;
    private Button btnCadastro;
    private String [] mensagens = {"preencha todos os campos","cadastro realizado com sucesso, volte ao menu"};
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);
        iniciarComponentes();
        getSupportActionBar().hide();

        btnCadastro.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCadastro:
                String email = edit_email_cad.getText().toString();
                String senha = edit_senha_cad.getText().toString();
                if(email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    CadastrarUsuario(view);
                }
                break;
        }
    }
    private void CadastrarUsuario(View view){
        String email = edit_email_cad.getText().toString();
        String senha = edit_senha_cad.getText().toString();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    String erro;
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erro = "digite uma senha com no minino 6 caracteres";
                    }catch (FirebaseAuthUserCollisionException e){
                        erro = "conta já cadastrada";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erro = "email inválido";
                    }catch (Exception e){
                        erro = "erro ao cadastrar usuário";
                    }
                    Snackbar snackbar = Snackbar.make(view,erro,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }
    private void iniciarComponentes(){
        edit_email_cad = findViewById(R.id.edit_email_cad);
        edit_senha_cad = findViewById(R.id.edit_senha_cad);
        btnCadastro = findViewById(R.id.btnCadastro);
    }
}