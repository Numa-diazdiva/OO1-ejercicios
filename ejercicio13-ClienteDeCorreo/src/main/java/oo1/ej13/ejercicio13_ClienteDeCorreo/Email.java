package oo1.ej13.ejercicio13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {
	String titulo;
	String cuerpo;
	List<Archivo> archivos;

	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.archivos = new ArrayList<Archivo>();
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> adjuntos(){
		return this.archivos;
	}
	
	public void adjuntarArchivo(Archivo archivo) {
		this.archivos.add(archivo);
	}
	
	public int espacioOcupado() {
		int espacio = this.archivos.stream().mapToInt(archivo -> archivo.tamaño()).sum();
		espacio += this.titulo.length() + this.cuerpo.length();
		return espacio;
	}
	
}
