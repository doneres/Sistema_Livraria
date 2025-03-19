import  models.*;
import utils.Biblioteca;
import utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();

        while(true){
            System.out.format("""
                    =============================
                    |           MENU            |
                    =============================
                    | 1. Livros disponíveis     |
                    | 2. Cadastro cliente       |
                    | 3. Cadastro Autores       |
                    | 4. Cadastro Livro         |
                    | 5. Consultar clientes     |
                    | 6. Realizar emprestimo    |
                    | 7. Realizar devolução     |
                    | 8. SAIR                   |
                    =============================
                    Escolha:
                    """);

            int opcao = sc.nextInt();
            System.out.println();

            switch (opcao){
                case 1:
                    Biblioteca.printLivros(livros);
                    break;
                case 2:
                    Utils.printTitulo("Cadastro de Clientes");
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nomeCliente = sc.nextLine();

                    System.out.print("Data de nascimento (dd/MM/YYYY): ");
                    String dataNascimentoCliente = sc.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(dataNascimentoCliente,formatter);

                    System.out.print("E-mail: ");
                    String email = sc.nextLine();

                    Cliente c = new Cliente(dataNascimento,email,nomeCliente);
                    clientes.add(c);
                    break;
                case 3:
                    Utils.printTitulo("Cadastro de Autores");
                    sc.nextLine();

                    System.out.print("Nome do autor: ");
                    String nomeAutor = sc.nextLine();


                    System.out.print("Data de nacimento: ");
                    String dataNacimentoAutor = sc.nextLine();
                    LocalDate dataNascimentoA = LocalDate.parse(dataNacimentoAutor,formatter);

                    Autor a = new Autor(dataNascimentoA,nomeAutor);
                    autores.add(a);
                    break;
                case 4:
                    Utils.printTitulo("Cadastro de Livros");

                    if (!autores.isEmpty()) {
                        sc.nextLine();
                        System.out.print("Nome da obra: ");
                        String nomeLivro = sc.nextLine();

                        System.out.println("Escolha o ID de um autor: ");
                        for (Autor autor : autores) {
                            System.out.format("""
                    ID: %d | Autor: %s | Nascimento: %s
                    """, autor.getId() + 1, autor.getNome(), autor.getDataNascimento().format(formatter));
                        }

                        int idAutor = sc.nextInt();
                        sc.nextLine();

                        LocalDate dataAtualizacao = LocalDate.now();

                        System.out.print("Data de criação da obra (dd/MM/yyyy): ");
                        String dataObra = sc.nextLine();
                        LocalDate dataCriacaoObra = LocalDate.parse(dataObra, formatter);

                        boolean statusLivro = true;

                        Livro l = new Livro(autores.get(idAutor - 1), dataAtualizacao, dataCriacaoObra, statusLivro, nomeLivro);
                        livros.add(l);

                        System.out.println("Livro cadastrado com sucesso! Título: " + l.getTitulo());
                    } else {
                        System.out.println("Nenhum autor cadastrado. Cadastre um autor primeiro.");
                    }
                    break;
                case 5:
                    Biblioteca.printClientes(clientes);
                    break;
                case 6:
                    if (!clientes.isEmpty()) {
                        Utils.printTitulo("Modulo de emprestimos");

                        System.out.println("Selecione o ID de um livro: ");
                        Biblioteca.printLivros(livros);
                        int idLivro = sc.nextInt();
                        idLivro -= 1;
                        sc.nextLine();

                        LocalDate dataEmprestimo = LocalDate.now();

                        LocalDate dataDevolucao;
                        do {
                            System.out.print("Data de devolução (dd/MM/yyyy): ");
                            String dataDevolucaoLivro = sc.nextLine();
                            dataDevolucao = LocalDate.parse(dataDevolucaoLivro, formatter);

                            if (dataDevolucao.isBefore(dataEmprestimo)) {
                                System.out.println("Erro: A data de devolução não pode ser anterior à data do empréstimo.");
                            }

                        } while (dataDevolucao == null || dataDevolucao.isBefore(dataEmprestimo));

                        System.out.println("Esolha o ID de um cliente: ");
                        Biblioteca.printClientes(clientes);
                        int idCliente = sc.nextInt();
                        idCliente -= 1;
                        sc.nextLine();

                        Emprestimo e = new Emprestimo(true,dataDevolucao,dataEmprestimo,livros.get(idLivro),clientes.get(idCliente));
                        emprestimos.add(e);

                        livros.get(idLivro).setDisponivel(false);
                        Biblioteca.printEmprestimos(emprestimos);

                    }else{
                        System.err.println("Ops, nenhum cliente cadastro! Por favor, cadastre.");
                    }
                    break;
                case 7:
                    Utils.printTitulo("Modulo de devolução");

                    System.out.println("Selecione o ID de um emprestimo: ");
                    Biblioteca.printEmprestimos(emprestimos);
                    int idEmprestimo = sc.nextInt();
                    idEmprestimo -= 1;
                    sc.nextLine();

                    emprestimos.get(idEmprestimo).getLivro().setDisponivel(true);

                    break;
                case 8:
                    System.out.println("Saindo... Até a próxima! :)");
                    sc.close();
                    return;
                default:
                    System.err.println("Ops, opcao inválida!");
                    break;
            }
        }
    }
}
