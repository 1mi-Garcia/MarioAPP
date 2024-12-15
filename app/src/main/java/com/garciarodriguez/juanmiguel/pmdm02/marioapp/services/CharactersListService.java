package com.garciarodriguez.juanmiguel.pmdm02.marioapp.services;


import android.view.View;

import com.garciarodriguez.juanmiguel.pmdm02.marioapp.R;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.model.CharacterModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


/**
 * Servicio para gestionar la lista de personajes.
 */
public class CharactersListService {

    /**
     * Carga una lista de personajes utilizando recursos predefinidos y muestra una notificación de éxito.
     *
     * @param view Vista actual, necesaria para acceder a los recursos y mostrar la notificación.
     * @return Lista preconfigurada de personajes.
     */
    public static ArrayList<CharacterModel> getCharactersList(View view) {
        ArrayList<CharacterModel> characterList = new ArrayList<>();

        // Añade personajes al ArrayList usando recursos definidos en strings.xml y arrays.xml
        characterList.add(new CharacterModel(
                R.string.mario_name, // Nombre del personaje
                R.string.mario_description, // Descripción del personaje
                R.drawable.mario, // Imagen del personaje
                view.getContext().getResources().getStringArray(R.array.mario_powers) // Lista de poderes
        ));

        characterList.add(new CharacterModel(
                R.string.luigi_name,
                R.string.luigi_description,
                R.drawable.luigi,
                view.getContext().getResources().getStringArray(R.array.luigi_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.peach_name,
                R.string.peach_description,
                R.drawable.peach,
                view.getContext().getResources().getStringArray(R.array.peach_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.bowser_name,
                R.string.bowser_description,
                R.drawable.bowser,
                view.getContext().getResources().getStringArray(R.array.bowser_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.toad_name,
                R.string.toad_description,
                R.drawable.toad,
                view.getContext().getResources().getStringArray(R.array.toad_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.yoshi_name,
                R.string.yoshi_description,
                R.drawable.yoshi,
                view.getContext().getResources().getStringArray(R.array.yoshi_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.daisy_name,
                R.string.daisy_description,
                R.drawable.daisy,
                view.getContext().getResources().getStringArray(R.array.daisy_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.wario_name,
                R.string.wario_description,
                R.drawable.wario,
                view.getContext().getResources().getStringArray(R.array.wario_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.waluigi_name,
                R.string.waluigi_description,
                R.drawable.waluigi,
                view.getContext().getResources().getStringArray(R.array.waluigi_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.rosalina_name,
                R.string.rosalina_description,
                R.drawable.rosalina,
                view.getContext().getResources().getStringArray(R.array.rosalina_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.bowserjr_name,
                R.string.bowserjr_description,
                R.drawable.bowserjr,
                view.getContext().getResources().getStringArray(R.array.bowserjr_powers)
        ));

        characterList.add(new CharacterModel(
                R.string.kamek_name,
                R.string.kamek_description,
                R.drawable.kamek,
                view.getContext().getResources().getStringArray(R.array.mario_powers)
        ));

        // Muestra un mensaje de notificación indicando que la lista se ha cargado
        Snackbar.make(view, R.string.snack_message, Snackbar.LENGTH_SHORT).show();
        return characterList;
    }
}
