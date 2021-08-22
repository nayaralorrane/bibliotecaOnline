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

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "documento")
    private String documento;

    @Column(name = "senha", nullable = false)
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_permissoes")
    private Permissoes permissao;

    public Usuario() {
        
    }

    public Usuario(String nome, String email, String documento, String senha) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.senha = senha;
    }

    public Permissoes GetPermissao (){
        return this.permissao;
    }

    public void SetPermissao(Permissoes permissao){
        this.permissao =  permissao;
    }

    public Integer GetIdUsuario() {
        return this.idUsuario;
    }

    public void SetIdUsuario(Integer Id) {
        this.idUsuario = Id;
    }

    public String GetNome() {
        return this.nome;
    }

    public void SetNome(String Nome) {
        this.nome = Nome;
    }

    public String GetEmail() {
        return this.email;
    }

    public void SetEmail(String Email) {
        this.email = Email;
    }

    public String GetDocumento() {
        return this.documento;
    }

    public void SetDocumento(String Documento) {
        this.documento = Documento;
    }

    public String GetSenha() {
        return this.senha;
    }

    public void SetSenha(String Senha) {
        this.senha = Senha;
    }
}