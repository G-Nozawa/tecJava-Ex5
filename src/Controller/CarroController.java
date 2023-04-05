package Controller;

import Model.Carro;

public class CarroController {
    private Carro[] carros;

    public CarroController(){
        carros = new Carro[100];
    }

    public void cadastrarCarro(Carro carro){
        for(int i = 0; i < carros.length; i++){
            if(carros[i] == null){
                carros[i] = carro;
                break;
            }
        }
    }

    public Carro[] listarCarros(){
        return carros;
    }

    public Carro buscarCarro(String placa){
        for(Carro carro: carros){
            if(carro.getPlaca().equals(placa)){
                return carro;
            }
        }
        return null;
    }

    public void removerCarro(String placa){
        for(int i = 0; i < carros.length; i++){
            if(carros[i].getPlaca().equals(placa)){
                carros[i] = null;
                break;
            }
        }
    }

    public void setCarros(Carro[] carros) {
        this.carros = carros;
    }

    // Cria um livro
    public Carro criarCarro(String placa, String modelo){
        Carro carro = new Carro(placa, modelo);
        return carro;
    }
}
