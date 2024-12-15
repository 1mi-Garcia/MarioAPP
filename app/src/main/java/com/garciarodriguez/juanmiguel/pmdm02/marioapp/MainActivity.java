package com.garciarodriguez.juanmiguel.pmdm02.marioapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.garciarodriguez.juanmiguel.pmdm02.marioapp.databinding.ActivityMainBinding;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.model.CharacterModel;
import com.garciarodriguez.juanmiguel.pmdm02.marioapp.services.PreferencesHelper;
import com.google.gson.Gson;

/**
 * Actividad principal de la aplicación.
 * Maneja la navegación, el menú lateral (Navigation Drawer) y los eventos de interacción.
 */
public class MainActivity extends AppCompatActivity {

    // Toggle para el Navigation Drawer
    private ActionBarDrawerToggle toggle;
    // View Binding para acceder a los elementos de la vista
    private ActivityMainBinding binding;
    // Controlador de navegación
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtener el idioma guardado y aplicarlo
        String currentLanguage = PreferencesHelper.getSavedLanguage(this);
        PreferencesHelper.setLocale(this, currentLanguage);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        // Obtener el NavController desde el NavHostFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        navController.addOnDestinationChangedListener(this::onChangeView);

        // Configurar menú toggle
        configureToggleMenu();

        // Configurar la navegación
        configureNavigation();

        // Configurar el icono del menú en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Configura el comportamiento del Navigation Drawer según la vista actual.
     *
     * @param navController  Controlador de navegación.
     * @param navDestination Destino actual de la navegación.
     * @param bundle         Datos adicionales (puede ser null).
     */
    private void onChangeView(NavController navController, NavDestination navDestination, Bundle bundle) {
        if (toggle != null) {
            // Desactivar el indicador del Drawer en el fragmento de detalle
            if (navDestination.getId() == R.id.detailFragment) {
                toggle.setDrawerIndicatorEnabled(false);
            } else {
                toggle.setDrawerIndicatorEnabled(true);
            }
        }
    }

    /**
     * Configura el menú lateral (Navigation Drawer) y su listener.
     */
    private void configureToggleMenu() {
        // Configurar el ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Configura la navegación utilizando el Navigation Controller.
     */
    private void configureNavigation() {
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar la selección de elementos del menú lateral
        binding.navView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.homeFragment); // Navegar al fragmento de inicio
            } else if (menuItem.getItemId() == R.id.nav_setting) {
                navController.navigate(R.id.settingFragment); // Navegar al fragmento de configuración
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú lateral
            return true;
        });
    }

    /**
     * Crea el menú contextual en la barra de acciones.
     *
     * @param menu Menú en el que se inflarán los elementos.
     * @return true si el menú se creó correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Maneja los clics en los elementos del menú contextual.
     *
     * @param item Elemento del menú seleccionado.
     * @return true si se manejó el evento; false en caso contrario.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        } else if (item.getItemId() == R.id.action_about) {
            // Mostrar el cuadro de diálogo "Acerca de"
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un cuadro de diálogo "Acerca de" con información de la aplicación.
     */
    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.action_about)
                .setMessage(R.string.about_message)
                .setIcon(R.mipmap.splash_mario) // Icono de la app
                .setPositiveButton("Aceptar", null); // Botón de cierre
        builder.show();
    }

    /**
     * Maneja el clic en un elemento de la lista de personajes.
     *
     * @param character Objeto CharacterModel con los datos del personaje.
     * @param view      Vista desde la que se produjo el evento.
     */
    public void itemClicked(CharacterModel character, View view) {
        // Convertir el objeto CharacterModel a JSON usando Gson
        Gson gson = new Gson();
        String characterJson = gson.toJson(character);

        // Crear un Bundle para almacenar los datos del personaje
        Bundle bundle = new Bundle();
        bundle.putString("character_data", characterJson);

        // Navegar al fragmento de detalle con los datos del personaje
        Navigation.findNavController(view).navigate(R.id.detailFragment, bundle);
    }

    /**
     * Maneja la navegación hacia atrás dentro del controlador de navegación.
     *
     * @return true si se manejó el evento; false en caso contrario.
     */
    @Override
    public boolean onSupportNavigateUp() {
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavController navController = NavHostFragment.findNavController(navHostFragment);
            return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }
}