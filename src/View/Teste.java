package View;

import Controller.LivroController;
import Model.Livro;
import Serialization.Storage;

public class Teste {
    public static void main(String[] args) {
        LivroController livroController = new LivroController();
//        livroController.setLivros(Storage.carregarDados());

        // Cria um livro
        Livro livro = livroController.criarLivro("Livro 1", "Descrição do livro 1", 10);

        // Adiciona o livro no banco de dados
        livroController.cadastrarLivro(livro);

        // Lista todos os livros cadastrados
        Livro[] livros = livroController.listarLivros();
        for (Livro value : livros) {
            if (value != null) {
                System.out.println("Nome: " + value.getNome());
                System.out.println("Descrição: " + value.getDescricao());
                System.out.println("Quantidade: " + value.getQuantidade());
                System.out.println("----------------------------");
            }
        }

        Storage.salvarDados(livros);
    }
}
