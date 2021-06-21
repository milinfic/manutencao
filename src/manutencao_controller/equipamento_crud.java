package manutencao_controller;

import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import manutencao_model.equipamento_model;
import manutencao_model.servico_model;

public class equipamento_crud {

    conexao conectar = new conexao();

    public int salvar(equipamento_model model) {
        int i = 0;
        try {
            conectar.conectar();

            PreparedStatement stmt = conectar.conectar.prepareStatement(
                    "INSERT INTO equipamentos (tipo, marca, modelo, identificacao)"
                    + "Values (?,?,?,?)");

            stmt.setString(1, model.getTipo());
            stmt.setString(2, model.getMarca());
            stmt.setString(3, model.getModelo());
            stmt.setString(4, model.getIdentificacao());

            stmt.execute();

            PreparedStatement buscaid = conectar.conectar.prepareStatement(
                    "select max(idequipamento) as id from equipamentos ");

            ResultSet rs = buscaid.executeQuery();

            while (rs.next()) {
                i = Integer.parseInt(rs.getString("id"));
            }
            buscaid.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Cadastro de Equipamento", 0);
        }
        return i;
    }    
    

}
