/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manutencao_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Paulo
 */
public class conexao {

    public Connection conectar;

    static String host = "localhost"; // local onde ele vai conectar, onde está o bd - servidor
    static String database = "manutencao"; // base de dados
    static String usuario = "user";
    static String senha = "senha";
    static String url = "jdbc:mysql://" + host + "/" + database;
    
    
    
    
    public conexao() {
    }

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK!!!");

            conectar = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão OK!!!");

        } catch (ClassNotFoundException exc) {
            System.out.println("Erro no driver " + exc.getMessage());
        } catch (SQLException exc) {
            System.out.println("Erro de conexao =" + exc.getMessage());
        }
    }

    public void Fechar_Conexao() {
        try {
            conectar.close(); // fechando a conexao

        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
