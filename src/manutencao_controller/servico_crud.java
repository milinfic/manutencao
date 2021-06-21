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
import manutencao_model.equipamento_model;
import manutencao_model.servico_model;

/**
 *
 * @author Paulo
 */
public class servico_crud {

    conexao conectar = new conexao();

    public void inserir(servico_model model) {
        try {
            conectar.conectar();

            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "INSERT INTO servicos (idequipamento, idcliente, dataentrada, descricao)"
                    + "Values (?,?,?,?)");

            stmt.setInt(1, model.getIdequipamento());
            stmt.setInt(2, model.getIdcliente());
            stmt.setString(3, model.getDataentrada());
            stmt.setString(4, model.getDescricao());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Cadastro de Serviço", 0);
        }
    }

    public boolean consultaOS(int os) {
        boolean v = false;
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "select idservico from servicos "
                    + "where idservico = ?");
            stmt.setInt(1, os);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                v = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta OS", 0);
        }
        return v;
    }

    public ArrayList buscaEntrada(int os) {
        ArrayList<equipamento_model> lista = new ArrayList<>();
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "select clientes.cpf, clientes.nome, equipamentos.* "
                    + "from servicos "
                    + "inner join equipamentos "
                    + "on equipamentos.idequipamento = servicos.idequipamento "
                    + "inner join clientes "
                    + "on servicos.idcliente = clientes.idcliente "
                    + "where servicos.idservico = ?");
            stmt.setInt(1, os);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                equipamento_model model = new equipamento_model();
                model.setCpf(rs.getString("cpf"));
                model.setNome(rs.getString("nome"));
                model.setTipo(rs.getString("tipo"));
                model.setMarca(rs.getString("marca"));
                model.setModelo(rs.getString("modelo"));
                model.setIdentificacao(rs.getString("identificacao"));

                lista.add(model);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta dados entrada", 0);
        }
        return lista;
    }

    public ArrayList buscaservico(int os) {
        ArrayList<servico_model> lista = new ArrayList<>();
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "select * from servicos "
                    + "where idservico = ?");

            stmt.setInt(1, os);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                servico_model model = new servico_model();
                model.setDataentrada(rs.getString("dataentrada"));
                model.setDatasaida(rs.getString("datasaida"));
                model.setDescricao(rs.getString("descricao"));
                model.setTotalservico(rs.getDouble("totalservico"));
                model.setValornota(rs.getDouble("valornota"));
                model.setSituacao(rs.getInt("situacao"));

                lista.add(model);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta dados entrada", 0);
        }
        return lista;
    }

    public void alterar(servico_model model) {
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "UPDATE  servicos "
                    + "SET datasaida = ?, totalservico = ?, valornota = ?, descricao = ?, situacao = ?  "
                    + "WHERE idservico = ?");
            
            stmt.setString(1, model.getDatasaida());
            stmt.setDouble(2, model.getTotalservico());
            stmt.setDouble(3, model.getValornota());
            stmt.setString(4, model.getDescricao());
            stmt.setInt(5, model.getSituacao());
            stmt.setInt(6, model.getIdservico());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro..." + e.getMessage(), "Alterar dados entrada", 0);
        }
    } 
    
}
