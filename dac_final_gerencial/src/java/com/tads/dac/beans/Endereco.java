package com.tads.dac.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")

public class Endereco {
    private int id;
    private String rua;
    private int numero;
    private String complemento;
    private Cidade cidade;
    private Estado estado;

    @Id
    @Column(name = "id_endereco", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }
    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else throw new RuntimeException(
            "Erro: Id do Endereço deve ser maior do que 0!");
    }

    @Column(name = "rua_endereco", length = 100, nullable = false)
    public String getRua() { return rua; }
    public void setRua(String rua) {
        if (rua != null)
            this.rua = rua;
        else throw new RuntimeException(
            "Erro: Rua do endereço não pode estar vazia!");
    }

    @Column(name = "numero_endereco", nullable = false)
    public int getNumero() { return numero; }
    public void setNumero(int numero) {
        if (numero > 0)
            this.numero = numero;
        else throw new RuntimeException(
            "Erro: Número do Endereço deve ser maior do que 0!");
    }

    @Column(name = "complemento_endereco", length = 50, nullable = true)
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cidade")
    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) {
        if (cidade != null)
            this.cidade = cidade;
        else throw new RuntimeException(
            "Erro: Cidade do Endereço não pode ser nula!");
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) {
        if (estado != null)    
            this.estado = estado;
        else throw new RuntimeException(
            "Erro: Estado do Endereço não pode ser nulo!");
    }
}
