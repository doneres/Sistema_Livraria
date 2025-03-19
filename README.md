# Sistema de Livraria Simples

## Descrição

Este projeto implementa um sistema de gerenciamento de livraria simples, permitindo o cadastro e a consulta de livros, autores e clientes, além de gerenciar empréstimos de livros. O sistema foi desenvolvido como um desafio proposto no curso de Java da [Rocketseat](https://www.rocketseat.com.br/formacao/java), com o objetivo de colocar em prática os conceitos fundamentais de programação orientada a objetos (POO) e manipulação de dados em Java.

## Funcionalidades

- **Cadastro de Livros**: Permite cadastrar novos livros, associando-os a autores e informando a data de criação.
- **Cadastro de Autores**: Permite o cadastro de autores, incluindo nome e data de nascimento.
- **Cadastro de Clientes**: Permite cadastrar novos clientes, informando nome, e-mail e data de nascimento.
- **Empréstimos de Livros**: Permite realizar o empréstimo de livros para clientes, registrando a data de devolução.
- **Devolução de Livros**: Permite registrar a devolução de livros e atualizar a disponibilidade no sistema.
- **Consultas**: Permite consultar os livros disponíveis, os clientes cadastrados e os empréstimos realizados.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para implementar o sistema.
- **Scanner**: Para capturar entradas do usuário no console.
- **Java Time API**: Para manipulação de datas e formatação de data (uso de `LocalDate` e `DateTimeFormatter`).
- **Estruturas de Dados**: O sistema utiliza `ArrayList` para armazenar livros, autores, clientes e empréstimos.

## Estrutura do Código

- **Main**: Classe principal onde o programa começa e onde o menu interativo é apresentado ao usuário.
- **Biblioteca**: Contém métodos auxiliares para exibição de informações no console, como listas de livros e clientes.
- **Utils**: Contém métodos utilitários, como a exibição de títulos formatados.
- **Models**: Contém as classes de modelo, incluindo `Livro`, `Autor`, `Cliente` e `Emprestimo`, que representam os dados principais do sistema.

## Como Rodar

1. Clone o repositório em sua máquina local:
    ```bash
    git clone https://github.com/doneres/sistema-livraria.git
    ```
2. Abra o projeto em sua IDE de preferência.
3. Compile e execute a classe `Main.java`.
4. Siga as instruções no console para cadastrar livros, autores, clientes e realizar empréstimos.

## Desafio

Este projeto foi desenvolvido como parte de um **desafio de sistema de livraria simples** proposto no curso de **Java da Rocketseat**, com o objetivo de praticar conceitos como manipulação de objetos, datas e listas no contexto de uma aplicação simples.

## Contribuindo

Se você encontrar algum problema ou tiver uma sugestão de melhoria, sinta-se à vontade para abrir uma issue ou enviar um pull request!

---

### **Licença**

Distribuído sob a licença MIT. Veja a [LICENÇA](LICENSE) para mais informações.
