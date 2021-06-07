/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author samuc
 */
public class ModeloDao {
        Connection con;
    
    public ModeloDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
        public void create(Modelo u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbmodelo (Modelo,"
                    + "Marca,Ano) VALUE (?,?,?,?)");
            stmt.setString(1, u.getModelo());
            stmt.setString(2, u.getMarca());
            stmt.setInt(3, u.getAno());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "O Modelo "+u.getModelo()
                    +" Salvo com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de Modelo na tabela do formulario   ---   R
    
    public ArrayList<Modelo> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Modelo> Modelo = new ArrayList<Modelo>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmodelo");
            rs = stmt.executeQuery();
            while(rs.next()){
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("Id"));
                modelo.setModelo(rs.getString("Modelo"));
                modelo.setMarca(rs.getString("Marca"));
                modelo.setAno(rs.getInt("Ano"));
                Modelo.add(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Modelo>) Modelo;
    }
    
    public ArrayList<Modelo> readPesq(String Marca){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Modelo> Modelo = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmodelo WHERE marca LIKE ?");
            stmt.setString(1, "%"+Marca+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
               Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("Id"));
                modelo.setModelo(rs.getString("Modelo"));
                modelo.setMarca(rs.getString("Marca"));
                modelo.setAno(rs.getInt("Ano"));
                Modelo.add(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Modelo>) Modelo;
    }
    
    //ALTERAR O Modelo NO BANCO DE DADOS   -- U 
    public void update(Modelo u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbmodelo SET Modelo = ?,"
                    + "Marca = ?, Ano = ? , WHERE id = ?");
            stmt.setInt(5, u.getId());
            stmt.setString(1, u.getModelo());
            stmt.setString(2, u.getMarca());
            stmt.setInt(3, u.getAno());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "O Modelo "+u.getModelo()
                    +" Modificado com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Modelo u){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbmodelo WHERE id = ?");
           
            stmt.setInt   (1, u.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que"
                    + " deseja excluir o Modelo "+u.getModelo(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Modelo "+u.getModelo()
                    +" excluído(a)com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do Modelo "+u.getModelo()
                    +" Cancelado(a)com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean checkLogin(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
