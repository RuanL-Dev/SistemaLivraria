import jdk.jshell.Snippet;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SistemaEmprestimo {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivrosExemplo();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nDeseja ver os livros? (s/n) ou 0 para sair");
                String loopInteracao = scanner.nextLine().trim().toLowerCase();

                if (loopInteracao.equals("0")) {
                    System.out.println("Saindo...Até mais!");
                    break;
                } else if (loopInteracao.startsWith("s") || loopInteracao.startsWith("y")) {
                    mostrarLivros(biblioteca);
                } else if (loopInteracao.startsWith("n")) {
                    System.out.println("OK! Quem sabe na próxima :)");
                    continue;

                } else
                    System.out.println("Opção inválida. Digite s, n ou 0");

                System.out.println("\n Deseja escolher algum livro? (s/n) - ou 0 para sair");
                String loopEscolha = scanner.nextLine().trim().toLowerCase();

                if (loopEscolha.equals("0")) {
                    System.out.println("Saindo...Até mais!");
                    break;
                } else if (loopEscolha.startsWith("s") || loopEscolha.startsWith("y")) {
                    mostrarLivrosID(biblioteca, scanner);
                } else if (loopEscolha.startsWith("n")) {
                    System.out.println("OK! Quem sabe na próxima :)");
                    continue;

                } else
                    System.out.println("Opção inválida. Digite s, n ou 0");

            }

        }
    }

    private static void mostrarLivrosID(Biblioteca biblioteca, Scanner scanner) {
        List<Livro> livrosID = biblioteca.getLivros();
        if (livrosID.isEmpty()) {
            System.out.println("Nenhum livro encontrado");
            return;
        }

        while (true) {
            System.out.println("Digite o ID do livro que deseja escolher ou 0 para sair: ");
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Digite o ID do livro que deseja escolher ou 0 para sair: ");
            } else if (entrada.equals("0")) {
                System.out.println("Saindo...Até mais!");
                break;
            }

            int id;
            try {
                id = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Digite um número inteiro.");
                continue;
            }

            Livro escolhaUsuario = biblioteca.buscarLivroPorID(id);
            if (escolhaUsuario == null) {
                System.out.println("ID não encontrado. Tente novamente.");
                continue;
            }


            boolean autor = escolhaUsuario.disponivel;
            if (autor) {
                System.out.printf("Você escolheu: [%d] %s - Autor: %s\n", escolhaUsuario.id, escolhaUsuario.titulo, escolhaUsuario.autor.nome);
                registroEmprestimo(biblioteca, id, scanner);
            } else
                System.out.println("Esse livro não está disponível no momento.");
            break;

        }

    }

    private static void registroEmprestimo(Biblioteca biblioteca, int id, Scanner scanner) {
        System.out.println("Deseja o empréstimo desse livro? (s/n) ou 0 para sair");
        String entradaRegistroEmprestimo = scanner.nextLine().trim().toLowerCase();

            if (entradaRegistroEmprestimo.isEmpty()) {
                System.out.println("Opção inválida. Digite s, n ou 0");
            } else if (entradaRegistroEmprestimo.equals("n")) {
                return;
            } else if (entradaRegistroEmprestimo.equals("0")) {
                System.out.println("Saindo...Até mais!");
            } else if (entradaRegistroEmprestimo.startsWith("s") || entradaRegistroEmprestimo.startsWith("y")) {
                Livro livroEscolhido = biblioteca.buscarLivroPorID(id);
                System.out.println("Digite seu nome para registro do empréstimo: ");
                String entradaNomeUsuario = scanner.nextLine().trim();
                System.out.printf("%s %s%s%s\n", "Muito obrigado por escolher o livro", livroEscolhido.titulo, " - Sr(a).", entradaNomeUsuario);
                boolean registroEmprestimo = biblioteca.registrarEmprestimo(id, entradaNomeUsuario, LocalDate.now());
                if (registroEmprestimo) {
                    System.out.println("Empréstimo registrado com sucesso.");
                } else if (!registroEmprestimo) {
                    System.out.println("Ocorreu um erro no regitro, por favor faça novamente");
                }
            } else
                System.out.println("Opção inválida. Digite s, n ou 0");

    }

    private static void mostrarLivros(Biblioteca biblioteca) {
        List<Livro> livros = biblioteca.getLivros();
        if (livros == null || livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }

        for (Livro livro : livros) {
            String autorNome = (livro.autor != null ? livro.autor.nome : "(sem autor)");
            String status = (livro.disponivel ? "Disponível" : "Indisponível");
            if (status.equals("Disponível")) {
                System.out.println("\n=== Lista de Livros disponíveis ===\n");
                System.out.printf("%-3s | %-20s | %-15s%n", "ID", "Título", "Autor");
                System.out.printf("%03d | %-20s | %-15s%n", livro.id, livro.titulo, autorNome);
                System.out.println(tracos());
            }
        }

    }

    private static String tracos() {
        String repeated = new String(new char[50]).replace("\0", "-");
        return repeated + "\n";
    }

}
