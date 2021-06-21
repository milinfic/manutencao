package manutencao_controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import manutencao_model.equipamento_model;
import manutencao_model.servico_model;

public class consulta_crud {

    conexao conectar = new conexao();

    public ArrayList consultaequipcliente(int situacao) {
        ArrayList<servico_model> lista = new ArrayList<>();
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "select clientes.nome, equipamentos.identificacao, servicos.* "
                    + "from servicos "
                    + "inner join equipamentos "
                    + "on equipamentos.idequipamento = servicos.idequipamento "
                    + "inner join clientes "
                    + "on servicos.idcliente = clientes.idcliente "
                    + "where servicos.situacao = ?");
            stmt.setInt(1, situacao);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                servico_model model = new servico_model();
                model.setIdservico(rs.getInt("idservico"));                
                model.setDataentrada(rs.getString("dataentrada"));
                model.setNome(rs.getString("nome"));
                model.setIdentificacao(rs.getString("identificacao"));                  
                model.setSituacao(rs.getInt("situacao"));
                model.setDatasaida(rs.getString("datasaida"));
                model.setDescricao(rs.getString("descricao"));
                model.setTotalservico(rs.getDouble("totalservico"));
                model.setValornota(rs.getDouble("valornota"));

                lista.add(model);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Consulta dados entrada", 0);
        }
        return lista;
    }

    /*public ArrayList consultaservico(int situacao) {
        ArrayList<servico_model> lista = new ArrayList<>();
        try {
            conectar.conectar();
            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "select * from servicos "
                    + "where idservico = ?");

            stmt.setInt(1, situacao);
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
    }*/

}
