package oo1.ej13.ejercicio13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDeCorreo {
	private List<Carpeta> carpetas;
	private Carpeta inbox;
	
	public ClienteDeCorreo() {
		carpetas = new ArrayList<Carpeta>();
		inbox = new Carpeta("Inbox");
		carpetas.add(inbox);
	}
	
	/**
	 *  Devuelve una lista con todas las carpetas que contiene el cliente.
	 */
	public List<Carpeta> getCarpetas(){
		return this.carpetas;
	}
	
	/**
	 * Crea una carpeta nueva con el título recibido por parámetro y la añade a la colección de carpetas.
	 */
	public void crearCarpeta(String titulo) {
		carpetas.add(new Carpeta(titulo));
	}
	
	/**
	 * Agrega una carpeta a la lista de carpetas del cliente.
	 */
	public void agregarCarpeta(Carpeta carpeta) {
		carpetas.add(carpeta);
	}
	
	/**
	 * Devuelve la carpeta donde se encuentra el mail solicitado 
	 */
	public Carpeta getCarpeta(Email mail) {
		return this.carpetas.stream().filter(carpeta -> carpeta.contieneEmail(mail)).findFirst().orElse(null);
	}
	
	/**
	 * Recibe un email como parámetro y lo guarda en la carpeta "Inbox".
	 */
	public void recibir(Email email) {
		inbox.guardarEmail(email);
	}
	
	/**
	 * Mueve el email desde la carpeta origen hacia la carpeta destino.
	 */
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		destino.guardarEmail(email);
		origen.borrarEmail(email);
	}
	
	
	/**
	 * Retorna el  primer email que contenga el texto especificado por parámetro. De no existir, retorna null.
	 */
	public Email buscar(String texto) {
		// Revisar. Antes lo había implementado con findFirst y no anduvo bien.
		return this.carpetas.stream().map(carpeta -> carpeta.buscar(texto)).collect(Collectors.toList()).get(0);
	}
	
	/*
	 * Borra el email recibido por parámetro, considerando que existe
	 * */
	public void borrarEmail(Email email) {
		this.getCarpeta(email).borrarEmail(email);;
	}
	
	/**
	 * Devuelve un integer que indica el espacio total de ocupado por todas las carpetas con sus respectivos emails.
	 */
	public int espacioOcupado() {
		return this.carpetas.stream().mapToInt(carpeta -> carpeta.espacioOcupado()).sum();
	}
	

	
	
	
}
