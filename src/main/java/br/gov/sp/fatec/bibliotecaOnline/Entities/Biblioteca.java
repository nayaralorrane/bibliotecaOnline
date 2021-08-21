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

@Entity
@Table(name = "biblioteca")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biblioteca")
    private Integer IdBiblioteca;

    @Column(name = "nome_biblioteca")
    private String NomeBiblioteca;

    @Column(name = "cnpj")
    private String Cnpj;

    @Column(name = "endereco")
    private String Endereco;

    @Column(name = "numero")
    private Integer Numero;

    @Column(name = "cidade")
    private String Cidade;

    @Column(name = "estado")
    private String Estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Biblioteca")
    private Set<Sessao> Sessoes;


    public Biblioteca (){

    }

    public Set<Sessao> GetSessoes (){
        return this.Sessoes;
    }

    public void SetSessoes(Set<Sessao> sessoes){
        this.Sessoes =  sessoes;
    }

    public Integer GetIdBiblioteca (){
        return this.IdBiblioteca;
    }

    public void SetIdBiblioteca (Integer id){
        this.IdBiblioteca = id;
    }

    public String GetNomeBiblioteca (){
        return this.NomeBiblioteca;
    }

    public void SetNomeBiblioteca (String nome) {
        this.NomeBiblioteca = nome;
    }

    public String GetCnpj (){
        return this.Cnpj;
    }

    public void SetCnpj (String cnpj) {
        this.Cnpj = cnpj;
    }

    public String GetEndereco (){
        return this.Endereco;
    }

    public void SetEndereco (String endereco) {
        this.Endereco = endereco;
    }

    public String GetCidade (){
        return this.Cidade;
    }

    public void SetCidade (String cidade) {
        this.Cidade = cidade;
    }

    public Integer GetNumero (){
        return this.Numero;
    }

    public void SetNumero (Integer numero) {
        this.Numero = numero;
    }

    public String GetEstado (){
        return this.Estado;
    }

    public void SetEstado (String estado) {
        this.Estado = estado;
    }

    
}
