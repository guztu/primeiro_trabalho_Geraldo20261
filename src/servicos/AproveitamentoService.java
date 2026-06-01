package servicos;

import entidades.Discente;

public class AproveitamentoService {
    public static void solicitar(Discente discente, String descricao, int horas, String arquivo) {
        System.out.println("Solicitação registrada: " + descricao + " - " + horas + "h");
        // Armazenar em lista (opcional)
    }
}