package br.gov.sp.fatec.bibliotecaOnline.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManytoOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer IdUsuario;

    @Column(name = "nome")
    private String Nome;

    @Column(name = "email", nullable = false)
    private String Email;

    @Column(name = "documento")
    private String Documento;

    @Column(name = "senha", nullable = false)
    private String Senha;

    @ManytoOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "fk_permissoes")
    private Permissoes Permissao;

    public Usuario() {

    }

    public Permissoes GetPermissao (){
        return this.Permissao;
    }

    public void SetPermissao(Permissoes permissao){
        this.Permissao =  permissao;
    }

    public Integer GetIdUsuario() {
        return this.IdUsuario;
    }

    public void SetIdUsuario(Integer Id) {
        this.IdUsuario = Id;
    }

    public String GetNome() {
        return this.Nome;
    }

    public void SetNome(String Nome) {
        this.Nome = Nome;
    }

    public String GetEmail() {
        return this.Email;
    }

    public void SetEmail(String Email) {
        this.Email = Email;
    }

    public String GetDocumento() {
        return this.Documento;
    }

    public void SetDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String GetSenha() {
        return this.Senha;
    }

    public void SetSenha(String Senha) {
        this.Senha = Senha;
    }
}