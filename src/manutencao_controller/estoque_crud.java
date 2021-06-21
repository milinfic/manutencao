/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manutencao_controller;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import manutencao_model.produto_model;

/**
 *
 * @author Paulo
 */
public class estoque_crud {

    conexao conectar = new conexao();

    public void inserir(produto_model produto) {
        try {
            conectar.conectar();

            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "insert into produto (idfornecedor,datacompra,tipo,marca,modelo,descricao,quantidade,valor) "
                    + "values (?,?,?,?,?,?,?,?)");

            stmt.setInt(1, produto.getIdfornecedor());
            stmt.setString(2, produto.getDatacompra());
            stmt.setString(3, produto.getTipo());
            stmt.setString(4, produto.getMarca());
            stmt.setString(5, produto.getModelo());
            stmt.setString(6, produto.getDescricaoproduto());
            stmt.setInt(7, produto.getQuantidade());
            stmt.setDouble(8, produto.getValor());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso.", "Cadastro de Estoque", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Cadastro de Estoque", 0);
        }
    }

    public ArrayList buscarestoque() {
        ArrayList<produto_model> lista = new ArrayList<>();

        try {
            conectar.conectar();

            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "SELECT produto.*, fornecedores.nome "
                    + "FROM produto "
                    + "INNER JOIN fornecedores "
                    + "ON produto.idfornecedor = fornecedores.idfornecedor");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto_model model = new produto_model();
                model.setIdproduto(Integer.parseInt(rs.getString("idproduto")));
                model.setNome(rs.getString("nome"));                
                model.setDatacompra(rs.getString("datacompra"));
                model.setTipo(rs.getString("tipo"));
                model.setModelo(rs.getString("modelo"));                
                model.setMarca(rs.getString("marca"));                
                //model.setCor(rs.getString("cor"));
                model.setDescricaoproduto(rs.getString("descricao"));
                model.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                model.setValor(Double.parseDouble(rs.getString("valor")));

                lista.add(model);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO BUSCAR TABELA ESTOQUE" + e.getMessage(), "Cadastro de Estoque", 0);
        }

        return lista;
    }

    public void excluir(int id) {
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "DELETE FROM produto WHERE idproduto = ?");

            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Item deletado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Excluir PRODUTO", 0);
        }
    }

    public void alterar(produto_model model) {
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "UPDATE produto "
                    + "SET idfornecedor = ?, datacompra = ?, tipo = ?, "
                    + "marca = ?, modelo = ?, descricao = ?, quantidade = ?, "
                    + "valor = ? "
                    + "WHERE idproduto = ? ");
            
            stmt.setInt(1, model.getIdfornecedor());
            stmt.setString(2, model.getDatacompra());
            stmt.setString(3, model.getTipo());
            stmt.setString(4, model.getMarca());
            stmt.setString(5, model.getModelo());
            stmt.setString(6, model.getDescricaoproduto());
            stmt.setInt(7, model.getQuantidade());
            stmt.setDouble(8, model.getValor());
            stmt.setInt(9, model.getIdproduto());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Atualizar PRODUTO", 0);
        }

    }

}
