package entidades;

import java.util.Scanner;

public class Administrador extends Usuario {
    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public boolean exibirMenu() {
        System.out.println("Menu do Administrador em desenvolvimento.");
        return true;
    }
}