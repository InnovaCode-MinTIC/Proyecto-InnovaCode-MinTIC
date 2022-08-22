package com.innovacode.InnovaCode.entities;

public class Empresa {
    private String nombre;
    private String direccion;
    private String telefono;
    private String nit;

    public Empresa(String nombre, String direccion, String telefono, String nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }
}
