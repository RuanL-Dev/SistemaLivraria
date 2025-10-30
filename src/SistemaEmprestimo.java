import jdk.jshell.Snippet;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SistemaEmprestimo {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivrosExemplo();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nDeseja ver os livros? (s/n) - ou 0 para sair");
                String loopInteracao = scanner.nextLine().trim().toLowerCase();

                if(loopInteracao.equals("0")) {
                    System.out.println("Saindo...Até mais!");
                    break;
                } else if (loopInteracao.startsWith("s") || loopInteracao.startsWith("y")) {
                    mostrarLivros(biblioteca);
                    continue;
                } else if (loopInteracao.startsWith("n")) {
                    System.out.println("OK! Quem sabe na próxima :)");
                    continue;

                } else
                    System.out.println("Opção inválida. Digite s, n ou 0");
            }

        }
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
