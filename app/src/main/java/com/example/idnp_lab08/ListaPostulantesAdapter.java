package com.example.idnp_lab08;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaPostulantesAdapter extends RecyclerView.Adapter<ListaPostulantesAdapter.PostulanteViewHolder> {

    ArrayList<Postulante> listaPostulantes;
    public ListaPostulantesAdapter(ArrayList<Postulante> listaPostulantes){
        this.listaPostulantes = listaPostulantes;
    }

    @NonNull
    @Override
    public ListaPostulantesAdapter.PostulanteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_iten_postulante, null, false);
        return new PostulanteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPostulantesAdapter.PostulanteViewHolder holder, int position) {
        holder.txNombre.setText(listaPostulantes.get(position).getNombres());
        holder.txApePaterno.setText(listaPostulantes.get(position).getApePaterno());
        holder.txApeMaterno.setText(listaPostulantes.get(position).getApeMaterno());
        holder.txCarrera.setText(listaPostulantes.get(position).getCarrera());

    }

    @Override
    public int getItemCount() {
        return listaPostulantes.size();
    }
    public class PostulanteViewHolder extends  RecyclerView.ViewHolder{

        TextView txNombre,txApePaterno, txApeMaterno,txCarrera;

        public PostulanteViewHolder(@NonNull View itemView) {
            super(itemView);
            txNombre = itemView.findViewById(R.id.txNombre);
            txApePaterno = itemView.findViewById(R.id.txApePaterno);
            txApeMaterno = itemView.findViewById(R.id.txApeMaterno);
            txCarrera = itemView.findViewById(R.id.txCarrera);
        }
    }
}
