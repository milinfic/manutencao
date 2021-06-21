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
public class fornecedor_model {
    
    private int idfornecedor;
    private String nome;
    private String endereco;
    private String cnpj;
    private String telefone;
    
    public fornecedor_model(){}
    
    public fornecedor_model(int idfornecedor, String nome){
        this.idfornecedor = idfornecedor;
        this.nome = nome;
    }
    
    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
        
}
