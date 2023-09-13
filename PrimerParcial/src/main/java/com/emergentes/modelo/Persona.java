package com.emergentes.modelo;

public class Persona {
    private int id;
    private String descripcion;
    private String cantidad;
    private String precio;
    private String categoria;
  
    
    public  Persona (){
        this.id = 0;
        this.descripcion = "";
        this.cantidad = "";
        this.precio = "";
        this.categoria = "";
        
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    }
