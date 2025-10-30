import java.util.Locale;
import java.util.Scanner;

public class SistemaEmprestimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        String inicio = verListaLivros(scanner);

    }

    public static String verListaLivros(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Deseja ver a lista de livros disponíveis?");
                String entrada = scanner.nextLine().trim();

                if (entrada.equalsIgnoreCase("sim")) {
                    return entrada;

                } else if (entrada.equalsIgnoreCase("não")) {
                    System.out.println("Ok, Muito obrigado por sua visita!");
                }
            }catch (Exception ex) {
                System.err.println("Erro inesperado " + ex.getMessage());
            }
            }
        }
    }
