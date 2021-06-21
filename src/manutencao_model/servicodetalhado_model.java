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
public class servicodetalhado_model extends servico_model{

    private int idservicodetalhado;
    //private int idservico;
    private int idproduto;
    private double valortotal;
    private String descricaoitem;
    private int quantidadade;
    
    /*public servicodetalhado_model(){ 
        super();
    }
    
    public servicodetalhado_model(int idservicodetalhado, int idservico,int idproduto, double valortotal,String descricao, int quantidadade){
        super(idservico);        
        this.idservicodetalhado = idservicodetalhado;
        this.idproduto = idproduto;
        this.valortotal = valortotal;
        this.descricao = descricao;
        this.quantidadade = quantidadade;
    }*/
    
    public int getIdservicodetalhado() {
        return idservicodetalhado;
    }

    public void setIdservicodetalhado(int idservicodetalhado) {
        this.idservicodetalhado = idservicodetalhado;
    }

    /*public int getIdservico() {
        return idservico;
    }

    public void setIdservico(int idservico) {
        this.idservico = idservico;
    }*/

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public String getDescricaoitem() {
        return descricaoitem;
    }

    public void setDescricaoitem(String descricao) {
        this.descricaoitem = descricao;
    }

    public int getQuantidadade() {
        return quantidadade;
    }

    public void setQuantidadade(int quantidadade) {
        this.quantidadade = quantidadade;
    }    
    
}
