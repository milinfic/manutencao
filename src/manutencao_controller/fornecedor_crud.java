/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manutencao_controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import manutencao_model.fornecedor_model;

/**
 *
 * @author Paulo
 */
public class fornecedor_crud {

    conexao conectar = new conexao();    

    public void insert(fornecedor_model fornecedor) {
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "INSERT INTO fornecedores(nome,endereco,cnpj,telefone) "
                    + "VALUES( ?, ?, ?, ? )");

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getTelefone());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Cadastro de Fornecedor", 0);
        }
    }

    public ArrayList nome() {
        ArrayList<fornecedor_model> busca = new ArrayList<>();
        
        try {
            conectar.conectar(); 
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                "SELECT idfornecedor, nome FROM fornecedores");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                fornecedor_model fornecedores = new fornecedor_model();
                fornecedores.setIdfornecedor(Integer.parseInt(rs.getString("idfornecedor")));
                fornecedores.setNome(rs.getString("nome"));
                busca.add(fornecedores);
            }
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta de Fornecedores", 0);
        }

        return busca;
    }
    
    public boolean buscacnpj(String cnpj){
        boolean v = false;
        
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                "select cnpj from fornecedores "
                        + "where cnpj = ?");
            
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                v = true;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta de Fornecedores", 0);
        }
        
        return v;
    }
    
    public ArrayList buscaalterar(String cnpj){
        ArrayList<fornecedor_model> alterar = new ArrayList<>();
        
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                "select * from fornecedores "
                        + "where cnpj = ?");
            
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) { 
                fornecedor_model model = new fornecedor_model();
                model.setIdfornecedor(Integer.parseInt(rs.getString("idfornecedor")));
                model.setNome(rs.getString("nome"));
                model.setEndereco(rs.getString("endereco"));
                model.setTelefone(rs.getString("telefone"));
                alterar.add(model);                                
            }            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta de Fornecedores", 0);
        }
        
        return alterar;
    }
    
    public void update(fornecedor_model fornecedor) {
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "update fornecedores "
                            + "set nome = ?,endereco = ?,cnpj = ?,telefone = ? "
                            + "where idfornecedor = ?;");

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setInt(5, fornecedor.getIdfornecedor());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Cadastro de Fornecedor", 0);
        }
    }
}
