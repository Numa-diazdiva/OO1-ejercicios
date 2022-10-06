package oo1.ej13.ejercicio13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<Email>();
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Email> getEmails() {
		return this.emails;
	}
	
	public int getCantItems() {
		return this.emails.size();
	}
	
	public Email buscar(String texto) {
		// findFirst devuelve un Optional que puede contener un objeto o nada si no encontró nada
		return this.emails.stream().filter(email -> email.contieneTexto(texto)).findFirst().orElse(null);
	}
	
	public void guardarEmail(Email email) {
		this.emails.add(email);
	}
	
	public void borrarEmail(Email email) {
		// Solución para buscarlo por título 
		// List<Email> mails = this.emails.stream().filter(email -> email.getTitulo().contains(titulo)).collect(Collectors.toList());
		this.emails.remove(email);
	}
	
	public boolean contieneEmail(Email mail) {
		return this.emails.contains(mail);
	}
	
	public int espacioOcupado() {
		return emails.stream().mapToInt(email -> email.espacioOcupado()).sum();
	}
	

	
}
