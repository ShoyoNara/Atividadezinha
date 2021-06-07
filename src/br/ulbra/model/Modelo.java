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
public class Modelo {
    
    private int id;
    private String Modelo;
    private String Marca;
    private int Ano;


    //Fecha Setters

    public int getId() {
        return id;
    }

    public String getModelo() {
        return Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public int getAno() {
        return Ano;
    }

     // Fecha Getters
    
    
     //Começa Setters


    public void setId(int id) {
        this.id = id;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }
    
    //Fecha Setters

    public void setano(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
