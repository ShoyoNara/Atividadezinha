/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

/**
 *
 * @author samuc
 */
public class Fabricante {
    
    private int id;
    private String marca;
    private String telefone;
    private String site;
    private String email;

    
    // Começa  Getters
    
    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSite() {
        return site;
    }

    public String getEmail() {
        return email;
    }

    //Termina Getters
    
    //Começa Setters
    
    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // Termina Setters
    
    
    
}
