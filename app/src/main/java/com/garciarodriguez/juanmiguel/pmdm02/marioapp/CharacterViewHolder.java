package com.garciarodriguez.juanmiguel.pmdm02.marioapp;


import androidx.recyclerview.widget.RecyclerView;

import com.garciarodriguez.juanmiguel.pmdm02.marioapp.databinding.CharacterCardviewBinding;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.model.CharacterModel;


/**
 * ViewHolder para gestionar el diseño y datos de cada personaje.
 */
public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterCardviewBinding binding; // Enlace al diseño del cardview

    /**
     * Constructor que inicializa el ViewHolder con el enlace al diseño.
     *
     * @param binding Enlace al diseño del cardview
     */
    public CharacterViewHolder(CharacterCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Vincula los datos del personaje al diseño.
     *
     * @param character Modelo del personaje a vincular
     */
    public void bind(CharacterModel character) {
        binding.circleImage.setImageResource(character.getImage());
        binding.name.setText(character.getName());
        binding.executePendingBindings();
    }
}
