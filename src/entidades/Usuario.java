package entidades;
//ATRIBUTOS PRIVADO
//CONSTRUTOR COM PARAMETROS "PRINCIPAIS"
//GETS E SETS
//import enums.Papel;	

public abstract class Usuario {
	private String nome;
	private String email;
	private String senha;
	private boolean ativo;
	
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ativo = true;
		
	}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	
	public void mudarSenha(String novaSenha){
		this.senha = novaSenha;
		System.out.println("Senha Alterada.");
	}
	public void ObterOportunidade(String idOportunidade){
		System.out.println("Buscando Oportunidade com ID" + idOportunidade);
		

	}
	//menu das subclasse
	public abstract boolean exibirMenu();
	public boolean isAtivo() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
