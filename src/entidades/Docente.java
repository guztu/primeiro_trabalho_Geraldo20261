package entidades;

import servicos.*;
import enums.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Docente extends Usuario {
    public Docente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public boolean exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n===== MENU DOCENTE =====");
            System.out.println("1. Criar oportunidade");
            System.out.println("2. Listar minhas oportunidades");
            System.out.println("3. Publicar oportunidade");
            System.out.println("4. Encerrar oportunidade");
            System.out.println("5. Logout");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    criarOportunidade();
                    break;
                case 2:
                    listarMinhasOportunidades();
                    break;
                case 3:
                    publicarOportunidade();
                    break;
                case 4:
                    encerrarOportunidade();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
        return false;
    }

    private void criarOportunidade() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Carga horária: ");
        int ch = Integer.parseInt(scanner.nextLine());
        System.out.print("Vagas: ");
        int vagas = Integer.parseInt(scanner.nextLine());
        
        OportunidadeService.criarOportunidades(id, descricao, TipoOportunidade.CURSO,
                Modalidade.PRESENCIAL, ch, vagas, LocalDate.now(), LocalDate.now().plusMonths(1),
                this, this);
        System.out.println("Oportunidade criada com sucesso!");
    }

    private void listarMinhasOportunidades() {
        // Implementar filtro por autor
        System.out.println("Funcionalidade em desenvolvimento.");
    }

    private void publicarOportunidade() {
        System.out.print("Digite o ID da oportunidade: ");
        String id = new Scanner(System.in).nextLine();
        Oportunidade opp = OportunidadeService.buscarPorId(id);
        if (opp == null) {
            System.out.println("Oportunidade não encontrada.");
            return;
        }
        OportunidadeService.publicarOportunidade(opp);
    }

    private void encerrarOportunidade() {
        System.out.print("Digite o ID da oportunidade: ");
        String id = new Scanner(System.in).nextLine();
        Oportunidade opp = OportunidadeService.buscarPorId(id);
        if (opp == null) {
            System.out.println("Oportunidade não encontrada.");
            return;
        }
        opp.setStatus(StatusOportunidade.ENCERRADA);
        System.out.println("Oportunidade encerrada.");
    }
}