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
    private Integer idBiblioteca;

    @Column(name = "nome_biblioteca")
    private String nomeBiblioteca;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "biblioteca")
    private Set<Sessao> sessoes;


    public Biblioteca (){

    }

    public Set<Sessao> GetSessoes (){
        return this.sessoes;
    }

    public void SetSessoes(Set<Sessao> sessoes){
        this.sessoes =  sessoes;
    }

    public Integer GetIdBiblioteca (){
        return this.idBiblioteca;
    }

    public void SetIdBiblioteca (Integer id){
        this.idBiblioteca = id;
    }

    public String GetNomeBiblioteca (){
        return this.nomeBiblioteca;
    }

    public void SetNomeBiblioteca (String nome) {
        this.nomeBiblioteca = nome;
    }

    public String GetCnpj (){
        return this.cnpj;
    }

    public void SetCnpj (String cnpj) {
        this.cnpj = cnpj;
    }

    public String GetEndereco (){
        return this.endereco;
    }

    public void SetEndereco (String endereco) {
        this.endereco = endereco;
    }

    public String GetCidade (){
        return this.cidade;
    }

    public void SetCidade (String cidade) {
        this.cidade = cidade;
    }

    public Integer GetNumero (){
        return this.numero;
    }

    public void SetNumero (Integer numero) {
        this.numero = numero;
    }

    public String GetEstado (){
        return this.estado;
    }

    public void SetEstado (String estado) {
        this.estado = estado;
    }

    
}
