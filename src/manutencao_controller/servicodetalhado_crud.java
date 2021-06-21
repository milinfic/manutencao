package manutencao_controller;

import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import manutencao_model.servicodetalhado_model;

public class servicodetalhado_crud {

    conexao conectar = new conexao();

    public void inserir(servicodetalhado_model model) {
        try {
            conectar.conectar();

            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "insert into servicodetalhado (idservico, idproduto, valortotal, descricao, quantidade) "
                    + "Values (?,?,?,?,?)");
            stmt.setInt(1, model.getIdservico());
            stmt.setInt(2, model.getIdproduto());
            stmt.setDouble(3, model.getValortotal());
            stmt.setString(4, model.getDescricaoitem());
            stmt.setInt(5, model.getQuantidadade());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO CADASTRO DE PRODUTO" + e.getMessage(), "Cadastro de PRODUTO", 0);
        }
    }

    public ArrayList buscaitem(int os) {
        ArrayList<servicodetalhado_model> lista = new ArrayList<>();
        try {
            conectar.conectar();

            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "select idservicodetalhado, idproduto, quantidade, descricao, valortotal from servicodetalhado "
                    + "where idservico = ?");

            stmt.setInt(1, os);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                servicodetalhado_model model = new servicodetalhado_model();
                model.setIdservicodetalhado(rs.getInt("idservicodetalhado"));
                model.setIdproduto(rs.getInt("idproduto"));
                model.setQuantidadade(rs.getInt("quantidade"));
                model.setDescricaoitem(rs.getString("descricao"));
                model.setValortotal(rs.getDouble("valortotal"));

                lista.add(model);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO TABELA DE ITENS CADASTRADOS" + e.getMessage(), "Cadastro de PRODUTO", 0);
        }
        return lista;
    }
    
    public void excluir(int id){
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                "DELETE FROM servicodetalhado WHERE idservicodetalhado = ?");
            
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Item deletado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Excluir Item", 0);
        }
    }

}
