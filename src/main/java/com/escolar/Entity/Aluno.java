package com.escolar.Entity;




import javax.persistence.*;


@Entity
public class Aluno{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String nome;
    private Integer idade;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    public Aluno(String nome, Integer idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = new Endereco(endereco.getRua(), endereco.getBairro(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getPais());
    }

    public Aluno() {}

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
