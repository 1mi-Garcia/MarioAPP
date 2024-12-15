package com.garciarodriguez.juanmiguel.pmdm02.marioapp.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

/**
 * Clase para gestionar las preferencias de idioma de la aplicación.
 */
public class PreferencesHelper {
    private static final String PREFS_NAME = "AppPreferences"; // Nombre del archivo de preferencias
    private static final String LANGUAGE_KEY = "selected_language"; // Clave para almacenar el idioma seleccionado

    /**
     * Obtiene el idioma guardado en las preferencias.
     *
     * @param context Contexto de la aplicación
     * @return Código del idioma guardado
     */
    public static String getSavedLanguage(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return preferences.getString(LANGUAGE_KEY, "en"); // Idioma por defecto: inglés
    }

    /**
     * Guarda el idioma seleccionado en las preferencias.
     *
     * @param context      Contexto de la aplicación
     * @param languageCode Código del idioma a guardar
     */
    public static void saveLanguage(Context context, String languageCode) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LANGUAGE_KEY, languageCode);
        editor.apply();
    }

    /**
     * Cambia el idioma de la aplicación y actualiza la configuración de la misma.
     *
     * @param context Contexto de la aplicación para obtener recursos y configuraciones.
     * @param languageCode Código del idioma a establecer (por ejemplo, "en" para inglés).
     */
    public static void setLocale(Context context, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        context.createConfigurationContext(config);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}
