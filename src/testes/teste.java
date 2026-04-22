package testes;
import entidades.*;
//import enums.*;

public class teste {
	public static void main(String[]args) {
		Discente aluno = new Discente("Augusto", "augusto@ufma.br", "123");
		Docente prof = new Docente("Tereza", "Tereza@ufma.br", "456");
		
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Professor: " + prof.getNome());
        System.out.println("Teste concluído!");
	
		System.out.println(aluno);
		System.out.println(prof);
	} 
}
