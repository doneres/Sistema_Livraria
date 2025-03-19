package utils;

import models.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Biblioteca {
    public static void printLivros(ArrayList<Livro> livros){
        if (livros.isEmpty()) {
            System.err.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\nLista de Livros Disponíveis:");
        System.out.println("\n==========================================");
        for (Livro livro: livros){
            String status = livro.isDisponivel() ? "Disponível" : "Indisponível";
            if(livro.isDisponivel()){
                System.out.format("""
                    ID: %d |Status: %s | Título: %s | Autor: %s
                    """,livro.getId(),status,livro.getTitulo(),livro.getAutor().getNome());
            }
        }
        System.out.println("==========================================\n");
    }

    public static void printClientes(ArrayList<Cliente> clientes){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if(clientes.isEmpty()){
            System.err.println("Ops, nenhum cliente cadastrado! Por favor, cadastre.");
        }else{
            System.out.println("\nLista de clientes cadastrados:");
            System.out.println("\n==========================================");
            for(Cliente cliente:clientes){
                System.out.format("""
                    ID: %d |Cliente: %s | E-mail: %s | Nascimento: %s
                    """,cliente.getIdCliente()+1,cliente.getNomeCliente(),cliente.getEmail(),cliente.getDataNascimento().format(formatter));
                System.out.println("==========================================\n");
            }
        }
    }

    public static void getEmprestimos(ArrayList<Emprestimo> emprestimos){

    }

    public static void printEmprestimos(ArrayList<Emprestimo> emprestimos) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Utils.printTitulo("Módulo de empréstimos");

        for (Emprestimo emprestimo : emprestimos) {
            System.out.format("""
               ID: %d Cliente: %s | Livro: %s | Data Empréstimo: %s | Data Devolução: %s
                """,
                    emprestimo.getId()+1,
                    emprestimo.getCliente().getNomeCliente(),
                    emprestimo.getLivro().getTitulo(),
                    formatter.format(emprestimo.getDataEmprestimo()),
                    formatter.format(emprestimo.getDataDevolucao())
            );
        }
        System.out.println();
    }


    public static void devolverEmprestimo(ArrayList<Emprestimo> emprestimos){

    }
}
