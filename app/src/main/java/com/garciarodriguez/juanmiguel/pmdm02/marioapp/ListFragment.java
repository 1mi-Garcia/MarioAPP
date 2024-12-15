package com.garciarodriguez.juanmiguel.pmdm02.marioapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.garciarodriguez.juanmiguel.pmdm02.marioapp.databinding.FragmentListBinding;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.model.CharacterModel;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.services.CharactersListService;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Fragmento que muestra una lista de personajes utilizando un RecyclerView.
 */
public class ListFragment extends Fragment {

    // Enlace a la vista a través de View Binding
    private FragmentListBinding binding;
    // Lista de personajes que se mostrará en el RecyclerView
    private ArrayList<CharacterModel> characters;
    // Adaptador para manejar los elementos del RecyclerView
    private CharacterRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        characters = CharactersListService.getCharactersList(view);

        // Configura el RecyclerView
        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.characterRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.characterRecyclerview.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el titulo del ActionBar
        if (getActivity() != null) {
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setTitle(R.string.characters_list);
        }
    }
}