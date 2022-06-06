package com.example.seuanimal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.seuanimal.adapter.AdapterGato;
import com.example.seuanimal.model.Gato;

import java.util.ArrayList;
import java.util.List;

public class ListagemGato extends AppCompatActivity {
    private RecyclerView rc_Gato;
    private List<Gato> listaGato = new ArrayList<>();
    private int [] imgCat = {R.drawable.filhote_gato, R.drawable.cruz_credo,R.drawable.gato_gigante};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_gato2);
        getSupportActionBar().hide();

        AdapterGato adapterGat = new AdapterGato(listaGato);
        this.Gatos();
        rc_Gato = findViewById(R.id.rc_Gato);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rc_Gato.setLayoutManager(layoutManager);
        rc_Gato.setHasFixedSize(true);
        rc_Gato.setAdapter(adapterGat);

    }
    public void Gatos(){
        Gato gato = new Gato(imgCat[0],"Rajado","Filhote" + ", Macho","Indisponível");
        this.listaGato.add(gato);
        gato = new Gato(imgCat[1],"Gato","Macho" + ", Filhote de cruz credo","Adoção em andamento");
        this.listaGato.add(gato);
        gato = new Gato(imgCat[1],"Santana","Fêmea" + ", Filhote de cruz credo","Indisponível");
        this.listaGato.add(gato);
        gato = new Gato(imgCat[2],"Shazan","Macho","Disponível para adoção");
        this.listaGato.add(gato);
        gato = new Gato(imgCat[2],"---","Fêmea","Disponível para adoção");
        this.listaGato.add(gato);
        gato = new Gato(imgCat[0],"----","Filhote" + ", Macho","Disponível para adoção");
        this.listaGato.add(gato);
        gato = new Gato(imgCat[1],"----","Filhote" + ", Macho","Disponível para adoção");
        this.listaGato.add(gato);
        gato = new Gato(imgCat[2],"Lindinha","Fêmea","Disponível para adoção");
        this.listaGato.add(gato);
    }
}