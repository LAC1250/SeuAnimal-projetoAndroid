package com.example.seuanimal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seuanimal.R;
import com.example.seuanimal.model.Gato;

import java.util.List;

public class AdapterGato extends RecyclerView.Adapter<AdapterGato.MyViewHolder>{
    private List<Gato> listaCat;
    public AdapterGato(List<Gato> listaCat){
        this.listaCat = listaCat;
    }
    @NonNull
    @Override
    public AdapterGato.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_lista_g = LayoutInflater.from(parent.getContext()).inflate(R.layout.cats, parent,false);
        return new AdapterGato.MyViewHolder(item_lista_g);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGato.MyViewHolder holder, int position) {
        String nomeGato = listaCat.get(position).getNome();
        String descGato = listaCat.get(position).getDescricao();
        String situacaoGato = listaCat.get(position).getSituacao();
        int fotoGato = listaCat.get(position).getFoto();

        holder.nomeGato.setText(nomeGato);
        holder.descGato.setText(descGato);
        holder.situacaoGato.setText(situacaoGato);
        holder.fotoGato.setImageResource(fotoGato);
    }

    @Override
    public int getItemCount() {
        return listaCat.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeGato,descGato,situacaoGato;
        private ImageView fotoGato;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeGato = itemView.findViewById(R.id.nomeGato);
            descGato = itemView.findViewById(R.id.descGato);
            situacaoGato = itemView.findViewById(R.id.situacaoGato);
            fotoGato = itemView.findViewById(R.id.fotoGato);
        }
    }
}
