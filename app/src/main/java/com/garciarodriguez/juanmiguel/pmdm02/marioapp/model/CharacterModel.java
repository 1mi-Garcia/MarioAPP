package com.garciarodriguez.juanmiguel.pmdm02.marioapp.model;

/**
 * Representa un modelo de personaje en el juego.
 */
public class CharacterModel {
    private final int name; // ID del recurso de nombre del personaje
    private final int description; // ID del recurso de descripción del personaje
    private final int image; // ID del recurso de imagen del personaje
    private final String[] power; // Lista de poderes del personaje

    /**
     * Constructor que inicializa un personaje con los atributos especificados.
     *
     * @param name        ID del recurso del nombre del personaje
     * @param description ID del recurso de la descripción del personaje
     * @param image       ID del recurso de la imagen del personaje
     * @param power       Lista de poderes del personaje
     */
    public CharacterModel(int name, int description, int image, String[] power) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.power = power;
    }

    /**
     * Obtiene el ID del recurso del nombre del personaje.
     *
     * @return ID del recurso del nombre
     */
    public int getName() {
        return name;
    }

    /**
     * Obtiene el ID del recurso de la descripción del personaje.
     *
     * @return ID del recurso de la descripción
     */
    public int getDescription() {
        return description;
    }

    /**
     * Obtiene el ID del recurso de la imagen del personaje.
     *
     * @return ID del recurso de la imagen
     */
    public int getImage() {
        return image;
    }

    /**
     * Obtiene la lista de poderes del personaje.
     *
     * @return Array de poderes del personaje
     */
    public String[] getPower() {
        return power;
    }
}
