
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
public class VeiculoDao {
 Connection con;
    
    public VeiculoDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }

   
    
    // SALVA O VEICULO NO BANCO DE DADOS   ---- C
    public void create(Veiculo u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbveiculo (marca,"
                    + "modelo,ano,cor,placa,motor,km,valorfipe) VALUE (?,?,?,?)");
            stmt.setString(1, u.getMarca());
            stmt.setString(2, u.getModelo());
            stmt.setInt(3, u.getAno());
            stmt.setString(4, u.getCor());
            stmt.setString(4, u.getPlaca());
            stmt.setString(4, u.getMotor());
            stmt.setInt(4, u.getKm());
            stmt.setDouble(4, u.getValorfipe());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "veiculo de modelo"+u.getModelo()
                    +" Salvo com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de Veiculos na tabela do formulario   ---   R
    
    public ArrayList<Veiculo> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Veiculo> Veiculos = new ArrayList<Veiculo>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbveiculo");
            rs = stmt.executeQuery();
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("Id"));
                veiculo.setMarca(rs.getString("Marca"));
                veiculo.setModelo(rs.getString("Modelo"));
                veiculo.setAno(rs.getInt("Ano"));
                veiculo.setCor(rs.getString("Cor"));
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setMotor(rs.getString("Motor"));
                veiculo.setKm(rs.getInt("Quiôometro"));
                veiculo.setValorfipe(rs.getDouble("ValorFipe"));
                Veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Veiculo>) Veiculos;
    }
    
    public ArrayList<Veiculo> readPesq(String Marca){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Veiculo> Veiculos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbveiculo WHERE marca LIKE ?");
            stmt.setString(1, "%"+Marca+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("Id"));
                veiculo.setMarca(rs.getString("MArca"));
                veiculo.setModelo(rs.getString("Modelo"));
                veiculo.setAno(rs.getInt("Ano"));
                veiculo.setCor(rs.getString("Cor"));
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setMotor(rs.getString("Motr"));
                veiculo.setKm(rs.getInt("Km"));
                veiculo.setValorfipe(rs.getDouble("Valorfipe"));
                veiculo.add(veiculo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Veiculo>) Veiculos;
    }
    
    //ALTERAR O VEICULO NO BANCO DE DADOS   -- U 
    public void update(Veiculo u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbveiculo SET Marca = ?,"
                    + "Modelo = ?, Ano = ? ,Cor = ?, Placa = ?, Motor = ?,"
                    + "Km = ?, Valorfipe = ?, WHERE id = ?");
            stmt.setString(1, u.getMarca());
            stmt.setString(2, u.getModelo());
            stmt.setInt(3, u.getAno());
            stmt.setString(4, u.getCor());
            stmt.setInt(5, u.getId());
            stmt.setString(5, u.getPlaca());
            stmt.setString(5, u.getMotor());
            stmt.setInt(5, u.getKm());
            stmt.setDouble(5, u.getValorfipe());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Veiculo Da Marca"+u.getMarca()
                    +" Modificado com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Veiculo u){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbveiculo WHERE id = ?");
           
            stmt.setInt   (1, u.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que"
                    + " deseja excluir o Veiculo Da Marca"+u.getMarca(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Vaiculo Da Marca "+u.getMarca()
                    +" excluído(a)com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do Vaiculo de marca"+u.getMarca()
                    +" Cancelado(a)com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
}
