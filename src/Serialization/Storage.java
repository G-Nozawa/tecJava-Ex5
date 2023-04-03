package Serialization;

import Model.Livro;

import java.io.*;

public class Storage {
    public static Livro[] livros;

    public Storage(){
        livros = new Livro[10];
    }

    public static void salvarDados(Livro[] livros){
        Storage.livros = livros;

        try {
            FileOutputStream fileOutLivros = new FileOutputStream("livros.ser");
            ObjectOutputStream outLivros = new ObjectOutputStream(fileOutLivros);
            outLivros.writeObject(Storage.livros);
            outLivros.close(); // TODO Dá para usar try with resources
            fileOutLivros.close();

            System.out.println("Dados salvos com sucesso!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Livro[] carregarDados(){
        FileInputStream fileInLivros = null;
        try {
            fileInLivros = new FileInputStream("livros.ser");
            ObjectInputStream inLivros = new ObjectInputStream(fileInLivros);
            Storage.livros = (Livro[]) inLivros.readObject();
            inLivros.close();
            fileInLivros.close();

            System.out.println("Dados carregados com sucesso!");

            return Storage.livros;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
