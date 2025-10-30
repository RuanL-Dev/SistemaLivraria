import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    public void adicionarLivrosExemplo() {

        Autor autor1 = new Autor();
        autor1.id = 1;
        autor1.nome = "Miriam";
        autor1.dataNascimento = LocalDate.of(1969, 12, 21);
        this.autores.add(autor1);

        Livro livro1 = new Livro();
        livro1.id = 1;
        livro1.titulo = "Congregação";
        livro1.autor = autor1;
        livro1.disponivel = false;
        livro1.dataCadastro = LocalDate.of(2022, 11, 5);
        livro1.dataAtualizacao = LocalDate.of(2024, 10, 1);
        this.livros.add(livro1);

        Autor autor2 = new Autor();
        autor2.id = 2;
        autor2.nome = "Robson";
        autor2.dataNascimento = LocalDate.of(1966, 12, 22);
        this.autores.add(autor2);

        Livro livro2 = new Livro();
        livro2.id = 2;
        livro2.titulo = "Reunião";
        livro2.autor = autor2;
        livro2.disponivel = true;
        livro2.dataCadastro = LocalDate.now();
        livro2.dataAtualizacao = LocalDate.now();
        this.livros.add(livro2);

        Autor autor3 = new Autor();
        autor3.id = 3;
        autor3.nome = "Rosa";
        autor3.dataNascimento = LocalDate.of(1950, 5, 4);
        this.autores.add(autor3);

        Livro livro3 = new Livro();
        livro3.id = 3;
        livro3.titulo = "Campo";
        livro3.autor = autor3;
        livro3.disponivel = true;
        livro3.dataCadastro = LocalDate.now();
        livro3.dataAtualizacao = LocalDate.now();
        this.livros.add(livro3);
    }

    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }

}
