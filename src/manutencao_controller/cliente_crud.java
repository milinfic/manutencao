/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manutencao_controller;

import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import manutencao_model.cliente_model;

public class cliente_crud {

    conexao conectar = new conexao();

    public void insert(cliente_model cliente) {

        try {

            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "insert into clientes (nome,telefone,celular,cpf,rg,datanascimento,email,sexo,endereco)"
                    + "values(?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCelular());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getRg());
            stmt.setString(6, cliente.getDatanascimento());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getSexo());
            stmt.setString(9, cliente.getEndereco());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Cadastro de Cliente", 0);
        }

    }

    public boolean buscaCPF(String CPF) {
        boolean v = false;

        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "select * from clientes "
                    + "where cpf = ?");

            stmt.setString(1, CPF);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                v = true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta de Clientes", 0);
        }
        return v;
    }

    public ArrayList alterar(String CPF) {

        ArrayList<cliente_model> busca = new ArrayList<>();
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "select * from clientes "
                    + "where cpf = ?");

            stmt.setString(1, CPF);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                cliente_model cliente = new cliente_model();

                cliente.setIdcliente(Integer.parseInt(rs.getString("idcliente")));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDatanascimento(rs.getString("datanascimento"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEndereco(rs.getString("endereco"));

                busca.add(cliente);
            }
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta de Clientes", 0);
        }
        return busca;
    }

    public void update(cliente_model cliente) {

        try {

            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "update clientes\n"
                    + "set nome = ?,telefone = ?,celular = ?,"
                    + "cpf = ?,rg = ?,datanascimento = ?,"
                    + "email = ?,sexo = ?,endereco = ? "
                    + "where idcliente = ?;");

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCelular());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getRg());
            stmt.setString(6, cliente.getDatanascimento());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getSexo());
            stmt.setString(9, cliente.getEndereco());
            stmt.setInt(10, cliente.getIdcliente());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Cadastro de Cliente", 0);
        }

    }

}
