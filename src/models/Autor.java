package models;

import java.time.LocalDate;
import java.util.Date;

public class Autor {
    private int id = 0;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(LocalDate dataNascimento, String nome) {
        this.dataNascimento = dataNascimento;
        this.id = id++;
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
