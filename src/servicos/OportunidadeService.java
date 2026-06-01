package servicos;
import entidades.*;

import enums.Modalidade;
import enums.TipoOportunidade;
import enums.*; // puxa todas a entidades


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class OportunidadeService {
	
	private static List<Oportunidade> oportunidades = new ArrayList<>();
	
	public static void criarOportunidades(String id, String descricao, TipoOportunidade tipo,Modalidade modalidade,int cargaHoraria,int vagas, LocalDate inicio, LocalDate fim, Usuario autor,Docente responsavel) {
		Oportunidade opp = new Oportunidade(id, descricao, tipo, modalidade, cargaHoraria, vagas, StatusOportunidade.PENDENTE, inicio, fim, autor, responsavel);
		oportunidades.add(opp);
		System.out.println("Oportunidade criada com status Pendente. Aguardando publicação");
	}
	
	public static List<Oportunidade> listarPorStatus(StatusOportunidade status){
		return oportunidades.stream().filter(o -> o.getStatus() == status).collect(Collectors.toList());
		
	}
	public static void publicarOportunidade(Oportunidade opp){
		opp.publicar();
	}
	public static void inscreverDiscente(Oportunidade opp, Discente d){
		opp.inscrever(d);
	}
	
	public static List<Oportunidade> listarTodas(){
		return new ArrayList<>(oportunidades);
	}
	
	public static Oportunidade buscarPorId(String id){
		return oportunidades.stream().filter(o -> o.getStatus().equals(id)).findFirst().orElse(null);
		
	}
}
