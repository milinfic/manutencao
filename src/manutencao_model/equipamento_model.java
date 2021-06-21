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
public class equipamento_model extends cliente_model {

    private int idequipamento;
    private String tipo;
    private String marca;
    private String modelo;
    private String identificacao;

    /*public equipamento_model() {
        super();
    }

    public equipamento_model(int idequipamento, String tipo, String marca, String modelo, String identificacao, String nome, String cpf) {
        super(nome, cpf);
        this.idequipamento = idequipamento;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.identificacao = identificacao;
}*/

    public int getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(int idequipamento) {
        this.idequipamento = idequipamento;
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

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }
    
}
