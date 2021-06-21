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
public class produto_model extends fornecedor_model {

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /*public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }*/

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    private int idproduto;
    private String datacompra;
    private String tipo;
    private String marca;
    private String modelo;
    //private String cor;
    private String descricaoproduto;
    private int quantidade;
    private double valor;

    public produto_model() {
        super(); 
    }
    
    public produto_model(int idfornecedor, String nome, int idproduto, String datacompra, String tipo, String marca, 
            String modelo, String descricao, int quantidade, double valor) {
        super(idfornecedor, nome); // chamando o construtor da super-classe e passando os dados específicos da mãe(superclasse)
    	this.idproduto = idproduto;
        this.datacompra = datacompra;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.descricaoproduto = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    

}
