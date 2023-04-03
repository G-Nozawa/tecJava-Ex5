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
        for(int i = 0; i < livros.length; i++){
            if(livros[i] != null){
                System.out.println("Nome: " + livros[i].getNome());
                System.out.println("Descrição: " + livros[i].getDescricao());
                System.out.println("Quantidade: " + livros[i].getQuantidade());
                System.out.println("----------------------------");
            }
        }

        Storage.salvarDados(livros);
    }
}
