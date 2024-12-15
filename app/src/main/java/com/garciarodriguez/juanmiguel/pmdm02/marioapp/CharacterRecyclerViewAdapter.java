package com.garciarodriguez.juanmiguel.pmdm02.marioapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.garciarodriguez.juanmiguel.pmdm02.marioapp.databinding.CharacterCardviewBinding;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.model.CharacterModel;

import java.util.ArrayList;


/**
 * Adaptador para gestionar el RecyclerView de personajes.
 */
public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private final ArrayList<CharacterModel> characters; // Lista de personajes
    private final Context context; // Contexto de la actividad

    /**
     * Constructor del adaptador.
     *
     * @param characters Lista de personajes
     * @param context    Contexto de la actividad
     */
    public CharacterRecyclerViewAdapter(ArrayList<CharacterModel> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterCardviewBinding binding = CharacterCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterModel currentCharacter = this.characters.get(position);
        holder.bind(currentCharacter);

        holder.itemView.setOnClickListener(view -> itemClicked(currentCharacter, view));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    /**
     * Navega al fragmento de detalle con el personaje seleccionado.
     *
     * @param currentCharacter Personaje sobre el que se realizó clic.
     * @param view Vista donde ocurrió el evento de clic.
     */
    private void itemClicked(CharacterModel currentCharacter, View view) {
        ((MainActivity) context).itemClicked(currentCharacter, view);
    }
}
