package br.gov.sp.fatec.bibliotecaOnline.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biblioteca")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class, View.Biblioteca.class })
    private Integer idBiblioteca;

    @Column(name = "nome_biblioteca")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class, View.Biblioteca.class })
    private String nomeBiblioteca;

    @Column(name = "cnpj")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class, View.Biblioteca.class })
    private String cnpj;

    @Column(name = "endereco")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class, View.Biblioteca.class })
    private String endereco;

    @Column(name = "numero")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class, View.Biblioteca.class })
    private Integer numero;

    @Column(name = "cidade")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class, View.Biblioteca.class })
    private String cidade;

    @Column(name = "estado")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class, View.Biblioteca.class })
    private String estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "biblioteca")
    @JsonView(View.Biblioteca.class)
    private Set<Sessao> sessoes;


    public Biblioteca (){

    }


    public Integer getIdBiblioteca() {
        return idBiblioteca;
    }


    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }


    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }


    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }


    public String getCnpj() {
        return cnpj;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public Integer getNumero() {
        return numero;
    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Set<Sessao> getSessoes() {
        return sessoes;
    }


    public void setSessoes(Set<Sessao> sessoes) {
        this.sessoes = sessoes;
    }
    
}
