package oo1.ej13.ejercicio13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		List<Email> mails = this.emails.stream().filter(email -> email.getTitulo().contains(texto)).collect(Collectors.toList());
		if (mails.size() > 0) {
			mails = this.emails.stream().filter(email -> email.getCuerpo().contains(texto)).collect(Collectors.toList());
		}
		return mails.get(0);
	}
	
	public void guardarEmail(Email email) {
		this.emails.add(email);
	}
	
	public void borrarEmail(Email email) {
		// List<Email> mails = this.emails.stream().filter(email -> email.getTitulo().contains(titulo)).collect(Collectors.toList());
		emails.remove(email);
	}
	
	public int espacioOcupado() {
		int espacio = emails.stream().mapToInt(email -> email.espacioOcupado()).sum();
		return espacio;
	}
	
	
}
