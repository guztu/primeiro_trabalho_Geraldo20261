package terminal;

import entidades.*;
import servicos.*;
import enums.*;
import java.util.Scanner;
import java.util.List;

public class SistemaTerminal {
    private static Usuario usuarioLogado = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // inicializar dados de exemplo
        inicializarDados();
        
        while (true) {
            if (usuarioLogado == null) {
                exibirMenuVisitante();
            } else {
                // chama o menu específico do usuário ??polimorfismo
                boolean continuar = usuarioLogado.exibirMenu();
                if (!continuar) {
                    usuarioLogado = null;
                    System.out.println("Logout realizado com sucesso.");
                }
            }
        }
    }

    private static void exibirMenuVisitante() {
        System.out.println("\n===== SISTEMA DE EXTENSÃO =====");
        System.out.println("1. Login");
        System.out.println("2. Cadastrar novo discente");
        System.out.println("3. Validar certificado (público)");
        System.out.println("4. Sair");
        System.out.print("Escolha: ");
        
        int opcao = lerInteiro();
        switch (opcao) {
            case 1:
                fazerLogin();
                break;
            case 2:
                cadastrarDiscente();
                break;
            case 3:
                validarCertificadoPublico();
                break;
            case 4:
                System.out.println("Encerrando sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void fazerLogin() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        usuarioLogado = UsuarioService.login(email, senha).orElse(null);
       // usuarioLogado = UsuarioService.login(email, senha);
        if (usuarioLogado == null) {
            System.out.println("Email ou senha incorretos.");
        } else {
            System.out.println("Bem-vindo, " + usuarioLogado.getNome() + "!");
        }
    }

    private static void cadastrarDiscente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        Discente novo = new Discente(nome, email, senha);
        UsuarioService.cadastrar(novo);
        System.out.println("Discente cadastrado com sucesso!");
    }

    private static void validarCertificadoPublico() {
        System.out.print("Digite o código hash do certificado: ");
        String hash = scanner.nextLine();
        Certificado cert = CertificadoService.buscarPorHash(hash);
        if (cert != null) {
            System.out.println("Certificado VÁLIDO!");
            System.out.println("Descrição: " + cert.getDescricao());
            System.out.println("Carga horária: " + cert.getHoras());
            System.out.println("Emitido em: " + cert.getData_emissao());
        } else {
            System.out.println("Certificado INVÁLIDO ou não encontrado.");
        }
    }

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número: ");
            }
        }
    }
    
    
    //PARA TESTE
    private static void inicializarDados() {
        // Criar alguns usuários de exemplo
        Discente aluno1 = new Discente("João Silva", "joao@email.com", "123");
        Docente prof1 = new Docente("Maria Santos", "maria@email.com", "456");
        Coordenador coord1 = new Coordenador("Carlos Lima", "carlos@email.com", "789");
        Administrador admin1 = new Administrador("Admin", "admin@email.com", "admin");
        
        UsuarioService.cadastrar(aluno1);
        UsuarioService.cadastrar(prof1);
        UsuarioService.cadastrar(coord1);
        UsuarioService.cadastrar(admin1);
        
        // Criar uma oportunidade exemplo
        OportunidadeService.criarOportunidades("EXT001", "Curso de POO", 
                TipoOportunidade.CURSO, Modalidade.REMOTO, 40, 20,
                java.time.LocalDate.now(), java.time.LocalDate.now().plusMonths(2),
                aluno1, prof1);
        
        // Publicar a oportunidade para teste
        Oportunidade opp = OportunidadeService.buscarPorId("EXT001");
        if (opp != null) {
            OportunidadeService.publicarOportunidade(opp);
        }
        
        System.out.println("Dados iniciais carregados.");
    }
}