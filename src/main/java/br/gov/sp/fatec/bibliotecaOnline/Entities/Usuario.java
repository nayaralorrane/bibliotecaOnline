package br.gov.sp.fatec.bibliotecaOnline.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nome")
    @JsonView(View.Usuario.class)
    private String nome;

    @Column(name = "email", nullable = false)
    @JsonView(View.Usuario.class)
    private String email;

    @Column(name = "documento")
    @JsonView(View.Usuario.class)
    private String documento;

    @Column(name = "senha", nullable = false)
    @JsonView(View.Usuario.class)
    private String senha;

    @Column(name = "tentativa", nullable = true)
    private Integer tentativa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(View.Usuario.class)
    @JoinColumn(name= "id_permissoes")
    private Permissoes permissao;

    public Usuario() {
        
    }

    public Usuario(String nome, String email, String documento, String senha) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.senha = senha;
        this.tentativa = 0;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

     public Integer getTentativa() {
        return tentativa;
    }

    public void setTentativa(Integer tentativa) {
        this.tentativa = tentativa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Permissoes getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissoes permissao) {
        this.permissao = permissao;
    }

}