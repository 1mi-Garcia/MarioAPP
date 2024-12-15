package com.garciarodriguez.juanmiguel.pmdm02.marioapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.garciarodriguez.juanmiguel.pmdm02.marioapp.databinding.FragmentSettingBinding;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.services.PreferencesHelper;


/**
 * Fragmento que gestiona la configuración de idioma de la aplicación.
 * Permite al usuario cambiar entre los idiomas disponibles (español e inglés).
 */
public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Recuperar el idioma guardado
        String currentLanguage = PreferencesHelper.getSavedLanguage(requireContext());

        // Configurar el estado inicial del Switch
        binding.spanishSwitch.setChecked("es".equals(currentLanguage)); // Activar el switch si el idioma actual es español

        // Configurar el listener para el Switch
        binding.spanishSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String newLanguageCode = isChecked ? "es" : "en"; // Cambiar a español si está activado; de lo contrario, inglés
            languageSwitch(newLanguageCode);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambiar el titulo del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.language_preference);
        }
    }

    /**
     * Cambia el idioma de la aplicación.
     *
     * @param languageCode Código del idioma a establecer ("es" para español o "en" para inglés).
     */
    private void languageSwitch(String languageCode) {
        // Guardar la preferencia del idioma
        PreferencesHelper.saveLanguage(requireContext(), languageCode);

        // Actualizar el idioma en la configuración de la aplicación
        PreferencesHelper.setLocale(requireContext(), languageCode);

        // Reiniciar la actividad para aplicar el nuevo idioma
        restartActivity();
    }

    /**
     * Reinicia la actividad actual para aplicar los cambios de idioma.
     */
    private void restartActivity() {
        // Obtener el intent de la actividad actual
        Intent intent = requireActivity().getIntent();
        // Evitar animaciones durante la transición
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        // Finalizar la actividad actual
        requireActivity().finish();
        // Iniciar nuevamente la actividad
        startActivity(intent);
    }
}

