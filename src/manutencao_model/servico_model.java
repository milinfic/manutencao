/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manutencao_model;

/**
 *
 * @author Paulo
 */
public class servico_model extends equipamento_model{
    
    private int idservico;
    private int idequipamento;
    private int idcliente;
    private String dataentrada;
    private String datasaida;
    private int situacao;
    private String descricao;
    private double totalservico;
    private double valornota;
    
    /*public servico_model(){ 
    }
    
    public servico_model(int idservico){
        this.idservico = idservico;
    }*/
    
    public int getIdservico() {
        return idservico;
    }

    public void setIdservico(int idservico) {
        this.idservico = idservico;
    }

    public int getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(int idequipamento) {
        this.idequipamento = idequipamento;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(String dataentrada) {
        this.dataentrada = dataentrada;
    }

    public String getDatasaida() {
        return datasaida;
    }    

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public void setDatasaida(String datasaida) {
        this.datasaida = datasaida;
    }    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTotalservico() {
        return totalservico;
    }

    public void setTotalservico(double totalservico) {
        this.totalservico = totalservico;
    }

    public double getValornota() {
        return valornota;
    }

    public void setValornota(double valornota) {
        this.valornota = valornota;
    }   
    
}
