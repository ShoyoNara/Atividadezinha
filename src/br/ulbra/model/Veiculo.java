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

//começa private
public class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private String placa;
    private String motor;
    private int km;
    private double valorfipe;
    
    //Fecha private

    // começa getters
    
    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMotor() {
        return motor;
    }

    public int getKm() {
        return km;
    }

    public double getValorfipe() {
        return valorfipe;
    }

    //fecha getters
    
    //começa setters
    
    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setValorfipe(double valorfipe) {
        this.valorfipe = valorfipe;
    }
    
    //Fecha setters

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", Marca=" + marca + ", Modelo=" + modelo + ", Ano=" + ano + ", Cor=" + cor + "Placa=" + placa + "Motor=" + motor + 
                "Km=" + km + '}';
    }

    void add(Veiculo veiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
