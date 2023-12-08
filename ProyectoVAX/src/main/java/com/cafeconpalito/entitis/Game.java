/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.entitis;

/**
 *
 * @author produccion
 */
public class Game {
    
    private int idJuego;
    private String titulo;
    private String descripcion;
    private String urlImagen;
    private String fecha;
    private int numDescargas;
    private double precio;
    
    //Esto tiene que ser un array list me parece a mi.
    private String genero;
    
    //Esto es segun region
    private String regulacion;
    
    //El que añadio el juego
    private int idUsuarioRegistroJuego;

    public Game() {
    }

    //CREO que se puede destruir
    public Game(int idJuego, String titulo, double precio, int numDescargas , String urlImagen){
        this.idJuego = idJuego;
        this.titulo = titulo;
        this.precio = precio;
        this.numDescargas = numDescargas;
        this.urlImagen = urlImagen;
    }
    
    public Game(int idJuego, String titulo, String descripcion, String urlImagen, String fecha, int numDescargas, double precio, String genero, String regulacion, int idUsuarioRegistroJuego) {
        this.idJuego = idJuego;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.fecha = fecha;
        this.numDescargas = numDescargas;
        this.precio = precio;
        this.genero = genero;
        this.regulacion = regulacion;
        this.idUsuarioRegistroJuego = idUsuarioRegistroJuego;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(int numDescargas) {
        this.numDescargas = numDescargas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRegulacion() {
        return regulacion;
    }

    public void setRegulacion(String regulacion) {
        this.regulacion = regulacion;
    }

    public int getIdUsuarioRegistroJuego() {
        return idUsuarioRegistroJuego;
    }

    public void setIdUsuarioRegistroJuego(int idUsuarioRegistroJuego) {
        this.idUsuarioRegistroJuego = idUsuarioRegistroJuego;
    }
    
    
}
