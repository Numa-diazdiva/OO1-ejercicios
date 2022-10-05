package oo1.ej13.ejercicio13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDeCorreo {
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		carpetas = new ArrayList<Carpeta>();
		Carpeta inbox = new Carpeta("Inbox");
		carpetas.add(inbox);
	}
	
	public void recibir(Email email) {
		Carpeta inbox = carpetas.get(0); // Debería contemplar que se cambie de lugar?
		inbox.guardarEmail(email);
	}
	
	// Mueve el email de origen a destino asumiendo que el mail se encuentra sí o sí en origen
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		// Dejo que esta clase gestione los eventos, o creo un método transferirEmail en las carpetas?
		destino.guardarEmail(email);
		origen.borrarEmail(email);
	}
	
	public Email buscar(String texto) {
		// Debería iterar tradicionalmente para salir antes de la búsqueda?
		List<Email> emails = this.carpetas.stream().map(carpeta -> carpeta.buscar(texto)).collect(Collectors.toList());
		return emails.get(0);
	}
	
	public int espacioOcupado() {
		return this.carpetas.stream().mapToInt(carpeta -> carpeta.espacioOcupado()).sum();
	}
	
	
	
}
