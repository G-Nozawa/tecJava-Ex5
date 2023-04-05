package Serialization;

import Model.Livro;
import Model.Carro;

import java.io.*;

public class Storage {
    public static Livro[] livros;
    public static Carro[] carros;
    
    public Storage(){

    }

    public static void salvarDadosLivros(Livro[] livros){
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

    public static Livro[] carregarDadosLivros(){
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
            return new Livro[100];
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void salvarDadosCarros(Carro[] carros){
        Storage.carros = carros;

        try {
            FileOutputStream fileOutCarros = new FileOutputStream("carros.ser");
            ObjectOutputStream outCarros = new ObjectOutputStream(fileOutCarros);
            outCarros.writeObject(Storage.carros);
            outCarros.close(); // TODO Dá para usar try with resources
            fileOutCarros.close();

            System.out.println("Dados salvos com sucesso!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Carro[] carregarDadosCarros(){
        FileInputStream fileInCarros = null;
        try {
            fileInCarros = new FileInputStream("carros.ser");
            ObjectInputStream inCarros = new ObjectInputStream(fileInCarros);
            Storage.carros = (Carro[]) inCarros.readObject();
            inCarros.close();
            fileInCarros.close();

            System.out.println("Dados carregados com sucesso!");

            return Storage.carros;
        } catch (FileNotFoundException e) {
            return new Carro[100];
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
