package com.example.seuanimal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.seuanimal.adapter.AdapterCachorro;
import com.example.seuanimal.model.Cachorro;

import java.util.ArrayList;
import java.util.List;

public class ListagemDog extends AppCompatActivity {
    private RecyclerView rc_Dog;
    private List<Cachorro> listaCachorro = new ArrayList<>();
    private int [] imgDog = {R.drawable.golden_filhote, R.drawable.golden_adulto,R.drawable.pastor_belga};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_dog);
        getSupportActionBar().hide();

        AdapterCachorro adapter = new AdapterCachorro(listaCachorro);
        this.criarCachorros();
        rc_Dog = findViewById(R.id.rc_Dog);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rc_Dog.setLayoutManager(layoutManager);
        rc_Dog.setHasFixedSize(true);
        rc_Dog.setAdapter(adapter);
    }
    public void criarCachorros(){
        Cachorro dog = new Cachorro(imgDog[0],"Thor","Macho" + " Filhote","Disponível para adoção");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[2],"Aranha","Macho" + " Adulto","Disponível para adoção");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[1],"Xing-Xong","Macho" + " Adulto","Adoção em andamento");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[2],"Lala","Fêmea" + " Adulta","Disponível para adoção");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[1],"Tânea","Fêmea" + " Adulta","Adoção em andamento");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[0],"---","Fêmea" + " Filhote","Disponível para adoção");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[0],"---","Fêmea" + " Filhote","Adoção em andamento");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[2],"Paçoca","Macho" + " Adulto","Disponível para adoção");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[1],"Xing","Macho" + " Adulto","Disponível para adoção");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[1],"Florzinha","Fêmea" + " Adulta","Disponível para adoção");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[1],"Xong","Macho" + " Adulto","Adoção em andamento");
        this.listaCachorro.add(dog);
        dog = new Cachorro(imgDog[1],"Lindinha","Fêmea" + " Adulta","Adoção em andamento");
        this.listaCachorro.add(dog);
    }
}