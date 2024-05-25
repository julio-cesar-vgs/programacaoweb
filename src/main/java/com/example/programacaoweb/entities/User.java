package com.example.programacaoweb.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {


    @Serial
    private static final long serialVersionUID = -8250751841604830399L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String password;

    public User() {
    }

    public User(Long id, String nome, String email, String telefone, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.password = password;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return getId().equals(user.getId()) && getNome().equals(user.getNome()) && getEmail().equals(user.getEmail()) && getTelefone().equals(user.getTelefone()) && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getNome().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getTelefone().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
