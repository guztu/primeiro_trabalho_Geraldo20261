package entidades;
//ATRIBUTOS PRIVADO
//CONSTRUTOR COM PARAMETROS "PRINCIPAIS"
//GETS E SETS
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import enums.*;

public class Oportunidade {
	private String id;
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
	
	private List<Discente> inscritos;
	
	public Oportunidade(String id, String descricao, TipoOportunidade tipo, Modalidade modalidade, int cargaHoraria,
			int vagas, StatusOportunidade status, LocalDate inicio, LocalDate fim, Usuario autor, Docente responsavel) {
		this.id = id;
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
		this.inscritos = new ArrayList<>();
	}

    // Getters e Setters // melhor para visualizar
    public String getId(){ return id; }
    public String getDescricao() { return descricao; }
    public TipoOportunidade getTipo() { return tipo; }
    public Modalidade getModalidade() { return modalidade; }
    public int getCargaHoraria() { return cargaHoraria; }
    public int getVagas() { return vagas; }
    public StatusOportunidade getStatus() { return status; }
    public void setStatus(StatusOportunidade status) { this.status = status; }
    public LocalDate getInicio() { return inicio; }
    public LocalDate getFim() { return fim; }
    public Usuario getAutor() { return autor; }
    public Docente getResponsavel() { return responsavel; }
    public List<Discente> getInscritos() { return inscritos; }
	
	
	
	//inscrever discente
	public void inscrever(Discente d){
		if(this.vagas> 0 && this.status == StatusOportunidade.PUBLICADA){
			inscritos.add(d);
			this.vagas--;
			System.out.println(d.getNome() + " inscrito com sucesso!");
			
		}else {
			System.out.println("Inscriçao não permitida(vagas esgotadas ou fechadas)");
		}
	}
	
	//cancelar inscricao
	public boolean cancelarInscricao(Discente d){
		if(inscritos.remove(d)){
			System.out.println("Inscrição cancelada");
			return true;
		}else {
			System.out.println("Discente não está Inscrito");
			return false;
		}
		
	}
	
	public void publicar(){
		if(this.status == StatusOportunidade.PENDENTE) {
			this.status = StatusOportunidade.PUBLICADA;
			System.out.println("Oportunidade publica!");
		}else {
			System.out.println("Não é possivel publicar. Status atual:" + this.status);
		}
	
		
	}


}
