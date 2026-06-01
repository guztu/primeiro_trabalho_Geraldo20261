package entidades;

import java.util.List;
import java.util.Scanner;

import enums.StatusOportunidade;
import servicos.AproveitamentoService;
import servicos.OportunidadeService;



public class Discente extends Usuario {

	public Discente(String nome, String email, String senha) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public boolean exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n===== MENU DISCENTE =====");
            System.out.println("1. Listar oportunidades abertas");
            System.out.println("2. Inscrever-se em oportunidade");
            System.out.println("3. Cancelar inscrição");
            System.out.println("4. Solicitar aproveitamento de horas externas");
            System.out.println("5. Ver meu progresso");
            System.out.println("6. Logout");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    listarOportunidadesAbertas();
                    break;
                case 2:
                    inscreverEmOportunidade(scanner);
                    break;
                case 3:
                    cancelarInscricao();
                    break;
                case 4:
                    solicitarAproveitamento(scanner);
                    break;
                case 5:
                    verProgresso();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
        
        return false;
    }
    
    private void listarOportunidadesAbertas(){
    	List<Oportunidade> abertas = OportunidadeService.listarPorStatus(StatusOportunidade.PUBLICADA);
    	if(abertas.isEmpty()){
    		System.out.println("Nenhuma oportunidade aberta no momento");
    	}else {
    		System.out.println("\n--- Oportunidades Abertas ---");
    		for(Oportunidade opp : abertas) {
    			System.out.println("ID:" + opp.getId() + "Titulo: " + opp.getDescricao() +
    								"Vagas: "+ opp.getVagas() + "CH: " + opp.getCargaHoraria());
    		}
    	}
    	
    }
    
    
    private void inscreverEmOportunidade(Scanner scanner){
    	listarOportunidadesAbertas();
    	System.out.println("\nDigite o ID da oportunidade: ");
    	String id = scanner.nextLine();
    	Oportunidade opp = OportunidadeService.buscarPorId(id);
    	if (opp==null) {
    		System.out.println("Oportunidade não encontrada");
    		return;
    	}
    	OportunidadeService.inscreverDiscente(opp, this);
    }
	
    private void listarMinhasInscricoes() {
        List<Oportunidade> todas = OportunidadeService.listarTodas();
        System.out.println("\n--- Minhas Inscrições ---");
        boolean tem = false;
        for (Oportunidade opp : todas) {
            if (opp.getInscritos().contains(this)) {
                System.out.println("ID: " + opp.getId() + " | " + opp.getDescricao() +
                                   " | Status: " + opp.getStatus() + " | CH: " + opp.getCargaHoraria());
                tem = true;
            }
        }
        if (!tem) {
            System.out.println("Você não está inscrito em nenhuma oportunidade.");
        }
    }

    private void cancelarInscricao() {
        listarMinhasInscricoes();
        System.out.print("Digite o ID da oportunidade para cancelar: ");
        String id = new Scanner(System.in).nextLine();
        Oportunidade opp = OportunidadeService.buscarPorId(id);
        if (opp == null) {
            System.out.println("Oportunidade não encontrada.");
            return;
        }
        if (opp.cancelarInscricao(this)) {
            System.out.println("Inscrição cancelada com sucesso!");
        } else {
            System.out.println("Falha: você não está inscrito nessa oportunidade.");
        }
    }  
    
/*    private void cancelarInscricao(Scanner scanner){
    	List<Oportunidade> todas = OportunidadeService.listarTodas();
    	System.out.println("\n--- Suas inscrições ---");
    	boolean temInscricao =  false;
    	for(Oportunidade opp : todas ) {
    		if(opp.getInscritos().contains(this)){
    			System.out.println("ID: " + opp.getId() + "Titulos: " + opp.getDescricao());
    			temInscricao  = true;
    		}	
    	}
    	if(!temInscricao){
    		System.out.println("Você não esta inscrito em nenhuma oportunidade");
    		return;
    	}
    	System.out.println("Digite o Id da oportunidade para cancelar a inscricao: ");
    	String id = scanner.nextLine();
    	Oportunidade opp = OportunidadeService.buscarPorId(id);
    	if(opp == null) {
    		System.out.println("Oportunidade não encontrada");
    		return;
    	}
    	opp.cancelarInscricao(this);
    } */
    
    private void solicitarAproveitamento(Scanner scanner) {
    	//simulação
    	System.out.println("Funcionalidade em desenvolvimento.");
    	System.out.println("\n---Solicitação de Aproveitamento de Horas Externas ---");
    	System.out.print("Descrição da atividade: ");
    	String descricao  = scanner.nextLine();
    	System.out.print("Descrição da atividade: ");
    	int horas = Integer.parseInt(scanner.nextLine());
        String arquivo = scanner.nextLine();

      //serviço de aproveitamento definir depois)
        AproveitamentoService.solicitar(this, descricao, horas, arquivo);
        System.out.println("Solicitação enviada para análise do coordenador.");
    	
    }
    
   /* private void verProgresso() {       
        //simulação
    	System.out.println("Funcionalidade em desenvolvimento.");
        System.out.println("\n--- Seu Progresso ---");
        System.out.println("Total de horas concluídas: " + getHorasConcluidas());
        System.out.println("Horas pendentes para o PPC (345h): " + (345 - getHorasConcluidas()));
        
        
    }*/
    private void verProgresso() {
        int totalHoras = 0;
        List<Oportunidade> todas = OportunidadeService.listarTodas();
        for (Oportunidade opp : todas) {
            // Só conta oportunidades ENCERRADAS em que o discente está inscrito
            if (opp.getStatus() == StatusOportunidade.ENCERRADA && opp.getInscritos().contains(this)) {
                totalHoras += opp.getCargaHoraria();
            }
        }
        
        System.out.println("\n===== MEU PROGRESSO =====");
        System.out.println("Horas concluídas: " + totalHoras + "h");
        int meta = 345; // carga horária mínima do curso (exemplo)
        System.out.println("Meta exigida: " + meta + "h");
        if (totalHoras >= meta) {
            System.out.println("PARABÉNS! Você já atingiu a meta.");
        } else {
            System.out.println("Faltam " + (meta - totalHoras) + " horas para completar a meta.");
        }
    }

    private int getHorasConcluidas() {
        int total = 0;
        for (Oportunidade opp : OportunidadeService.listarTodas()) {
            if (opp.getStatus() == StatusOportunidade.ENCERRADA && opp.getInscritos().contains(this)) {
                total += opp.getCargaHoraria();
            }
        }
        // somar também solicitações aprovadas
        return total;
    }
    
    
    
    
}
