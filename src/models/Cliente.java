package models;

import java.time.LocalDate;

public class Cliente {
    private static int contador = 0;
    private int idCliente;
    private String nomeCliente;
    private LocalDate dataNascimento;
    private String email;

    public Cliente(LocalDate dataNascimento, String email, String nomeCliente) {
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.idCliente = contador++;
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
