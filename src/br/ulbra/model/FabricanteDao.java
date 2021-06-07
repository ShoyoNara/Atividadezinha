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
public class FabricanteDao {
    Connection con;
    
    public FabricanteDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
        public void create(Fabricante u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbfabricante (Marca,"
                    + "Telefone,Site,Email) VALUE (?,?,?,?)");
            stmt.setString(1, u.getMarca());
            stmt.setString(2, u.getTelefone());
            stmt.setString(3, u.getSite());
            stmt.setString(4, u.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "O Fabricante da marca"+u.getMarca()
                    +" Salvo com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de Fabricantes na tabela do formulario   ---   R
    
    public ArrayList<Fabricante> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fabricante> Fabricante = new ArrayList<Fabricante>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbfabricante");
            rs = stmt.executeQuery();
            while(rs.next()){
                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("Id"));
                fabricante.setMarca(rs.getString("Marca"));
                fabricante.setTelefone(rs.getString("Telefone"));
                fabricante.setSite(rs.getString("Site"));
                fabricante.setEmail(rs.getString("Email"));
                Fabricante.add(fabricante);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Fabricante>) Fabricante;
    }
    
    public ArrayList<Fabricante> readPesq(String Marca){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fabricante> Fabricante = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbfabricante WHERE marca LIKE ?");
            stmt.setString(1, "%"+Marca+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("Id"));
                fabricante.setMarca(rs.getString("Marca"));
                fabricante.setTelefone(rs.getString("Telefone"));
                fabricante.setSite(rs.getString("Site"));
                fabricante.setEmail(rs.getString("Email"));
                Fabricante.add(fabricante);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Fabricante>) Fabricante;
    }
    
    //ALTERAR O VEICULO NO BANCO DE DADOS   -- U 
    public void update(Fabricante u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbfabricante SET Marca = ?,"
                    + "Telefone = ?, Site = ? , Email = ?, WHERE id = ?");
            stmt.setInt(5, u.getId());
            stmt.setString(1, u.getMarca());
            stmt.setString(2, u.getTelefone());
            stmt.setString(3, u.getSite());
            stmt.setString(4, u.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "O Fabricante da Marca"+u.getMarca()
                    +" Modificado com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Fabricante u){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbfabricante WHERE id = ?");
           
            stmt.setInt   (1, u.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que"
                    + " deseja excluir o Fabricante da Marca"+u.getMarca(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Fabricante da Marca "+u.getMarca()
                    +" excluído(a)com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do Fabricante da marca"+u.getMarca()
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
