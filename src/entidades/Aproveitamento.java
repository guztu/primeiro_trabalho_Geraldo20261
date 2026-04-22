package entidades;

import java.io.File;

public class Aproveitamento {
	public boolean uploadCertificado(File file){
		System.out.println("Arquivo " + file.getName() + "enviada");
		return true;
	}
}
