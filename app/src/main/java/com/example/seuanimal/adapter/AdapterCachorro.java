package com.example.seuanimal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seuanimal.R;
import com.example.seuanimal.model.Cachorro;

import java.util.List;

public class AdapterCachorro extends RecyclerView.Adapter<AdapterCachorro.MyViewHolder>{
    private List<Cachorro> listaCachorro;
    public AdapterCachorro(List<Cachorro> listaCachorro){
        this.listaCachorro = listaCachorro;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.dogs, parent,false);
        return new MyViewHolder(item_lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      String nomeCachorro = listaCachorro.get(position).getNome();
      String descCachorro = listaCachorro.get(position).getDescricao();
      String situacao = listaCachorro.get(position).getSituacao();
      int imagem = listaCachorro.get(position).getFoto();

      holder.nomeCachorro.setText(nomeCachorro);
      holder.descCachorro.setText(descCachorro);
      holder.situacao.setText(situacao);
      holder.fotoCachorro.setImageResource(imagem);
    }

    @Override
    public int getItemCount() {
        return listaCachorro.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeCachorro,descCachorro,situacao;
        private ImageView fotoCachorro;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeCachorro = itemView.findViewById(R.id.nomeCachorro);
            descCachorro = itemView.findViewById(R.id.descCachorro);
            situacao = itemView.findViewById(R.id.situacao);
            fotoCachorro = itemView.findViewById(R.id.fotoCachorro);
        }
    }
}
