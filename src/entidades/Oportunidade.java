package entidades;
//ATRIBUTOS PRIVADO
//CONSTRUTOR COM PARAMETROS "PRINCIPAIS"
//GETS E SETS
import java.time.LocalDate;
import enums.*;
public class Oportunidade {
	private boolean ativo;
	private String descricao;
	private TipoOportunidade tipo;
	private Modalidade modalidade;
	private int cargaHoraria;
	private int vagas;
	private StatusOportunidade status;
	private LocalDate inicio;
	private LocalDate fim;
	private Usuario autor;
	private Docente responsavel;
	
	public Oportunidade(boolean ativo, String descricao, TipoOportunidade tipo, Modalidade modalidade, int cargaHoraria,
			int vagas, StatusOportunidade status, LocalDate inicio, LocalDate fim, Usuario autor, Docente responsavel) {
		this.ativo = true;
		this.descricao = descricao;
		this.tipo = tipo;
		this.modalidade = modalidade;
		this.cargaHoraria = cargaHoraria;
		this.vagas = vagas;
		this.status = status;
		this.inicio = inicio;
		this.fim = fim;
		this.autor = autor;
		this.responsavel = responsavel;
	}

	public StatusOportunidade getStatus() {
		return status;
	}

	public void setStatus(StatusOportunidade status) {
		this.status = status;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	

}
