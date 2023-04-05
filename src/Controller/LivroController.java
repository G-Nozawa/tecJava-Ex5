package Controller;

import Model.Livro;

public class LivroController {
    private Livro[] livros;

    public LivroController(){
        livros = new Livro[100];
    }

    public void cadastrarLivro(Livro livro){
        for(int i = 0; i < livros.length; i++){
            if(livros[i] == null){
                livros[i] = livro;
                break;
            }
        }
    }

    public Livro[] listarLivros(){
        return livros;
    }

    public Livro buscarLivro(String nome){
        for(int i = 0; i < livros.length; i++){
            if(livros[i] != null && livros[i].getNome().equals(nome)){
                return livros[i];
            }
        }
        return null;
    }

    public void removerLivro(String nome){
        for(int i = 0; i < livros.length; i++){
            if(livros[i] != null && livros[i].getNome().equals(nome)){
                livros[i] = null;
                break;
            }
        }
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    // Cria um livro
    public Livro criarLivro(String nome, String descricao, int quantidade){
        Livro livro = new Livro(nome, descricao, quantidade);
        return livro;
    }
}
