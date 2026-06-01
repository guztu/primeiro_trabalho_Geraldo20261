package servicos;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entidades.*;

public class UsuarioService {
	private static List<Usuario> usuarios = new ArrayList<>(); 
	
	//cria usuario generico
	public static void cadastrar(Usuario u){
		usuarios.add(u);
		System.out.println("Usuário" + u.getNome() + "cadastrado com sucesso.");
	}
	//acesso ?? entender essa parte
	public static Optional<Usuario> login(String email, String senha){
		return usuarios.stream()
				.filter(u->u.getEmail().equals(email) && u.getSenha().equals(senha)).
				findFirst();
	}
	
	//buscar por email ?? entender
	public static Usuario buscarPorEmail(String email){
		return usuarios.stream().filter(u->u.getEmail().equals(email)).findFirst().orElse(null);
	}
	
	//listar docentes ?? entender
	 public static List<Docente>listarDocentes(){
		 List<Docente> docentes = new ArrayList<>();
		 for(Usuario u: usuarios) {
			 if(u instanceof Docente){
				 docentes.add((Docente) u); //cast?
			 }
		 }
		 return docentes;
	 }
	 
	    // Buscar por tipo (ex: listar docentes)
	    public static List<Docente> listarDocentesPorTipo() {
	        return usuarios.stream()
	            .filter(u -> u instanceof Docente)
	            .map(u -> (Docente) u)
	            .toList();
	    }
	 
	    // inicializar alguns usuários para teste
	    public static void inicializarDados() {
	        if (usuarios.isEmpty()) {
	            cadastrar(new Discente("Aluno Teste", "aluno@ufma.br", "123"));
	            cadastrar(new Docente("Professor Teste", "prof@ufma.br", "456"));
	            cadastrar(new Coordenador("Coordenador Teste", "coord@ufma.br", "789"));
	            cadastrar(new Administrador("Admin Teste", "admin@ufma.br", "admin"));
	        }
	    }
	
}
