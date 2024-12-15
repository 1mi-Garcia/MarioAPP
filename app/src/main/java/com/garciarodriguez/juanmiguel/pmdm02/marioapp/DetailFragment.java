package com.garciarodriguez.juanmiguel.pmdm02.marioapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.garciarodriguez.juanmiguel.pmdm02.marioapp.databinding.FragmentDetailsBinding;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.model.CharacterModel;
import com.google.gson.Gson;

import java.util.Objects;


/**
 * Fragmento que muestra los detalles de un personaje.
 */
public class DetailFragment extends Fragment {

    private FragmentDetailsBinding binding; // Enlace al diseño
    private CharacterModel character; // Personaje actual

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String characterJson = requireArguments().getString("character_data");
        Gson gson = new Gson();
        character = gson.fromJson(characterJson, CharacterModel.class);

        loadDetail();
    }

    @Override
    public void onStart() {
        super.onStart();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(R.string.characters_detail);
    }

    /**
     * Carga los datos del personaje recibido en el diseño del fragmento.
     * Muestra un Toast con el nombre del personaje.
     */
    private void loadDetail() {
        if (character != null) {
            binding.image.setImageResource(character.getImage());
            binding.name.setText(character.getName());
            binding.description.setText(character.getDescription());
            binding.power.setText(String.join(", ", character.getPower()));

            Toast.makeText(requireContext(), getString(R.string.toast_message) + requireContext().getString(character.getName()), Toast.LENGTH_SHORT).show();
        }
    }
}
