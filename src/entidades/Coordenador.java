package entidades;

import java.util.Scanner;

public class Coordenador extends Usuario {
    public Coordenador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public boolean exibirMenu() {
        System.out.println("Menu do Coordenador em desenvolvimento.");
        return true; // continua logado
    }
}