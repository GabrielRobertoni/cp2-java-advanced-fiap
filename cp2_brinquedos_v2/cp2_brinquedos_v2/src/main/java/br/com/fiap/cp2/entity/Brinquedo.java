package br.com.fiap.cp2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TDS_TB_BRINQUEDOS")
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 50)
    private String classificacao;

    @Column(nullable = false, length = 50)
    private String tamanho;

    @Column(nullable = false)
    private Double preco;

    // Construtor padrão
    public Brinquedo() {
    }

    // Construtor completo
    public Brinquedo(Long id, String nome, String tipo, String classificacao, String tamanho, Double preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Brinquedo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", classificacao='" + classificacao + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", preco=" + preco +
                '}';
    }
}
