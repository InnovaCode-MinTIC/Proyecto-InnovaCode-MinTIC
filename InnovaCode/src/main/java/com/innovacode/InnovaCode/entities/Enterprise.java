package com.innovacode.InnovaCode.entities;

public class Enterprise {
    private String name;
    private String address;
    private String phone;
    private String document;

    public Enterprise(String nombre, String direccion, String telefono, String nit) {
        this.name = nombre;
        this.address = direccion;
        this.phone = telefono;
        this.document = nit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + name + '\'' +
                ", direccion='" + address + '\'' +
                ", telefono='" + phone + '\'' +
                ", nit='" + document + '\'' +
                '}';
    }
}
