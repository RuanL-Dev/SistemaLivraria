import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List <Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    public void adicionarLivrosExemplo() {
        Livro livro1 = new Livro();
        livro1.id = 1;
        livro1.titulo = "Congregação";
        livro1.autor = "Miriam";
        livro1.disponivel = true;
        livro1.dataCadastro = LocalDate.of(2022,11,5);
        livro1.dataAtualizacao = LocalDate.of(2024,10,1);
        this.livros.add(livro1);

        Livro livro2 = new Livro();
        livro2.id = 2;
        livro2.titulo = "Reunião";
        livro2.autor = "Robson";
        livro2.disponivel = true;
        livro2.dataCadastro = LocalDate.now();
        livro2.dataAtualizacao = LocalDate.now();
        this.livros.add(livro2);

        Livro livro3 = new Livro();
        livro3.id = 3;
        livro3.titulo = "Campo";
        livro3.autor = "Rosa";
        livro3.disponivel = true;
        livro3.dataCadastro = LocalDate.now();
        livro3.dataAtualizacao = LocalDate.now();
        this.livros.add(livro3);
    }


}
