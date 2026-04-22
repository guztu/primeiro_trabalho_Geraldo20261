package entidades;
//ATRIBUTOS PRIVADO
//CONSTRUTOR COM PARAMETROS "PRINCIPAIS"
//GETS E SETS
//import	enums.Papel;	

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	//private Papel papel;
	private boolean ativo;
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		//this.papel = papel;
		this.ativo = true;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	public Papel getPapel() {
	//	return papel;
	//}

	//public void setPapel(Papel papel) {
		//this.papel = papel;
	//}
	
	public void mudarSenha(String novaSenha){
		this.senha = novaSenha;
	}
	public void ObterOportunidade(String idOportunidade){
		System.out.println("Buscando Oportunidade com ID" + idOportunidade);
	}
	
}
