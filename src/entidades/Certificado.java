package entidades;

import enums.StatusAssinatura;
import java.time.LocalDate;

public class Certificado {
	private String unit_hash;
	private String descricao;
	private LocalDate data_emissao;
	private int horas;
	private String certificado_path;
	private StatusAssinatura status_assinatura;
	
	public Certificado(String unit_hash, String descricao, LocalDate data_emissao, int horas, String certificado_path,
			StatusAssinatura status_assinatura) {
		this.unit_hash = unit_hash;
		this.descricao = descricao;
		this.data_emissao = data_emissao;
		this.horas = horas;
		this.certificado_path = certificado_path;
		this.status_assinatura = status_assinatura;
	}
	
	public String geraQRCode(){
		return "QRCode_simulado" + unit_hash;
	}
	public boolean verificarAutoridadeHash() {
		return true;
	}

}
